package de.onsite.ood.datapump;

import org.junit.Test;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class TogglingDataPump2Test {
    private final DatabaseStore dbStore = mock(DatabaseStore.class);
    private final TextStore textStore = mock(TextStore.class);
    private final LotteryPrediction prediction = createPrediction();

    @Test
    public void saveStoresDataInTheDbStore() {
        new TogglingDataPump(dbStore, textStore).store(prediction);

        verify(dbStore).save(anyLong(), eq(prediction));
    }

    @Test
    public void saveStoresDataInTheTextStoreOnFailureOfDbStore() {
        doThrow(IllegalStateException.class)
                .when(dbStore)
                .save(anyLong(), any(LotteryPrediction.class));

        new TogglingDataPump(dbStore, textStore).store(prediction);

        verify(textStore).write(prediction.toString());
    }

    @Test
    public void afterExceptionTextStoreGetsUsedForNext10Tries() {
        doThrow(IllegalStateException.class)
                .when(dbStore)
                .save(anyLong(), any(LotteryPrediction.class));

        TogglingDataPump pump = new TogglingDataPump(dbStore, textStore);
        for (int i = 10; i != 0; i--)
            pump.store(createPrediction());

        verify(dbStore).save(anyLong(), any(LotteryPrediction.class));
        verify(textStore, times(10)).write(anyString());
    }

    @Test
    public void dbGetsTriedOn11thAttempt() {
        doThrow(IllegalStateException.class)
                .doNothing()
                .when(dbStore)
                .save(anyLong(), any(LotteryPrediction.class));

        TogglingDataPump pump = new TogglingDataPump(dbStore, textStore);
        for (int i = 11; i != 0; i--)
            pump.store(createPrediction());

        verify(dbStore,times(2)).save(anyLong(), any(LotteryPrediction.class));
        verify(textStore, times(10)).write(anyString());
    }

    private LotteryPrediction createPrediction() {
        return new LotteryPrediction(new Date(), asList(1, 23));
    }

}
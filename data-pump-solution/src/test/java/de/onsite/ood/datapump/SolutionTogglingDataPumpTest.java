package de.onsite.ood.datapump;

import org.junit.Test;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SolutionTogglingDataPumpTest {

    private final DataPump primary = mock(DataPump.class);
    private final DataPump secondary = mock(DataPump.class);
    private final SolutionTogglingDataPump dataPump = new SolutionTogglingDataPump(primary, secondary);


    private LotteryPrediction prediction = new LotteryPrediction(new Date(), asList(23, 45, 6, 12, 11, 49));

    @Test
    public void simpleStoreStoresInPrimary() {
        dataPump.store(prediction);

        verify(primary).store(prediction);
        verify(secondary, never()).store(any(LotteryPrediction.class));
    }

    @Test
    public void afterAnExceptionTrafficGetsRedirectedToSecondary() {
        doThrow(new RuntimeException("error")).when(primary).store(any(LotteryPrediction.class));

        dataPump.store(prediction);

        verify(primary).store(prediction);
        verify(secondary).store(prediction);
    }

    @Test
    public void afterAnExceptionTrafficGetsRedirectedToSecondaryFor10calls() {
        doThrow(new RuntimeException("error")).doNothing().when(primary).store(any(LotteryPrediction.class));

        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);
        dataPump.store(prediction);

        verify(secondary, times(10)).store(prediction); // first to tenth
        verify(primary, times(2)).store(prediction); // first and 11th
    }


}
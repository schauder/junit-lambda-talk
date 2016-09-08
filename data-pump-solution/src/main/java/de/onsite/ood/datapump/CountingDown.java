package de.onsite.ood.datapump;

public class CountingDown implements SwitchingDataPump {
    private final DataPump secondary;
    private final SwitchingDataPump primary;
    private int useCounter = 10;

    public CountingDown(DataPump secondary, SwitchingDataPump primary) {
        this.secondary = secondary;
        this.primary = primary;
    }

    @Override
    public SwitchingDataPump store(LotteryPrediction prediction) {
        secondary.store(prediction);
        useCounter--;
        return useCounter <= 0 ? primary : this;
    }
}

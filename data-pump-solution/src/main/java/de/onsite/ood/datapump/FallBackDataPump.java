package de.onsite.ood.datapump;

public class FallBackDataPump implements SwitchingDataPump {
    private final DataPump primary;
    private final DataPump secondary;

    public FallBackDataPump(DataPump primary, DataPump secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    @Override
    public SwitchingDataPump store(LotteryPrediction prediction) {
        try {
            primary.store(prediction);
        } catch (Exception ex) {
            CountingDown countingDown = new CountingDown(secondary, this);

            return countingDown.store(prediction);
        }
        return this ;
    }
}

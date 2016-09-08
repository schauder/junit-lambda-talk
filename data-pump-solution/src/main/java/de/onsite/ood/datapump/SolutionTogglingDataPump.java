package de.onsite.ood.datapump;

/**
 * Standardmässig soll ein DatabaseStore verwendet werden.
 *
 * Wirft dieser eine Exception soll für die
 * nächsten 10 Aufrufe ein TextStore verwendet werden.
 *
 */
public class SolutionTogglingDataPump implements DataPump {

    private SwitchingDataPump current;

    public SolutionTogglingDataPump(DataPump primary, DataPump secondary) {
        current = new FallBackDataPump( primary, secondary);
    }

    public void store(LotteryPrediction prediction) {
        current = current.store(prediction);
    }



}

package de.onsite.ood.datapump;

/**
 * Bitte implentieren
 * <p>
 * Standardmässig soll ein DatabaseStore verwendet werden.
 * <p>
 * Wirft dieser eine Exception soll für die nächsten 10 Aufrufe ein TextStore verwendet werden.
 */
class TogglingDataPump implements DataPump {
    private final DataPump primary;
    private final DataPump secondary;
    private int useTextStoreCount = 0;

    TogglingDataPump(DatabasePump primary, TextPump secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    public void store(LotteryPrediction prediction) {
        if (useTextStoreCount > 0) {
            writeToTextFile(prediction);
        } else {
            try {
                primary.store(prediction);
            } catch (IllegalStateException ise) {
                useTextStoreCount = 10;
                writeToTextFile(prediction);
            }
        }
    }

    private void writeToTextFile(LotteryPrediction prediction) {
        secondary.store(prediction);
        useTextStoreCount--;
    }
}

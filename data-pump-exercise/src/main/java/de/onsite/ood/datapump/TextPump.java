package de.onsite.ood.datapump;

import java.io.File;

public class TextPump implements DataPump {
    private final TextStore store;

    public TextPump(File file) {
        this.store = new TextStore(file);
    }

    @Override
    public void store(LotteryPrediction prediction) {
        store.write(prediction.toString());
    }
}

package de.onsite.ood.datapump2;

public class TextStrategy implements StoreStrategy {
    private final TextStore store;

    public TextStrategy(TextStore textStore) {
        this.store = textStore;
    }

    @Override
    public void store(LotteryPrediction prediction) {
        store.write(prediction.toString());
    }
}

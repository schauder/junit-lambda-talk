package de.onsite.ood.datapump2;

public class DatabaseStrategy implements StoreStrategy {
    private final DatabaseStore store;

    public DatabaseStrategy(DatabaseStore databaseStore) {
        this.store = databaseStore;
    }

    @Override
    public void store(LotteryPrediction prediction) {
            store.save(prediction.date.getTime(),prediction);
    }
}

package de.onsite.ood.datapump;

public class DatabasePump implements DataPump {
    private final DatabaseStore store;

    public DatabasePump(String user, String password, String jdbcurl) {
        this.store = new DatabaseStore(user, password, jdbcurl);
    }

    @Override
    public void store(LotteryPrediction prediction) {
            store.save(prediction.date.getTime(),prediction);
    }
}

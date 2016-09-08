package de.onsite.ood.datapump2;

import java.util.ArrayList;
import java.util.List;

class PredictionService {
    private final StoreStrategy store;
    private final List<PredictionServiceListener> listeners = new ArrayList<>();

    PredictionService(StoreStrategy store) {
        this.store = store;
    }

    public void register(PredictionServiceListener listener) {
        listeners.add(listener);
    }

    public void deregister(PredictionServiceListener listener) {
        listeners.remove(listener);
    }

    public void handle(LotteryPrediction prediction) {
        fireEvent(prediction);

        // irgendwas
        store.store(prediction);
        // irgendwas
    }

    private void fireEvent(LotteryPrediction prediction) {
        for (PredictionServiceListener listener : listeners){
            listener.predictionHandled(prediction);
        }
    }
}

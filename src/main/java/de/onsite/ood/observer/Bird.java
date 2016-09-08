package de.onsite.ood.observer;

import java.util.ArrayList;
import java.util.List;

// tag::example[]
class Bird {
    private List<BirdListener> listeners = new ArrayList<>();

    void sing(){
        System.out.println("Tschilp, Tschilp");
        notifyListeners();
    }

    void register(BirdListener listener){
        listeners.add(listener);
    }

    void deregister(BirdListener listener){
        listeners.remove(listener);
    }


    private void notifyListeners() {
        for (BirdListener listener : listeners) {
            listener.notifyBirdIsSinging(this);
        }
    }
}
// tag::example[]

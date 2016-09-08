package de.onsite.ood.polymorphism.condition;

public class AnimalSoundManager {
    //tag::example[]
    String makeSound(Animal animal){
        if (animal instanceof Cat) {
            return "Miau";
        } else {
            return "Wau Wau";
        }
    }
    //end::example[]
}

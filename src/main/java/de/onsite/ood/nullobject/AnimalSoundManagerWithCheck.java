package de.onsite.ood.nullobject;

public class AnimalSoundManagerWithCheck {
    //tag::example[]
    String makeSound(Animal animal){
        if (animal == null) return "";
        return animal.giveSound();
    }
    //end::example[]
}

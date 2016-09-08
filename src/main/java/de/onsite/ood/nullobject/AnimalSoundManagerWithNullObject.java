package de.onsite.ood.nullobject;

public class AnimalSoundManagerWithNullObject {
    //tag::example[]
    String makeSound(Animal animal){
        return animal.giveSound();
    }
    //end::example[]
}

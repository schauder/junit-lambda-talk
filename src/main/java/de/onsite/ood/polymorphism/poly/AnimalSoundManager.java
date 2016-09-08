package de.onsite.ood.polymorphism.poly;

public class AnimalSoundManager {
    //tag::example[]
    String makeSound(Animal animal){
        return animal.giveSound();
    }
    //end::example[]
}

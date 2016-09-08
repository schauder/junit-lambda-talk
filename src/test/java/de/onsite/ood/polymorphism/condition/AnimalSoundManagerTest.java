package de.onsite.ood.polymorphism.condition;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalSoundManagerTest {
    @Test
    public void aCatMakesMiau() {
        assertEquals("Miau", new AnimalSoundManager().makeSound(new Cat()));
    }

    @Test
    public void aDogMakesWauWau() {
        assertEquals("Wau Wau", new AnimalSoundManager().makeSound(new Dog()));
    }

}
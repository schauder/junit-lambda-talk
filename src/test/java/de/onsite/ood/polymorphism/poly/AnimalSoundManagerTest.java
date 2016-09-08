package de.onsite.ood.polymorphism.poly;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
package de.onsite.ood.money.solution;

import org.junit.Test;

import static de.onsite.ood.money.solution.Currency.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MoneyTest {

    @Test
    public void sameValuesAreEqual(){
        assertEquals(new Money(10, Euro), new Money(10, Euro));
        assertNotEquals(new Money(10, Euro), new Money(10, Yen));
        assertNotEquals(new Money(10, Euro), new Money(9, Euro));
    }

    @Test
    public void addingMoneyOfSameCurrency(){
        assertEquals(new Money(23, Euro), new Money(10, Euro).add(new Money(13, Euro)));
    }

    @Test
    public void addingMoneyOfDifferentCurrencies(){
        Converter converter = new Converter(Euro);
        converter.setRate(Dollar, 0.9);

        assertEquals(new Money(19, Euro), new Money(10, Euro).add(converter.to(new Money(10, Dollar), Euro)));
    }

    @Test
    public void addingMoneyOfDifferentCurrenciesNotEuro(){
        Money _1pound = new Money(1, Pound);
        Money _20dollar = new Money(20, Dollar);
        Money _10pound = new Money(10, Pound);

        Converter converter = new Converter(Euro);
        converter.setRate(Dollar, 0.9);
        converter.setRate(Pound, 2);

        assertEquals(_10pound, _1pound.add(converter.to(_20dollar, Pound)));
    }
}

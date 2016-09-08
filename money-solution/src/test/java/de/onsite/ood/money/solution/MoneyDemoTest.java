package de.onsite.ood.money.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static de.onsite.ood.money.solution.Currency.Euro;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyDemoTest {

    @Test
    public void weCanAddMoneyOfSameCurrency() {
        //Given
        Money m1 = new Money(23, Euro);
        Money m2 = new Money(12, Euro);

        //When
        Money sum = m1.add(m2);

        //Then
        assertEquals(35, sum.amount);
        assertEquals(Euro, sum.currency);
    }

    @Test
    public void testToString() {
        Money sum = new Money(35, Euro);

        assertEquals("[35Euro]", sum.toString());

    }

    @Test
    public void testDouble() {
        assertEquals(2.98, 1.5 * 2.0, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatAnExceptionIsThrown() {
        throw new IllegalArgumentException();

    }


    @Test
    public void sortTest() {
        List<String> strings = asList("eins", "zwei", "drei", "vier", "fünf", "sechs");
        Collections.sort(
                strings,
                (o1, o2) -> o2.length()- o1.length()
        );

        System.out.println(Arrays.toString(strings.toArray()));

    }

}

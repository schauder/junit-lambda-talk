package de.onsite.ood.money.solution;

import java.util.HashMap;
import java.util.Map;


/**
 * Kann Geld zwischen Währungen konvertieren.
 * <br>
 * Design Entscheidung: Kein Singleton.
 * Je nachdem wann und wo ich mein Geld eintausche, kann es völlig unterschiedliche Wechselkurse geben
 * <br>
 * Die Kurse werden einfach gesetzt.
 */
class Converter {
    private Map<Currency, Double> rates = new HashMap<Currency, Double>();
    private Currency baseCurrency;

    Converter(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
        rates.put(baseCurrency, 1.0);
    }

    void setRate(Currency currency, double euros) {
        assert currency != baseCurrency : "The exchange rate for the base currency is fixed to 1";
        rates.put(currency, euros);
    }

    Money to(Money money, Currency targetCurrency) {
        if ( money.currency == targetCurrency) return money;
        return new Money((long) ( // niemals monitäre Werte einfach runden wie hier. Das muss mit Fachexperten geklärt werden.
                money.amount
                        * rates.get(money.currency)
                        / rates.get(targetCurrency)
        ), targetCurrency);
    }
}

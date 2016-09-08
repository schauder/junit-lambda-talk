package de.onsite.ood.money.solution;

/**
 * Design Entscheidung: addieren von Fremdwährung
 * Wechselkurse sind keine inherente Eigenschaft von Geld, daher kann diese Klasse nur Geld gleicher Währung handeln.
 */
class Money {

    final long amount;
    final Currency currency;

    Money(long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;

        assert currency != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;
        return currency == money.currency;

    }

    @Override
    public int hashCode() {
        int result = (int) (amount ^ (amount >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    public Money add(Money other) {
        assert this.currency == other.currency : "Can add only Money of same currency, use Converter";
        return new Money(amount + other.amount, currency);
    }

    @Override
    public String toString() {
        return "[" + amount +
                currency +
                ']';
    }
}

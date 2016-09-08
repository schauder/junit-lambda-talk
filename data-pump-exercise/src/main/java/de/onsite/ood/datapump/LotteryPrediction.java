package de.onsite.ood.datapump;

import java.util.*;

import static java.util.Collections.unmodifiableList;

/**
 * Value Objekt zum speichern von Lottozahlenvorhersagen
 */
class LotteryPrediction {
    final Date date;
    final List<Integer> numbers;

    public LotteryPrediction(Date date, List<Integer> numbers) {
        this.date = date;
        this.numbers = unmodifiableList(new ArrayList<Integer>(numbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotteryPrediction that = (LotteryPrediction) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (numbers != null ? numbers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LotteryPrediction{" +
                "date=" + date +
                ", numbers=" + Arrays.toString(numbers.toArray()) +
                '}';
    }
}

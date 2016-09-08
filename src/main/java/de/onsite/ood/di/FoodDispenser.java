package de.onsite.ood.di;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
//tag::example[]
class FoodDispenser {
    private final Random random = new Random();
    private final List<String> foodOptions = asList("Meat", "Dry Food", "Grass");
    String getFood() {
        return foodOptions.get(random.nextInt(foodOptions.size()));
    }
}
//end::example[]
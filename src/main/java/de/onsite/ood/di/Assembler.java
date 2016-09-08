package de.onsite.ood.di;
//tag::example[]
public class Assembler {
    private FoodDispenser foodDispenser = new FoodDispenser();
    CatWithDi createCat(){
        return new CatWithDi(foodDispenser);
    }
}
//end::example[]
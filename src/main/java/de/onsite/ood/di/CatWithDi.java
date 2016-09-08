package de.onsite.ood.di;

//tag::example[]
class CatWithDi {
    private final FoodDispenser foodSource;

    CatWithDi(FoodDispenser foodSource) {
        this.foodSource = foodSource;
    }

    void eat(){
        System.out.println("Munching " + foodSource.getFood());
    }
}
//end::example[]

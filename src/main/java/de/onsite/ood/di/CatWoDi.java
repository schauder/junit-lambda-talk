package de.onsite.ood.di;

//tag::example[]
class CatWoDi {
    private final FoodDispenser foodSource = new FoodDispenser();
    void eat(){
        System.out.println("Munching " + foodSource.getFood());
    }
}
//end::example[]
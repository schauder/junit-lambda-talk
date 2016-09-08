package de.onsite.ood.nullobject;
//tag::example[]
enum NoAnimal implements Animal {
    NO_ANIMAL;

    @Override
    public String giveSound() {
        return "";
    }
    //end::example[]
}

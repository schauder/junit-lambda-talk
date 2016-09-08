package de.onsite.ood.observer;

// tag::example[]
class Human implements BirdListener {
    @Override
    public void notifyBirdIsSinging(Bird bird) {
        System.out.println("Enjoy singing bird");
    }
}
// tag::example[]

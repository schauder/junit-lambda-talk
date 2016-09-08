package de.onsite.ood.observer;

// tag::example[]
class Cat implements BirdListener {
    @Override
    public void notifyBirdIsSinging(Bird bird) {
        System.out.println("start hunting");
    }
}
// end::example[]

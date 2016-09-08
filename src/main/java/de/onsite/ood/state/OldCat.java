package de.onsite.ood.state;
//tag::example[]
class OldCat implements CatState {
    @Override
    public String howDoesItLook() { return "not good"; }

    @Override
    public CatState next() { return new DeadCat(); }
}
//end::example[]

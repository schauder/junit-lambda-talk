package de.onsite.ood.state;
//tag::example[]
class DeadCat implements CatState {
    @Override
    public String howDoesItLook() { return "bony"; }

    @Override
    public CatState next() { return this; }
}
//end::example[]

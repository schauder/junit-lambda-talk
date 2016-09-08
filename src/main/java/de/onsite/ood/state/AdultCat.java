package de.onsite.ood.state;
//tag::example[]
class AdultCat implements CatState {
    @Override
    public String howDoesItLook() { return "nice"; }

    @Override
    public CatState next() { return new OldCat(); }
}
//end::example[]
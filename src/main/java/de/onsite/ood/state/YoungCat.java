package de.onsite.ood.state;

//tag::example[]
class YoungCat implements CatState {
    @Override
    public String howDoesItLook() { return "incredible cute"; }

    @Override
    public CatState next() { return new AdultCat(); }
}
//end::example[]

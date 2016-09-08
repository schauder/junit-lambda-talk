package de.onsite.ood.state;

//tag::example[]
class Cat {
    private CatState state = new YoungCat();

    String howDoesItLook(){ return state.howDoesItLook(); }

    void timePasses(){ state = state.next(); }
}
//end::example[]
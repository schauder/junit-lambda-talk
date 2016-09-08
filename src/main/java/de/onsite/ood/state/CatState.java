package de.onsite.ood.state;
//tag::example[]
interface CatState {
    String howDoesItLook();

    CatState next();
}
//end::example[]

package de.onsite.ood.factorymethod;

//tag::example[]
public class MathTeacher implements Teacher{

    @Override
    public Problem createProblem() {
        return new MathProblem();
    }
}
//end::example[]
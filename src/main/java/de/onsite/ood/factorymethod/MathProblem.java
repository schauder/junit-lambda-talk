package de.onsite.ood.factorymethod;

//tag::example[]
class MathProblem implements Problem {
    @Override
    public void solve() {
        System.out.println("You are right! 2+4=3!");
    }
}
//end::example[]

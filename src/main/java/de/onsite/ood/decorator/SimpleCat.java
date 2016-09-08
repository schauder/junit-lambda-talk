package de.onsite.ood.decorator;

// tag::example[]
public class SimpleCat implements Cat {
    @Override
    public void run() {
        System.out.println("run, run, jump, run");
    }
}
// end::example[]

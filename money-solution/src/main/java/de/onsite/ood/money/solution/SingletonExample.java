package de.onsite.ood.money.solution;

public class SingletonExample {
    public static final SingletonExample instance = new SingletonExample();
    private String prefix = "aaa";

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public String prefix(String message) {
        return prefix + message;
    }

}

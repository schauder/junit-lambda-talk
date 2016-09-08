package de.onsite.ood.cache;

import java.io.Serializable;
import java.util.UUID;

public class Cat implements Serializable {
    final UUID id;

    private String name;


    public Cat(UUID id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

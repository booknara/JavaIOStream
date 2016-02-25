package com.github.booknara.javaiostream;

import java.io.Serializable;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 */
public class Person implements Serializable {
    double id;
    String name;
    String country;

    public Person(double id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "id : " + id + ", name : " + name + ", country : " + country;
    }
}

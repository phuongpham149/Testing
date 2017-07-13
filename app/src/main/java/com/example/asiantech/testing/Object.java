package com.example.asiantech.testing;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 29/06/2017.
 */
public class Object {
    private String name;
    private int old;

    public Object(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                ", old=" + old +
                '}';
    }
}

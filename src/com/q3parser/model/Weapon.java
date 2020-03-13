package com.q3parser.model;

public class Weapon implements WeaponInterface {

    private String name;

    private String color;

    public Weapon(String name) {
        this.name = name;
    }

    public Weapon(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

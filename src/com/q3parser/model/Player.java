package com.q3parser.model;

public class Player implements NameInterface {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

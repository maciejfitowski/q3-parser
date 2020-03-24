package com.q3parser.model;

import java.util.ArrayList;
import java.util.List;

public class Player implements NameInterface {

    private String name;

    private List<String> nicknames;

    public Player(String name) {
        this.name = name;

        this.nicknames = new ArrayList<>();
        this.nicknames.add(name);
    }

    public Player(String name, List<String> nicknames) {
        this.name = name;
        this.nicknames = nicknames;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public List<String> getNicknames() {
        return nicknames;
    }
}

package com.q3parser.model;

import java.util.List;

public class ParserResult {

    List<String> players;
    List<String> killLines;

    public ParserResult(List<String> players, List<String> killLines) {
        this.players = players;
        this.killLines = killLines;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getKillLines() {
        return killLines;
    }
}

package com.q3parser.model;

import java.util.ArrayList;

public class PlayerStats implements StatsInterface {

    private Player player;

    private ArrayList<Event> kills;

    private ArrayList<Event> deaths;

    public PlayerStats(Player player) {
        this.player = player;
        this.kills = new ArrayList<>();
        this.deaths = new ArrayList<>();
    }

    public void addKill(Event kill) {
        kills.add(kill);
    }

    public void addDeath(Event death) {
        deaths.add(death);
    }

    @Override
    public int getDeaths() {
        return deaths.size();
    }

    @Override
    public int getKills() {
        return kills.size();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public int getScore() {
        return getKills() - getDeaths();
    }
}

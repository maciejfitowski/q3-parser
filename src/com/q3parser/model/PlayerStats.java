package com.q3parser.model;

import java.util.*;

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

    public float getRatio() {
        return (float) getKills() / (float) getDeaths();
    }

    public HashMap<String, Integer> getWeaponCountMap() {
        HashMap<String, Integer> map = new HashMap<>();
        for (Event kill : this.kills) {
            WeaponInterface weapon = kill.getWeapon();
            map.merge(weapon.getName(), 1, Integer::sum);
        }

        return map;
    }

    public HashMap.Entry<String, Integer> getFavouriteWeaponEntry() {
        HashMap<String, Integer> map = getWeaponCountMap();

        HashMap.Entry<String, Integer> max = null;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
                max = entry;
            }
        }

        return max;
    }
}

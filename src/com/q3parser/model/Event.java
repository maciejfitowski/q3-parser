package com.q3parser.model;

public class Event {

    private Player killer;

    private Player victim;

    private WeaponInterface weapon;

    public Event(Player killer, WeaponInterface weapon, Player victim) {
        this.killer = killer;
        this.weapon = weapon;
        this.victim = victim;
    }

    public Player getKiller() {
        return killer;
    }

    public Player getVictim() {
        return victim;
    }

    public WeaponInterface getWeapon() {
        return weapon;
    }

    public boolean isSuicide() {
        return killer.equals(victim);
    }
}

package com.q3parser.model;

public class Kill {

    private Player victim;

    private WeaponInterface weapon;

    public Kill(Player victim, WeaponInterface weapon) {
        this.victim = victim;
        this.weapon = weapon;
    }

    public Player getVictim() {
        return victim;
    }

    public WeaponInterface getWeapon() {
        return weapon;
    }
}

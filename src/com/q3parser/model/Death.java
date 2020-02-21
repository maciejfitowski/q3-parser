package com.q3parser.model;

public class Death {

    private Player killer;

    private WeaponInterface weapon;

    public Death(Player killer, WeaponInterface weapon) {
        this.killer = killer;
        this.weapon = weapon;
    }

    public Player getKiller() {
        return killer;
    }

    public WeaponInterface getWeapon() {
        return weapon;
    }
}

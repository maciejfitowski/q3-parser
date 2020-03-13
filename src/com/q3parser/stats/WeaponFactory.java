package com.q3parser.stats;

import com.q3parser.model.Weapon;
import com.q3parser.model.WeaponInterface;
import com.q3parser.parser.LineParser;

public class WeaponFactory {

    public static WeaponInterface get(String data) {
        return new Weapon(getName(data));
    }

    private static String getName(String data) {
        String name = "";
        if (LineParser.isGauntletKill(data)) {
            name = "Gauntlet";
        } else if (LineParser.isBFGKill(data)) {
            name = "BFG";
        } else if (LineParser.isRailKill(data)) {
            name = "Railgun";
        } else if (LineParser.isRocketKill(data)) {
            name = "Rocket launcher";
        } else if (LineParser.isElectroKill(data)) {
            name = "Lightning gun";
        } else if (LineParser.isGrenadeKill(data)) {
            name = "Grenade launcher";
        } else if (LineParser.isPlasmaKill(data)) {
            name = "Plasma gun";
        } else if (LineParser.isShotGunKill(data)) {
            name = "Shotgun";
        } else if (LineParser.isMachineGunKill(data)) {
            name = "Machine gun";
        } else if (LineParser.isTeleportKill(data)) {
            name = "Teleport";
        }

        return name;
    }
}

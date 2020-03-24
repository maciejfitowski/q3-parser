package com.q3parser.stats;

import com.q3parser.model.Weapon;
import com.q3parser.model.WeaponInterface;
import com.q3parser.parser.LineParser;

public class WeaponFactory {

    public static WeaponInterface get(String data) {
        return new Weapon(getName(data));
    }

    private static String getName(String data) {
        if (LineParser.isGauntletKill(data)) {
            return "Gauntlet";
        } else if (LineParser.isBFGKill(data)) {
            return "BFG";
        } else if (LineParser.isRailKill(data)) {
            return "Railgun";
        } else if (LineParser.isRocketKill(data)) {
            return "Rocket launcher";
        } else if (LineParser.isElectroKill(data)) {
            return "Lightning gun";
        } else if (LineParser.isGrenadeKill(data)) {
            return "Grenade launcher";
        } else if (LineParser.isPlasmaKill(data)) {
            return "Plasma gun";
        } else if (LineParser.isShotGunKill(data)) {
            return "Shotgun";
        } else if (LineParser.isMachineGunKill(data)) {
            return "Machine gun";
        } else if (LineParser.isTeleportKill(data)) {
            return "Teleport";
        }

        return "Suicide";
    }
}

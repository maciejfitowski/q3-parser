package com.q3parser.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParser {

    public static boolean isKillLine(String data) {
        return isSuicide(data)
                || isTeleportKill(data)
                || isMachineGunKill(data)
                || isRocketKill(data)
                || isPlasmaKill(data)
                || isShotGunKill(data)
                || isElectroKill(data)
                || isGrenadeKill(data)
                || isRailKill(data)
                || isBFGKill(data)
                || isGauntletKill(data);
    }

    public static boolean isRocketKill(String data) {
        return data.contains(" rocket");
    }

    public static boolean isPlasmaKill(String data) {
        return data.contains("plasma");
    }

    public static boolean isMachineGunKill(String data) {
        return data.contains("machinegunned");
    }

    public static boolean isElectroKill(String data) {
        return data.contains("electrocuted");
    }

    public static boolean isGrenadeKill(String data) {
        return data.contains("grenade") || data.contains("shrapnel");
    }

    public static boolean isShotGunKill(String data) {
        return data.contains("gunned down");
    }

    public static boolean isRailKill(String data) {
        return data.contains("railed");
    }

    public static boolean isTeleportKill(String data) {
        return data.contains("invade") || data.contains("space");
    }

    public static boolean isGauntletKill(String data) {
        return data.contains("pummeled") || data.contains("gauntlet");
    }

    public static boolean isBFGKill(String data) {
        return data.contains("BFG");
    }

    public static boolean isSuicide(String data) {
        return data.contains("himself")
                || data.contains("cratered")
                || data.contains("lava")
                || data.contains("smaller gun")
                || data.contains("squished")
                || data.contains("wrong place")
                || data.contains("sank")
                || data.contains("tripped");
    }

    public static String getVictim(String data) {
        return clear(data.split(" ")[0]);
    }

    public static String getKiller(String data) {
        if (isSuicide(data)) {
            return getVictim(data);
        }

        String[] split = data.split(" ");
        for (String part : split) {
            if (part.contains("'s")) {
                return clear(part);
            }
        }

        return clear(split[split.length - 1]);
    }

    private static String clear(String data) {
        return data.replace("^7", "").replace("'s", "");
    }
}

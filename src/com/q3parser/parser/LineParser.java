package com.q3parser.parser;

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

    private static String getNewPlayerLineKeyword() {
        return " entered the game";
    }

    public static boolean isNewPlayerLine(String data) {
        return data.contains(getNewPlayerLineKeyword());
    }

    public static String getPlayerName(String data) {
        return data.replace(getNewPlayerLineKeyword(), "");
    }

    // TODO: Remove player names before check to eliminate wrong return when player name contains one of the listed words
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
}

package com.q3parser.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    public void parse(String path) throws Exception {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File child : files) {
                        parseFile(child);
                    }
                }
            } else {
                parseFile(file);
            }
        } else {
            throw new Exception("Given path is not valid. File does not exists");
        }
    }

    private void parseFile(File file) {
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (this.isKillLine(data)) {
                    System.out.println(data);
                } else if (this.isNewPlayerLine(data)) {
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private boolean isKillLine(String data) {
        return this.isSuicide(data)
                || this.isTeleportKill(data)
                || this.isMachineGunKill(data)
                || this.isRocketKill(data)
                || this.isPlasmaKill(data)
                || this.isShotGunKill(data)
                || this.isElectroKill(data)
                || this.isGrenadeKill(data)
                || this.isRailKill(data)
                || this.isBFGKill(data)
                || this.isGauntletKill(data);
    }

    private boolean isRocketKill(String data) {
        return data.contains("rocket");
    }

    private boolean isPlasmaKill(String data) {
        return data.contains("plasma");
    }

    private boolean isMachineGunKill(String data) {
        return data.contains("machinegunned");
    }

    private boolean isElectroKill(String data) {
        return data.contains("electrocuted");
    }

    private boolean isGrenadeKill(String data) {
        return data.contains("grenade") || data.contains("shrapnel");
    }

    private boolean isShotGunKill(String data) {
        return data.contains("gunned down");
    }

    private boolean isRailKill(String data) {
        return data.contains("railed");
    }

    private boolean isTeleportKill(String data) {
        return data.contains("invade") || data.contains("space");
    }

    private boolean isGauntletKill(String data) {
        return data.contains("pummeled") || data.contains("gauntlet");
    }

    private boolean isBFGKill(String data) {
        return data.contains("BFG");
    }

    private boolean isSuicide(String data) {
        return data.contains("himself")
                || data.contains("cratered")
                || data.contains("lava")
                || data.contains("smaller gun")
                || data.contains("squished")
                || data.contains("wrong place");
    }

    private boolean isNewPlayerLine(String data) {
        return data.contains("entered the game") || data.contains("connected");
    }
}

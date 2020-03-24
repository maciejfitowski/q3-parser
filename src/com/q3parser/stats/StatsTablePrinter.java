package com.q3parser.stats;

import com.q3parser.model.GameStats;
import com.q3parser.model.Player;
import com.q3parser.model.PlayerStats;

import java.util.HashMap;

public class StatsTablePrinter {

    public static void print(GameStats stats) {
        System.out.println("  ---------------------------------------------------------------");
        System.out.format("| %10s | %10s | %10s | %10s | %10s | \n", "Name", "Kills", "Deaths", "Score", "Ratio");
        System.out.println("  ---------------------------------------------------------------");
        for (PlayerStats playerStats : stats.getStats()) {
            Player player = playerStats.getPlayer();
            System.out.printf("| %10s | %10d | %10d | %10d | %10f |\n", player.getName(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getScore(), playerStats.getRatio());
        }
        System.out.println("  ---------------------------------------------------------------\n\n");
    }

    public static void printPlayerKillsByWeapon(GameStats stats) {
        System.out.println("----------------------------------");
        System.out.println("Player's kills by weapon");
        System.out.println("----------------------------------");

        for (PlayerStats playerStats : stats.getStats()) {
            Player player = playerStats.getPlayer();
            System.out.println("\n");
            System.out.println("Player: " + player.getName());
            System.out.println("  -----------------------------------------------");
            System.out.format("| %20s | %10s | %10s | \n", "Name", "Kills", "Percentage");
            System.out.println("  -----------------------------------------------");
            for (HashMap.Entry<String, Integer> entry : playerStats.getWeaponCountMap().entrySet()) {
                System.out.printf("| %20s | %10d | %10f |\n", entry.getKey(), entry.getValue(), (float)entry.getValue() * 100 / playerStats.getKills());
            }
            System.out.println("  -----------------------------------------------");
        }
    }
}

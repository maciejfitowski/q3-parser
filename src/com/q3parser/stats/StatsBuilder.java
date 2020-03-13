package com.q3parser.stats;

import com.q3parser.model.*;
import com.q3parser.parser.LineParser;

import java.util.ArrayList;

public class StatsBuilder {

    private GameStats stats;

    public StatsBuilder() {
        this.stats = new GameStats();
    }

    public GameStats build(ArrayList<ArrayList<String>> parsedGames) {
        for (ArrayList<String> parsedGame : parsedGames) {
            for (String killLine : parsedGame) {
                WeaponInterface weapon = WeaponFactory.get(killLine);
                Player killer = new Player(LineParser.getKiller(killLine));
                Player victim = new Player(LineParser.getVictim(killLine));

                Event event = new Event(killer, weapon, victim);

                PlayerStats killerStats = getPlayerStats(killer);
                PlayerStats victimStats = getPlayerStats(victim);

                killerStats.addKill(event);
                victimStats.addDeath(event);
            }
        }

        return this.stats;
    }

    private PlayerStats getPlayerStats(Player player) {
        PlayerStats playerStats = this.stats.getPlayerStats(player);

        if (playerStats == null) {
            playerStats = new PlayerStats(player);
            this.stats.addStat(playerStats);
        }

        return playerStats;
    }
}

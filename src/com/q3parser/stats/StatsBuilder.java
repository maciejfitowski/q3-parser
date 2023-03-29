package com.q3parser.stats;

import com.q3parser.model.*;
import com.q3parser.parser.LineParser;

import java.util.List;

public class StatsBuilder {

    private GameStats stats;

    private List<Player> players;

    private List<String> killLines;

    public StatsBuilder(List<Player> players, List<String> killLines) {
        this.stats = new GameStats();
        this.players = players;
        this.killLines = killLines;
    }

    public GameStats build() throws Exception {
        for (String killLine : this.killLines) {
            WeaponInterface weapon = WeaponFactory.get(killLine);
            Player killer = getKiller(killLine);
            Player victim = getVictim(killLine);

            Event event = new Event(killer, weapon, victim);

            if (killer != null) {
                PlayerStats killerStats = getPlayerStats(killer);
                killerStats.addKill(event);
            }

            PlayerStats victimStats = getPlayerStats(victim);
            victimStats.addDeath(event);
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

    private Player getKiller(String killLine) throws Exception {
        for (Player player : this.players) {
            for (String nickName : player.getNicknames()) {
                if (LineParser.isSuicide(killLine)) {
                    return null;
                }

                if (killLine.lastIndexOf(nickName) > 0) {
                    return player;
                }
            }
        }

        throw new Exception("Unable to find killer on the player's list: " + killLine);
    }

    private Player getVictim(String killLine) throws Exception {
        for (Player player : this.players) {
            for (String nickName : player.getNicknames()) {
                if (killLine.indexOf(nickName) == 0) {
                    return player;
                }
            }
        }

        throw new Exception("Unable to find victim on the player's list " + killLine);
    }
}

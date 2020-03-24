package com.q3parser.model;

import com.q3parser.stats.PlayerStatsComparator;

import java.util.ArrayList;

public class GameStats implements StatsInterface {

    private ArrayList<PlayerStats> stats;

    public GameStats() {
        this.stats = new ArrayList<>();
    }

    public ArrayList<PlayerStats> getStats() {
        this.stats.sort(new PlayerStatsComparator());

        return stats;
    }

    public void addStat(PlayerStats stat) {
        this.stats.add(stat);
    }

    public PlayerStats getPlayerStats(Player player) {
        for (PlayerStats playerStats : this.getStats()) {
            if (playerStats.getPlayer().getName().equals(player.getName())) {
                return playerStats;
            }
        }

        return null;
    }

    @Override
    public int getDeaths() {
        int deaths = 0;
        for (StatsInterface stat : this.getStats()) {
            deaths += stat.getDeaths();
        }

        return deaths;
    }

    @Override
    public int getKills() {
        int kills = 0;
        for (StatsInterface stat : this.getStats()) {
            kills += stat.getKills();
        }

        return kills;
    }

    @Override
    public int getScore() {
        int score = 0;
        for (StatsInterface stat : this.getStats()) {
            score += stat.getScore();
        }

        return score;
    }
}

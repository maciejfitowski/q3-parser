package com.q3parser.stats;

import com.q3parser.model.PlayerStats;

import java.util.Comparator;

public class PlayerStatsComparator implements Comparator<PlayerStats> {
    @Override
    public int compare(PlayerStats stats1, PlayerStats stats2) {
        return Float.compare(stats2.getRatio(), stats1.getRatio());
    }
}

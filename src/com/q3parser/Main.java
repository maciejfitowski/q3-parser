package com.q3parser;


import com.q3parser.model.GameStats;
import com.q3parser.model.Player;
import com.q3parser.model.PlayerStats;
import com.q3parser.parser.Parser;
import com.q3parser.stats.StatsBuilder;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        ArrayList<ArrayList<String>> parsed = parser.parse("/home/fts/work/q3-parser/log/log20200310140000.txt/");

        StatsBuilder builder = new StatsBuilder();
        GameStats stats = builder.build(parsed);

        for (PlayerStats playerStats : stats.getStats()) {
            Player player = playerStats.getPlayer();
            System.out.printf("Player: %s | Kills: %d Deaths: %d Score: %d", player.getName(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getScore());
            System.out.println();
        }
    }
}

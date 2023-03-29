package com.q3parser;


import com.q3parser.model.GameStats;
import com.q3parser.parser.Parser;
import com.q3parser.model.ParserResult;
import com.q3parser.stats.PlayersBuilder;
import com.q3parser.stats.StatsBuilder;
import com.q3parser.stats.StatsTablePrinter;

public class Main {

    public static void main(String[] args) throws Exception {
        String logPath = "log/";
        if (args.length > 0 && args[0] != null) {
            logPath = args[0];
        }

        Parser parser = new Parser();
        ParserResult result = parser.parse(logPath);

        StatsBuilder builder = new StatsBuilder(
                PlayersBuilder.build(result),
                result.getKillLines()
        );

        try {
            GameStats stats = builder.build();

            if (args.length > 1 && Integer.parseInt(args[1]) == 1) {
                StatsTablePrinter.printPlayerKillsByWeapon(stats);
            }

            StatsTablePrinter.print(stats);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

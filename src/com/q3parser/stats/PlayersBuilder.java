package com.q3parser.stats;

import com.q3parser.model.ParserResult;
import com.q3parser.model.Player;
import com.q3parser.parser.PlayerParser;

import java.util.ArrayList;

public class PlayersBuilder {

    public static ArrayList<Player> build(ParserResult result) throws Exception {
        PlayerParser playerParser = new PlayerParser();
        ArrayList<Player> players = playerParser.parse("players.txt");

        if (players.size() == 0) {
            for (String playerName : result.getPlayers()) {
                players.add(new Player(playerName));
            }
        }

        return players;
    }
}

package com.q3parser.parser;

import com.q3parser.model.ParserResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public ParserResult parse(String path) throws Exception {
        List<String> killLines = new ArrayList<>();
        List<String> players = new ArrayList<>();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File child : files) {
                        ParserResult fileResult = parseFile(child);

                        killLines.addAll(fileResult.getKillLines());
                        players.addAll(fileResult.getPlayers());
                    }
                }
            } else {
                ParserResult fileResult = parseFile(file);

                killLines.addAll(fileResult.getKillLines());
                players.addAll(fileResult.getPlayers());
            }
        } else {
            throw new Exception("Given path is not valid. File does not exists");
        }

        return new ParserResult(players, killLines);
    }

    private ParserResult parseFile(File file) throws Exception {
        List<String> killLines = new ArrayList<>();
        List<String> players = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (LineParser.isNewPlayerLine(data)) {
                    String player = LineParser.getPlayerName(data);
                    if (!players.contains(player)) {
                        players.add(player);
                    }
                } else if (LineParser.isKillLine(data)) {
                    killLines.add(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new Exception("Given path is not valid. File does not exists");
        }

        return new ParserResult(players, killLines);
    }
}

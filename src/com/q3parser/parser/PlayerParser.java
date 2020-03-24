package com.q3parser.parser;

import com.q3parser.model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerParser {

    public ArrayList<Player> parse(String path) throws Exception {
        ArrayList<Player> players = new ArrayList<>();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File child : files) {
                        players.addAll(parseFile(child));
                    }
                }
            } else {
                players.addAll(parseFile(file));
            }
        }

        return players;
    }

    private ArrayList<Player> parseFile(File file) throws Exception {
        ArrayList<Player> players = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" = ");
                List<String> nicknames = new ArrayList<>(Arrays.asList(data[1].split(", ")));

                players.add(new Player(data[0], nicknames));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new Exception("Given path is not valid. File does not exists");
        }

        return players;
    }
}

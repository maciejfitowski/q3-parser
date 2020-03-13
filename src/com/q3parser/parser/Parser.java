package com.q3parser.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    public ArrayList<ArrayList<String>> parse(String path) throws Exception {
        ArrayList<ArrayList<String>> filesKillLines = new ArrayList<>();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File child : files) {
                        filesKillLines.add(parseFile(child));
                    }
                }
            } else {
                filesKillLines.add(parseFile(file));
            }
        } else {
            throw new Exception("Given path is not valid. File does not exists");
        }

        return filesKillLines;
    }

    private ArrayList<String> parseFile(File file) {
        ArrayList<String> killLines = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (LineParser.isKillLine(data)) {
                    killLines.add(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return killLines;
    }
}

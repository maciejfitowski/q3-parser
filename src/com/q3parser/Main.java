package com.q3parser;


import com.q3parser.parser.Parser;

public class Main {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        parser.parse("/home/fts/work/q3-parser/log/log14022020160000.txt");
    }
}

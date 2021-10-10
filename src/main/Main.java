package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static <Strings> void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Wrong number of command line arguments. 2 arguments needed. \nExample: >java main.Main inFile.txt outFile.txt");
            System.exit(1);
        }

        String fileInput = args[0];
        String fileOutput = args[1];

        //build String Array from File
        Scanner in = new Scanner(new File(fileInput));
        String row;
        ArrayList<String> stringRows = new ArrayList<>();

        try {
            while (in.hasNext()) {
                row = in.next();
                stringRows.add(row);
            }
        } finally {
            in.close();
        }
        //display input
        System.out.println(stringRows);

        //read N
        int n = Integer.parseInt(stringRows.get(0));

        //build trie
        Trie trie = new Trie();

        //insert word one, two, ...
        ArrayList<String> resultsInsert = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            //System.out.println("Inserting " + stringRows.get(i));
            resultsInsert.add(trie.insert(stringRows.get(i)));
        }

        //find the next word in tree
        ArrayList<String> resultsLookup = new ArrayList<>();
        for (int i = n + 1; i < stringRows.size(); i++) {
            //System.out.println("Look up " + stringRows.get(i));
            resultsLookup.add(trie.getLookup(stringRows.get(i)));
        }

        //output the results into a file:
        try (PrintWriter out = new PrintWriter(fileOutput)) {
            for (String s : resultsInsert) {
                //System.out.println("check:" + s);
                out.println(s);
            }
            for (String s : resultsLookup) {
                System.out.println("Check 2: " + s);
                out.println(s);
            }
        }


    }
}
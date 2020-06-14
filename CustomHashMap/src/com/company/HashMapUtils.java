package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashMapUtils {

    public static String[] readFromFile(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        String text = new String();
        while (scan.hasNext()) {
            text += scan.nextLine() + " ";
        }
        String[] wordArray = text.split(" ");
        return wordArray;
    }

    public static CustomHashMap mostOftenEncountered(String fileName) throws FileNotFoundException {
        String[] wordArray = readFromFile(fileName);
        CustomHashMap customHashMap = new CustomHashMap();
        int i = 0;
        while (i < wordArray.length) {
            if (wordArray[i].endsWith(".") || wordArray[i].endsWith(",") || wordArray[i].endsWith("!") || wordArray[i].endsWith("?")) {
                i++;
            } else {
                String word1 = wordArray[i];
                String word2 = wordArray[i + 1];
                word1 = word1.toLowerCase();
                word2 = word2.toLowerCase();
                word1 = word1.replace(".", "");
                word1 = word1.replace(",", "");
                word1 = word1.replace("!", "");
                word1 = word1.replace("?", "");
                word1 = word1.replace(":", "");
                word2 = word2.replace(".", "");
                word2 = word2.replace(",", "");
                word2 = word2.replace("!", "");
                word2 = word2.replace("?", "");
                word2 = word2.replace(":", "");
                String phrase = word1 + " " + word2;
                if (customHashMap.get(phrase) == null) {
                    customHashMap.put(phrase, 1);
                } else {
                    int counter = (int) customHashMap.get(phrase) + 1;
                    customHashMap.put(phrase, counter);
                }
                i++;
            }
        }
        return customHashMap;
    }
}

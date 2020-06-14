package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public static HashMap mostOftenEncountered(String fileName) throws FileNotFoundException {
        String[] wordArray = readFromFile(fileName);
        HashMap hashMap = new HashMap();
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
                if (hashMap.get(phrase) == null) {
                    hashMap.put(phrase, 1);
                } else {
                    int counter = (int) hashMap.get(phrase) + 1;
                    hashMap.put(phrase, counter);
                }
                i++;
            }
        }
        return hashMap;
    }

    public static String findMax(HashMap hashMap) {
        String item = null;
        int counter = 0;
        List list = new ArrayList<>(hashMap.keySet());
        for(int i = 0; i < list.size(); i++) {
            if ((int) hashMap.get(list.get(i)) == counter) {
                item += "," + " " + list.get(i);
            }
            if ((int) hashMap.get(list.get(i)) > counter) {
                counter = (int) hashMap.get(list.get(i));
                item = (String) list.get(i);
            }
        }
        item += " " + "=" + " " + counter;
        return item;
    }
}

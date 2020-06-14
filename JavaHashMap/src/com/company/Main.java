package com.company;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap hashMap = HashMapUtils.mostOftenEncountered("1.txt");
        String item = HashMapUtils.findMax(hashMap);
        System.out.println(item);
    }
}

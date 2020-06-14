package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CustomHashMap customHashMap = HashMapUtils.mostOftenEncountered("1.txt");
        String max = customHashMap.findMax();
        System.out.println(max);
    }
}

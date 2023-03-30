package com.uday.practise.ps;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void main(String[] args) {

        String string = "dfasrsfdfsd";

        CharacterFrequency duplicate = new CharacterFrequency();
        duplicate.charFrequency(string);
        System.out.println();
        duplicate.charFrequencyUsingMap(string);
    }

    private void charFrequency(String input) {

        final char[] charArray = input.toLowerCase().toCharArray();

        int[] charFreq = new int[26];
        for (int i = 0; i < input.length(); i++) {
//        for (int i = 0; i < charArray.length; i++) {
            charFreq[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] != 0) {
                System.out.println((char) (i + 'a') + ":" + charFreq[i]);
            }
        }
    }

    private void charFrequencyUsingMap(String input) {

        Map<Character, Integer> countCharMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (countCharMap.get(c) != null) {
                countCharMap.put(c, countCharMap.get(c) + 1);
            } else {
                countCharMap.put(c, 1);
            }
        }

        for (Map.Entry entry : countCharMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

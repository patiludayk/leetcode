package com.uday.practise.ps.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Two words are said to be anagrams if each character occurs the same number of times in both words.

Given an array of strings, group anagrams together. All the input strings are in Lowercase.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
public class GroupAnagram {

    public static void main(String[] args) {
        GroupAnagram ga = new GroupAnagram();

        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(input));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        String[] sortedArray = new String[strs.length];

        for(int i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            sortedArray[i] = new String(charArray);
        }

        Map<String, List<String>> rslt = new HashMap<>();
        for(int i = 0; i < sortedArray.length; i++){
            if(rslt.get(sortedArray[i]) != null){
                List<String> values = rslt.get(sortedArray[i]);
                values.add(strs[i]);
                rslt.put(sortedArray[i], values);
            } else {
                List<String> values = new ArrayList<>();
                values.add(strs[i]);
                rslt.put(sortedArray[i], values);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> value : rslt.values()){
            result.add(value);
        }

        return result;
    }

}
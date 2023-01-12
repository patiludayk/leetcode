package com.uday.practise.ps.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
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
        List<String> sortedList = new LinkedList<>();

        for(int i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            sortedList.add(new String(charArray));
        }

        Map<String, List<String>> rslt = new HashMap<>();
        for(int i = 0; i < sortedList.size(); i++){
            if(rslt.get(sortedList.get(i)) != null){
                List<String> values = rslt.get(sortedList.get(i));
                values.add(strs[i]);
                rslt.put(sortedList.get(i), values);
            } else {
                List<String> values = new ArrayList<>();
                values.add(strs[i]);
                rslt.put(sortedList.get(i), values);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> value : rslt.values()){
            Collections.sort(value);
            result.add(value);
        }

        return result;
    }

}
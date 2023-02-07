package com.uday.practise.ps;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.sort(input);
        System.out.println(ga.groupAnagrams(input));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<String> sortedStrs = new ArrayList();
        for(int i = 0; i < strs.length; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            sortedStrs.add(new String(str));
        }

        Map<String, List<String>> groupAnagrams = new HashMap();
        for(int i = 0; i < strs.length; i++){
            if(groupAnagrams.get(sortedStrs.get(i)) != null){
                List<String> groups = groupAnagrams.get(sortedStrs.get(i));
                groups.add(strs[i]);
                groupAnagrams.put(sortedStrs.get(i), groups);
            } else {
                List<String> groups = new ArrayList();
                groups.add(strs[i]);
                groupAnagrams.put(sortedStrs.get(i), groups);
            }
        }

        List<List<String>> result = new ArrayList();
        for(List<String> lst : groupAnagrams.values()){
            result.add(lst);
        }

        return result;
    }

}
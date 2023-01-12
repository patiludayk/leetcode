package com.uday.practise.ps.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramTest {
    //JUnitCore
    @Test
    public void test1() {
        String[] input = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = List.of(
                List.of("eat", "tea", "ate"),
                List.of("tan", "nat"),
                List.of("bat")
        );

        GroupAnagram ga = new GroupAnagram();
        //List<List<String>> actual = ga.groupAnagrams(input);
        //assertEquals(expected, actual);
    }

}
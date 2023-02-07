package com.uday.practise.ps.array;

import com.uday.practise.ps.GroupAnagram;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramTest {
    //JUnitCore
    @Test
    public void test1() {
        String[] input = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("eat", "tea", "ate"), Arrays.asList("tan", "nat"), Arrays.asList("bat"));

        GroupAnagram ga = new GroupAnagram();
        //List<List<String>> actual = ga.groupAnagrams(input);
        //assertEquals(expected, actual);
    }

}
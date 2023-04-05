package com.uday.practise.ps;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort {

    public static void main(String[] args) {
        System.out.println("map sorted");
        Map<String, Double> map = new HashMap<>();
        map.put("b", 9.4);
        map.put("a", 4.4);
        map.put("d", 0.5);
        map.put("d", 7.5);
        map.put("m", 1.4);
        map.put("q", 3.2);
        map.put("1", 2.3);

        MapSort ms = new MapSort();
        System.out.print("by value: ");
        ms.sortMapByValue(map);

        System.out.print("by key: ");
        ms.sortMapByKey(map);
    }

    /**
     * sort map by key using java 8 lambda expression
     *
     * @param map
     */
    private void sortMapByValue(Map<String, Double> map) {
        final LinkedHashMap<String, Double> sortedMapByValues = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, o2) -> o, LinkedHashMap::new));

        System.out.println(sortedMapByValues);
    }

    private void sortMapByKey(Map<String, Double> map) {
        final LinkedHashMap<String, Double> sortedMapByKeys = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (aDouble, aDouble2) -> aDouble2, LinkedHashMap::new));
        System.out.println(sortedMapByKeys);
    }
}

package com.ryanluedders.aoc.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DaySix {
    
    static class CountingMap<T> {
        
        private Map<T, Integer> counts = new HashMap<T, Integer>();
        
        public void record(T t) {
            if (counts.containsKey(t)) {
                counts.put(t, counts.get(t) + 1);
            } else {
                counts.put(t, 1);
            }
        }
        
        public T getMostFrequent() {
            List<Map.Entry<T, Integer>> sortedEntries = getSortedEntries();
            return sortedEntries.get(sortedEntries.size() - 1).getKey();
        }
        
        public T getLeastFrequent() {
            List<Map.Entry<T, Integer>> sortedEntries = getSortedEntries();
            return sortedEntries.get(0).getKey();
        }
        
        private List<Map.Entry<T, Integer>> getSortedEntries() {
            List<Map.Entry<T, Integer>> sortedEntries = new LinkedList<Map.Entry<T, Integer>>(counts.entrySet());
            Collections.sort(sortedEntries, new Comparator<Map.Entry<T, Integer>>() {
                public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            return sortedEntries;
        }
        
        @Override
        public String toString() {
            return counts.toString();
        }
        
    }

    public static void main(String[] argvs) throws IOException, NoSuchAlgorithmException {
        List<String> input = parseStdIn();
        
        int positions = input.get(0).length();
        
        List<CountingMap<Character>> occurrences = new ArrayList<CountingMap<Character>>();
        for (int i = 0; i < positions; i++) {
            occurrences.add(new CountingMap<Character>());
        }
            
        for (String s : input) {
            for (int i = 0; i < s.length(); i++) {
                occurrences.get(i).record(s.charAt(i));
            }
        }
        
        System.out.println(occurrences.toString());
        
        String result = "";
        String secondResult = "";
        for(CountingMap<Character> m : occurrences) {
            result += m.getMostFrequent();
            secondResult += m.getLeastFrequent();
        }
        
        System.out.println("result=" + result);
        System.out.println("secondResult=" + secondResult);
    }
 
    private static List<String> parseStdIn() throws IOException {
        List<String> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            values.add(line);
        }
        
        return values;
    }    
}

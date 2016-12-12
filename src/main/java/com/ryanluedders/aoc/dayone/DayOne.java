package com.ryanluedders.aoc.dayone;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class DayOne {
    
    public static void main(String[] argvs) throws IOException {
        List<String> input = parseStdIn(", ");
        
        for (String s : input) {
            System.out.println(s);
        }
    }
    
    private static List<String> parseStdIn(String seperator) throws IOException {
        List<String> values = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            values = Arrays.asList(line.split(seperator));
        }
        
        return values;
    }
    
}

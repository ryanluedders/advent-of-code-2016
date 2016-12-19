package com.ryanluedders.aoc.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {


    public static void main(String[] argvs) throws IOException {
        List<List<String>> inputs = parseStdIn();
        inputs = transformInput(inputs);
        
        System.out.println("parsing " + Integer.toString(inputs.size()) + " rows");
        
        int validCount = 0;
        
        for (List<String> set : inputs) {
            if (set.size() != 3) {
                throw new IllegalArgumentException("invalid input");
            }
            
            Integer a = Integer.valueOf(set.get(0));
            Integer b = Integer.valueOf(set.get(1));
            Integer c = Integer.valueOf(set.get(2));
            
            if (areSidesValid(a, b, c)) {
                validCount += 1;
            }
        }
        
        System.out.println("valid count=" + Integer.toString(validCount));
    }
    
    private static List<List<String>> parseStdIn() throws IOException {
        List<List<String>> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            Pattern p = Pattern.compile("^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s*$");
            Matcher m = p.matcher(line);
            if (m.matches()) {
                values.add(Arrays.asList(m.group(1), m.group(2), m.group(3)));
            }
        }
        
        return values;
    }
    
    static List<List<String>> transformInput(List<List<String>> input) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (input.size() % 3 != 0) {
            throw new IllegalArgumentException("invalid input");
        }
        
        for (int i = 0; i < input.size() - 2; i += 3) {
            List<String> col0 = new ArrayList<String>();
            List<String> col1 = new ArrayList<String>();
            List<String> col2 = new ArrayList<String>();
            
            col0.add(input.get(i).get(0));
            col0.add(input.get(i+1).get(0));
            col0.add(input.get(i+2).get(0));
            
            col1.add(input.get(i).get(1));
            col1.add(input.get(i+1).get(1));
            col1.add(input.get(i+2).get(1));
            
            col2.add(input.get(i).get(2));
            col2.add(input.get(i+1).get(2));
            col2.add(input.get(i+2).get(2));
            
            result.add(col0);
            result.add(col1);
            result.add(col2);
        }
        
        return result;
    }
    
    static boolean areSidesValid(int a, int b, int c) {
        return ((a + b > c) 
                && (a + c > b) 
                && (b + c > a));
    }
    
}

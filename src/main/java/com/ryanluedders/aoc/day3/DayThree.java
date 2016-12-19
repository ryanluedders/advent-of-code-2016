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
        
        System.out.println(inputs.toString());
    }
    
    private static List<List<String>> parseStdIn() throws IOException {
        List<List<String>> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            values.add(Arrays.asList(line.trim().split("\\s+")));
            Pattern p = Pattern.compile("^\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)\\s*$");
            Matcher m = p.matcher(line);
            values.add(Arrays.asList(m.group(1), m.group(2), m.group(3)));
        }
        
        return values;
    }
    
}

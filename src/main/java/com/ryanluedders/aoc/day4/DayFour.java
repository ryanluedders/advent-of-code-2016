package com.ryanluedders.aoc.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFour {

    public static void main(String[] argvs) throws IOException {
        List<List<String>> inputs = parseStdIn();

        System.out.println(inputs.toString());
    }
    
    private static List<List<String>> parseStdIn() throws IOException {
        List<List<String>> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            Pattern p = Pattern.compile("^(.*)\\[(.*)\\]$");
            Matcher m = p.matcher(line);
            if (m.matches()) {
                values.add(Arrays.asList(m.group(1), m.group(2)));
            }
        }
        
        return values;
    }
    
}

package com.ryanluedders.aoc.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEight {
    
    static abstract class Operation { }
    
    static class RotateRowOperation extends Operation {
        public int row;
        public int shift;
    }
    
    static class RotateColumnOperation extends Operation {
        public int column;
        public int shift;
    }
    
    static class RectOperation extends Operation {
        public int width;
        public int height;
    }
    
    private static Pattern RECT_PATTERN = Pattern.compile("rect ([0-9]+)x([0-9]+)");
    private static Pattern ROTATE_ROW_PATTERN = Pattern.compile("rotate row y=([0-9]+) by ([0-9]+)");
    private static Pattern ROTATE_COL_PATTERN = Pattern.compile("rotate column x=([0-9]+) by ([0-9]+)");
    
    public static void main(String[] argvs) throws IOException {
        List<String> input = parseStdIn();
        
        List<Operation> operations = parseCommands(input);
        
        System.out.println(operations.toString());
    }
    
    static List<Operation> parseCommands(List<String> input) {
        List<Operation> result = new ArrayList<>();
        
        for (String s : input) {
            Matcher rectMatcher = RECT_PATTERN.matcher(s);
            Matcher rrMatcher = ROTATE_ROW_PATTERN.matcher(s);
            Matcher rcMatcher = ROTATE_COL_PATTERN.matcher(s);
            
            if (rectMatcher.matches()) {
                //System.out.println("rect w=" + rectMatcher.group(1) + " h=" + rectMatcher.group(2));
                RectOperation o = new RectOperation();
                o.height = Integer.parseInt(rectMatcher.group(2));
                o.width = Integer.parseInt(rectMatcher.group(1));
                result.add(o);
            } else if (rrMatcher.matches()) {
                //System.out.println("rotate row y=" + rrMatcher.group(1) + " amt=" + rrMatcher.group(2));
                RotateRowOperation o = new RotateRowOperation();
                o.row = Integer.parseInt(rrMatcher.group(1));
                o.shift = Integer.parseInt(rrMatcher.group(2));
                result.add(o);
            } else if (rcMatcher.matches()) {
                //System.out.println("rotate col c=" + rcMatcher.group(1) + " amt=" + rcMatcher.group(2));
                RotateColumnOperation o = new RotateColumnOperation();
                o.column = Integer.parseInt(rcMatcher.group(1));
                o.shift = Integer.parseInt(rcMatcher.group(2));
                result.add(o);
            }
        }
        
        return result;
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

package com.ryanluedders.aoc.dayone;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class DayOne {
    
    /**
     * +X 0
     * +Y 1
     * -X 2
     * -Y 3
     */
    
    static class Coords {
        public int x;
        public int y;
    }
    
    public static void main(String[] argvs) throws IOException {
        List<String> input = parseStdIn(", ");
        
        for (String s : input) {
            System.out.println(s);
        }
        
        Coords loc = new Coords();
        loc.x = 0;
        loc.y = 0;
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
    
    static int nextDirection(int currentDirection, String move) {
        switch (move) {
            case "R":
                return Math.floorMod(currentDirection - 1, 4);
            case "L":
                return Math.floorMod(currentDirection + 1, 4);
        }
        throw new IllegalArgumentException("unsupported move");
    }
    
}

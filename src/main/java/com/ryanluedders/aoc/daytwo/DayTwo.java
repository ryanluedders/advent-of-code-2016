package com.ryanluedders.aoc.daytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

    public static void main(String[] argvs) throws IOException {
        List<List<String>> input = parseStdIn();
        
        System.out.print("part1: ");
        SimpleKeypad skp = new SimpleKeypad();
        for (List<String> d : input) {
            for (String m : d) {
                moveOnSimpleKeypad(m, skp);
            }
            System.out.print(SimpleKeypad.getLabel(skp.getLocation().x, skp.getLocation().y));
        }
        System.out.println("");
        
        System.out.print("part2: ");
        AdvancedKeypad kp = new AdvancedKeypad();
        for (List<String> d : input) {
            for (String m : d) {
                moveOnKeypad(m, kp);
            }
            System.out.print(AdvancedKeypad.getLabel(kp.getLocation().x, kp.getLocation().y));
        }
        System.out.println("");
    }
    
    static void moveOnSimpleKeypad(String direction, SimpleKeypad kp) {
        switch (direction) {
            case "U":
                kp.move(SimpleKeypad.Direction.UP);
                break;
            case "D":
                kp.move(SimpleKeypad.Direction.DOWN);
                break;
            case "L":
                kp.move(SimpleKeypad.Direction.LEFT);
                break;
            case "R":
                kp.move(SimpleKeypad.Direction.RIGHT);
                break;
        }
    }
    
    static void moveOnKeypad(String direction, AdvancedKeypad kp) {
        switch (direction) {
            case "U":
                kp.move(AdvancedKeypad.Direction.UP);
                break;
            case "D":
                kp.move(AdvancedKeypad.Direction.DOWN);
                break;
            case "L":
                kp.move(AdvancedKeypad.Direction.LEFT);
                break;
            case "R":
                kp.move(AdvancedKeypad.Direction.RIGHT);
                break;
        }
    }
    
    private static List<List<String>> parseStdIn() throws IOException {
        List<List<String>> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            List<String> directions = new ArrayList<String>();
            for (int i = 0; i < line.length(); i++) {
                directions.add(String.valueOf(line.charAt(i)));
            }
            values.add(directions);
        }
        
        return values;
    }
    
}

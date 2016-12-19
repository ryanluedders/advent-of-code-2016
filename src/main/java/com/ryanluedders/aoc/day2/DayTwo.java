package com.ryanluedders.aoc.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ryanluedders.aoc.day2.Keypad.Coord;

public class DayTwo {
    
    static final String[][] part1 = new String[][] {
        { null, null, null, null, null},
        { null, "7",  "8",  "9",  null},
        { null, "4",  "5",  "6",  null},
        { null, "1",  "2",  "3",  null},
        { null, null, null, null, null},
    };
    
    static final String[][] part2 = new String[][] {
        { null, null, null, null, null, null, null},
        { null, null, null, "D",  null, null, null},
        { null, null, "A",  "B",  "C",  null, null},
        { null, "5",  "6",  "7",  "8",  "9",  null},
        { null, null, "2",  "3",  "4",  null, null},
        { null, null, null, "1",  null, null, null},
        { null, null, null, null, null, null, null},
    };

    public static void main(String[] argvs) throws IOException {
        List<List<String>> input = parseStdIn();
        
        Coord part1Starting = new Coord();
        part1Starting.x = 2;
        part1Starting.y = 2;
        
        System.out.print("part1: ");
        Keypad kp1 = new Keypad(part1, part1Starting);
        for (List<String> d : input) {
            for (String m : d) {
                moveOnKeypad(m, kp1);
            }
            System.out.print(kp1.getLabel(kp1.getLocation()));
        }
        System.out.println("");
        
        Coord part2Starting = new Coord();
        part2Starting.x = 1;
        part2Starting.y = 3;
        
        System.out.print("part2: ");
        Keypad kp2 = new Keypad(part2, part2Starting);
        for (List<String> d : input) {
            for (String m : d) {
                moveOnKeypad(m, kp2);
            }
            System.out.print(kp2.getLabel(kp2.getLocation()));
        }
        System.out.println("");
    }
    
    static void moveOnKeypad(String direction, Keypad kp) {
        switch (direction) {
            case "U":
                kp.move(Keypad.Direction.UP);
                break;
            case "D":
                kp.move(Keypad.Direction.DOWN);
                break;
            case "L":
                kp.move(Keypad.Direction.LEFT);
                break;
            case "R":
                kp.move(Keypad.Direction.RIGHT);
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

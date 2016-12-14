package com.ryanluedders.aoc.daytwo;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ryanluedders.aoc.daytwo.KeyPad.Coord;
import com.ryanluedders.aoc.daytwo.KeyPad.Direction;

public class DayTwo {

    public static void main(String[] argvs) throws IOException {
        List<List<String>> input = parseStdIn();
        
        KeyPad kp = new KeyPad(3,3);
        Coord location = new Coord();
        location.x = 1;
        location.y = 1;
        kp.setLocation(location);
        
        for (List<String> d : input) {
            for (String m : d) {
                moveOnKeypad(m, kp);
            }
            System.out.print(getKeyAtCoordinate(kp.getLocation().x, kp.getLocation().y));
        }
        
        System.out.println("");
    }
    
    static void moveOnKeypad(String direction, KeyPad kp) {
        switch (direction) {
            case "U":
                kp.move(Direction.UP);
                break;
            case "D":
                kp.move(Direction.DOWN);
                break;
            case "L":
                kp.move(Direction.LEFT);
                break;
            case "R":
                kp.move(Direction.RIGHT);
                break;
        }
    }
    
    static String getKeyAtCoordinate(int x, int y) {
        if (x == 0) {
            if (y == 0) {
                return "7";
            }
            if (y == 1) {
                return "4";
            }
            if (y == 2) {
                return "1";
            }
        }
        if (x == 1) {
            if (y == 0) {
                return "8";
            }
            if (y == 1) {
                return "5";
            }
            if (y == 2) {
                return "2";
            }
        }
        if (x == 2) {
            if (y == 0) {
                return "9";
            }
            if (y == 1) {
                return "6";
            }
            if (y == 2) {
                return "3";
            }
        }
        throw new IllegalArgumentException("unsupported coordinate");
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

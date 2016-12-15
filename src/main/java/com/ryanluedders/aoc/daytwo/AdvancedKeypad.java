package com.ryanluedders.aoc.daytwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedKeypad {
    
    private static final String nStr = null;
    
    static enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    };
    
    static class Coord {
        public int x;
        public int y;
    }
    
    static final List<List<String>> labels = new ArrayList<List<String>>();
    
    private Coord location = null;
    
    public AdvancedKeypad() {
        labels.add(Arrays.asList(nStr, nStr, nStr, nStr, nStr, nStr, nStr));
        labels.add(Arrays.asList(nStr, nStr, nStr, "D",  nStr, nStr, nStr));
        labels.add(Arrays.asList(nStr, nStr, "A",  "B",  "C",  nStr, nStr));
        labels.add(Arrays.asList(nStr, "5",  "6",  "7",  "8",  "9",  nStr));
        labels.add(Arrays.asList(nStr, nStr, "2",  "3",  "4",  nStr, nStr));
        labels.add(Arrays.asList(nStr, nStr, nStr, "1",  nStr, nStr, nStr));
        labels.add(Arrays.asList(nStr, nStr, nStr, nStr, nStr, nStr, nStr));
        
        location = new Coord();
        location.x = 1;
        location.y = 3;
    }
    
    public Coord getLocation() {
        return location;
    }
    
    public void move(Direction direction) {
        switch (direction) {
            case DOWN:
                if (labels.get(location.y - 1).get(location.x) != nStr) {
                    location.y = location.y - 1;
                }
                break;
            case UP:
                if (labels.get(location.y + 1).get(location.x) != nStr) {
                    location.y = location.y + 1;
                }
                break;
            case LEFT:
                if (labels.get(location.y).get(location.x - 1) != nStr) {
                    location.x = location.x - 1;
                }
                break;
            case RIGHT:
                if (labels.get(location.y).get(location.x + 1) != nStr) {
                    location.x = location.x + 1;
                }
                break;
        }     
    }
    
    public static String getLabel(int x, int y) {
        return labels.get(y).get(x);
    }

}



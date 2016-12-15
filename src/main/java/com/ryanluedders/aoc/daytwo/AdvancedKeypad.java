package com.ryanluedders.aoc.daytwo;


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
    
    static final String[][] labels = new String[][] {
        { nStr, nStr, nStr, nStr, nStr, nStr, nStr},
        { nStr, nStr, nStr, "D",  nStr, nStr, nStr},
        { nStr, nStr, "A",  "B",  "C",  nStr, nStr},
        { nStr, "5",  "6",  "7",  "8",  "9",  nStr},
        { nStr, nStr, "2",  "3",  "4",  nStr, nStr},
        { nStr, nStr, nStr, "1",  nStr, nStr, nStr},
        { nStr, nStr, nStr, nStr, nStr, nStr, nStr},
    };
    
    private Coord location = null;
    
    public AdvancedKeypad() {        
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
                if (labels[location.y - 1][location.x] != nStr) {
                    location.y = location.y - 1;
                }
                break;
            case UP:
                if (labels[location.y + 1][location.x] != nStr) {
                    location.y = location.y + 1;
                }
                break;
            case LEFT:
                if (labels[location.y][location.x - 1] != nStr) {
                    location.x = location.x - 1;
                }
                break;
            case RIGHT:
                if (labels[location.y][location.x + 1] != nStr) {
                    location.x = location.x + 1;
                }
                break;
        }     
    }
    
    public static String getLabel(int x, int y) {
        if (y > labels.length || x > labels[0].length) {
            throw new IllegalArgumentException("invalid coordinate");
        }
        return labels[y][x];
    }

}



package com.ryanluedders.aoc.daytwo;

public class SimpleKeypad {
    
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
        { null, null, null, null, null},
        { null, "7",  "8",  "9",  null},
        { null, "4",  "5",  "6",  null},
        { null, "1",  "2",  "3",  null},
        { null, null, null, null, null},
    };
    
    private Coord location = null;
    
    public SimpleKeypad() {
        location = new Coord();
        location.x = 2;
        location.y = 2;
    }
    
    public void setLocation(Coord location) {
        this.location = location;
    }
    
    public Coord getLocation() {
        return location;
    }
    
    public void move(Direction direction) {
        switch (direction) {
            case DOWN:
                if (labels[location.y - 1][location.x] != null) {
                    location.y = location.y - 1;
                }
                break;
            case UP:
                if (labels[location.y + 1][location.x] != null) {
                    location.y = location.y + 1;
                }
                break;
            case LEFT:
                if (labels[location.y][location.x - 1] != null) {
                    location.x = location.x - 1;
                }
                break;
            case RIGHT:
                if (labels[location.y][location.x + 1] != null) {
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



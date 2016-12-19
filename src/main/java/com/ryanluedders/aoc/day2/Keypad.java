package com.ryanluedders.aoc.day2;

public class Keypad {
    
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
    
    private String[][] labels;
    
    private Coord location = null;
    
    public Keypad(String[][] labels, Coord starting) {
        location = new Coord();
        location.x = starting.x;
        location.y = starting.y;
        this.labels = labels;
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
    
    public String getLabel(Coord location) {
        if (location.y > labels.length || location.x > labels[0].length) {
            throw new IllegalArgumentException("invalid coordinate");
        }
        return labels[location.y][location.x];
    }

}



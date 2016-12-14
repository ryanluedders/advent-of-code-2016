package com.ryanluedders.aoc.daytwo;

public class KeyPad {
    
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

    private int width;
    
    private int height;
    
    private Coord location = null;
    
    public KeyPad(int width, int height) {
        this.width = width;
        this.height = height;
        
        location = new Coord();
        location.x = 0;
        location.y = 0;
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
                location.y = Math.max(location.y - 1, 0);
                break;
            case UP:
                location.y = Math.min(location.y + 1, height - 1);
                break;
            case LEFT:
                location.x = Math.max(location.x - 1, 0);
                break;
            case RIGHT:
                location.x = Math.min(location.x + 1, width - 1);
                break;
        }     
    }

}



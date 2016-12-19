package com.ryanluedders.aoc.day1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayOne {
    
    static final String TURN_RIGHT = "R";
    static final String TURN_LEFT = "L";
    
    static class Coords {
        public int x;
        public int y;
        
        public Coords() {}
        
        public Coords(Coords coords) {
            this.x = coords.x;
            this.y = coords.y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Coords) {
                Coords c = (Coords) o;
                return (c.x == x && c.y == y);
            }
            return false;
        }
    };
    
    static class Position {
        static final int DIRECTION_X_POSITIVE = 0;
        static final int DIRECTION_Y_POSITIVE = 1;
        static final int DIRECTION_X_NEGATIVE = 2;
        static final int DIRECTION_Y_NEGATIVE = 3;
    
        public Coords coords;
        public int direction;
        
        public Position() {
            coords = new Coords();
        }
        
        public Position(Position position) {
            coords = new Coords(position.coords);
            direction = position.direction;
        }
        
        public String toString() {
            return (String.format("[x=%d, y=%d, facing=%d]", coords.x, coords.y, direction));
        }
    };
    
    public static void main(String[] argvs) throws IOException {
        List<String> input = parseStdIn(", ");
        
        Position position = new Position();
        position.direction = Position.DIRECTION_Y_POSITIVE;
        position.coords.x = 0;
        position.coords.y = 0;
        
        List<Coords> trackLog = new ArrayList<Coords>();
        Coords destination = null;
        
        for (String s : input) {
            if (destination == null) {
                String turnDirection = s.substring(0, 1);
                int distance = Integer.parseInt(s.substring(1));
                
                position.direction = nextDirection(position.direction, turnDirection);
                
                for (int i = 0; i < distance; i++) {
                    position.coords = moveDistanceInDirection(
                        position.coords,
                        position.direction,
                        1
                        );
                        
                    if (!trackLog.contains(position.coords)) {
                        trackLog.add(position.coords);
                    } else {
                        destination = position.coords;
                    }
                }
    
                System.out.println("turning=" + turnDirection + ", moving distance=" + 
                    Integer.toString(distance) + " position=" + position.toString());
            }
        }
        
        if (destination == null) {
            destination = position.coords;
        }
        
        int blocksAway = Math.abs(destination.x) + Math.abs(destination.y);
        System.out.println("blocksAway=" + Integer.toString(blocksAway));
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
    
    static int nextDirection(int currentDirection, String turnDirection) {
        switch (turnDirection) {
            case TURN_RIGHT:
                return Math.floorMod(currentDirection - 1, 4);
            case TURN_LEFT:
                return Math.floorMod(currentDirection + 1, 4);
        }
        throw new IllegalArgumentException("unsupported move");
    }
    
    static Coords moveDistanceInDirection(Coords startingCoords, int direction, int distance) {
        Coords result = new Coords(startingCoords);
        switch (direction) {
            case Position.DIRECTION_X_NEGATIVE:
                result.x -= distance;
                break;
            case Position.DIRECTION_X_POSITIVE:
                result.x += distance;
                break;
            case Position.DIRECTION_Y_NEGATIVE:
                result.y -= distance;
                break;
            case Position.DIRECTION_Y_POSITIVE:
                result.y += distance;
                break;
            default:
                throw new IllegalArgumentException("unsupported move");
        }
        return result;
    }
    
    static Position makeMove(Position startingPosition, String turnDirection, int distance) {
        Position newPosition = new Position();
        newPosition.direction = nextDirection(startingPosition.direction, turnDirection);
        newPosition.coords = moveDistanceInDirection(
            startingPosition.coords,
            newPosition.direction,
            distance
            );
        return newPosition;
    }
    
}

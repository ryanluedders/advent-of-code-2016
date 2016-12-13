package com.ryanluedders.aoc.dayone;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class DayOne {
    
    static final int X_POSITIVE = 0;
    static final int Y_POSITIVE = 1;
    static final int X_NEGATIVE = 2;
    static final int Y_NEGATIVE = 3;
    
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
    };
    
    static class Position {
        public Coords coords;
        public int direction;
        
        public Position() {
            coords = new Coords();
        }
        
        public Position(Position position) {
            coords = new Coords(position.coords);
            direction = position.direction;
        }
    };
    
    public static void main(String[] argvs) throws IOException {
        List<String> input = parseStdIn(", ");
        
        Coords loc = new Coords();
        loc.x = 0;
        loc.y = 0;
        
        for (String s : input) {
            String turnDirection = s.substring(0, 1);
            int distance = Integer.parseInt(s.substring(1));
            
            System.out.println(s);
        }
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
            case X_NEGATIVE:
                result.x -= distance;
                break;
            case X_POSITIVE:
                result.x += distance;
                break;
            case Y_NEGATIVE:
                result.y -= distance;
                break;
            case Y_POSITIVE:
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

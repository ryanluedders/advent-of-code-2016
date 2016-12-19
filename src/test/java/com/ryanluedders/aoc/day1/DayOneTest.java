package com.ryanluedders.aoc.day1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ryanluedders.aoc.day1.DayOne.Position;

public class DayOneTest {

    @Test
    public void testDayOne() {
        assertTrue(true);
    }
    
    @Test
    public void testNextDirection_happy_path_turnright() {
        assertEquals(3, DayOne.nextDirection(0, "R"));
        assertEquals(2, DayOne.nextDirection(3, "R"));
        assertEquals(1, DayOne.nextDirection(2, "R"));
        assertEquals(0, DayOne.nextDirection(1, "R"));
    }
    
    @Test
    public void testNextDirection_happy_path_turnleft() {
        assertEquals(1, DayOne.nextDirection(0, "L"));
        assertEquals(2, DayOne.nextDirection(1, "L"));
        assertEquals(3, DayOne.nextDirection(2, "L"));
        assertEquals(0, DayOne.nextDirection(3, "L"));
    }
    
    @Test
    public void testMoveDistanceInDirection_happy_path() {
        DayOne.Coords result = new DayOne.Coords();
        result.x = 5;
        result.y = -5;
        
        result = DayOne.moveDistanceInDirection(result, Position.DIRECTION_X_POSITIVE, 3);
        
        assertEquals(8, result.x);
        assertEquals(-5, result.y);
        
        result = DayOne.moveDistanceInDirection(result, Position.DIRECTION_Y_POSITIVE, 8);
        
        assertEquals(8, result.x);
        assertEquals(3, result.y);
        
        result = DayOne.moveDistanceInDirection(result, Position.DIRECTION_X_NEGATIVE, 10);
        
        assertEquals(-2, result.x);
        assertEquals(3, result.y);
        
        result = DayOne.moveDistanceInDirection(result, Position.DIRECTION_Y_NEGATIVE, 1);
        
        assertEquals(-2, result.x);
        assertEquals(2, result.y);
    }
    
    @Test
    public void testMakeMove_happy_path_left_turn() {
        DayOne.Position result = new DayOne.Position();
        result.direction = Position.DIRECTION_X_NEGATIVE;
        result.coords.x = 2;
        result.coords.y = 4;
        
        result = DayOne.makeMove(result, DayOne.TURN_LEFT, 5);
        
        assertNotNull(result);
        assertEquals(-1, result.coords.y);
        assertEquals(2, result.coords.x);
        assertEquals(Position.DIRECTION_Y_NEGATIVE, result.direction);
    }
    
    @Test
    public void testMakeMove_happy_path_right_turn() {
        DayOne.Position result = new DayOne.Position();
        result.direction = Position.DIRECTION_X_NEGATIVE;
        result.coords.x = 2;
        result.coords.y = 4;
        
        result = DayOne.makeMove(result, DayOne.TURN_RIGHT, 5);
        
        assertNotNull(result);
        assertEquals(9, result.coords.y);
        assertEquals(2, result.coords.x);
        assertEquals(Position.DIRECTION_Y_POSITIVE, result.direction);
    }
    
}

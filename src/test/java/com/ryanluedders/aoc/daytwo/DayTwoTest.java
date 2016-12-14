package com.ryanluedders.aoc.daytwo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTwoTest {
    
    @Test
    public void testGetKeyAtCoordinate_happy_path() {
        assertEquals("1", DayTwo.getKeyAtCoordinate(0, 2));
        assertEquals("4", DayTwo.getKeyAtCoordinate(0, 1));
        assertEquals("7", DayTwo.getKeyAtCoordinate(0, 0));
        assertEquals("2", DayTwo.getKeyAtCoordinate(1, 2));
        assertEquals("5", DayTwo.getKeyAtCoordinate(1, 1));
        assertEquals("8", DayTwo.getKeyAtCoordinate(1, 0));
        assertEquals("3", DayTwo.getKeyAtCoordinate(2, 2));
        assertEquals("6", DayTwo.getKeyAtCoordinate(2, 1));
        assertEquals("9", DayTwo.getKeyAtCoordinate(2, 0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetKeyAtCoordinate_invalid_input() {
        DayTwo.getKeyAtCoordinate(3, 3);
    }
    
}

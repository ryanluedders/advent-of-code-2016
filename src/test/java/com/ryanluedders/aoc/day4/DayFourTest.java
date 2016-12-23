package com.ryanluedders.aoc.day4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayFourTest {

    @Test
    public void testShiftLetter_happy_path() {
        assertEquals("b", DayFour.shiftLetter('a', 1));
        assertEquals("c", DayFour.shiftLetter('a', 2));
        assertEquals("a", DayFour.shiftLetter('a', 26));
        assertEquals("c", DayFour.shiftLetter('b', 27));
        assertEquals("m", DayFour.shiftLetter('l', 105));
    }
    
}

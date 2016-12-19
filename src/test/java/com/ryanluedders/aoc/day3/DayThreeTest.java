package com.ryanluedders.aoc.day3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DayThreeTest {

    @Test
    public void testAreSidesValid_valid_input() {
        assertEquals(true, DayThree.areSidesValid(1,3,3));
        assertEquals(true, DayThree.areSidesValid(3,1,3));
    }
    
    @Test
    public void testAreSidesValid_invalid_input() {
        assertEquals(false, DayThree.areSidesValid(1,1,3));
        assertEquals(false, DayThree.areSidesValid(3,1,1));
    }
    
    @Test
    public void testTransformInput() {
        List<List<String>> input = Arrays.asList(
            Arrays.asList("1", "2", "3"),
            Arrays.asList("4", "5", "6"),
            Arrays.asList("7", "8", "9")
        );
        
        List<List<String>> result = DayThree.transformInput(input);
        
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("1", result.get(0).get(0));
        assertEquals("4", result.get(0).get(1));
        assertEquals("7", result.get(0).get(2));
        assertEquals("2", result.get(1).get(0));
        assertEquals("5", result.get(1).get(1));
        assertEquals("8", result.get(1).get(2));
        assertEquals("3", result.get(2).get(0));
        assertEquals("6", result.get(2).get(1));
        assertEquals("9", result.get(2).get(2));
    }
    
}

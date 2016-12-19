package com.ryanluedders.aoc.day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ryanluedders.aoc.day2.Keypad.Coord;
import com.ryanluedders.aoc.day2.Keypad.Direction;

public class KeypadTest {
    
    @Test
    public void testMove_happy_path() {
        Coord starting = new Coord();
        starting.x = 1;
        starting.y = 3;
        Keypad k = new Keypad(DayTwo.part2, starting);
        
        assertEquals(1, k.getLocation().x);
        assertEquals(3, k.getLocation().y);
        
        k.move(Direction.RIGHT);
        assertEquals(2, k.getLocation().x);
        assertEquals(3, k.getLocation().y);
        
        k.move(Direction.LEFT);
        k.move(Direction.LEFT);
        assertEquals(1, k.getLocation().x);
        assertEquals(3, k.getLocation().y);
        
        k.move(Direction.RIGHT);
        k.move(Direction.UP);
        assertEquals(2, k.getLocation().x);
        assertEquals(4, k.getLocation().y);
        
        k.move(Direction.UP);
        assertEquals(2, k.getLocation().x);
        assertEquals(4, k.getLocation().y);
    }
    
    @Test
    public void testGetLabel_happy_path() {
        Coord starting = new Coord();
        starting.x = 1;
        starting.y = 3;
        Keypad k = new Keypad(DayTwo.part2, starting);
        
        Coord loc = new Coord();
        loc.x = 1;
        loc.y = 3;
        assertEquals("5", k.getLabel(loc));
        
        loc.x = 2;
        loc.y = 3;
        assertEquals("6", k.getLabel(loc));
        
        loc.x = 3;
        loc.y = 1;
        assertEquals("D", k.getLabel(loc));
    }
    
}

package com.ryanluedders.aoc.daytwo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ryanluedders.aoc.daytwo.SimpleKeypad.Direction;

public class SimpleKeypadTest {
    
    @Test
    public void testMove_happy_path() {
        SimpleKeypad k = new SimpleKeypad();
        
        k.move(Direction.DOWN);
        k.move(Direction.LEFT);
        assertEquals(1, k.getLocation().x);
        assertEquals(1, k.getLocation().y);
        
        k.move(Direction.DOWN);
        assertEquals(1, k.getLocation().x);
        assertEquals(1, k.getLocation().y);
        
        k.move(Direction.LEFT);
        assertEquals(1, k.getLocation().x);
        assertEquals(1, k.getLocation().y);
        
        k.move(Direction.RIGHT);
        assertEquals(2, k.getLocation().x);
        assertEquals(1, k.getLocation().y);
        
        k.move(Direction.UP);
        assertEquals(2, k.getLocation().x);
        assertEquals(2, k.getLocation().y);
        
        k.move(Direction.UP);
        k.move(Direction.UP);
        k.move(Direction.UP);
        assertEquals(2, k.getLocation().x);
        assertEquals(3, k.getLocation().y);
        
        k.move(Direction.RIGHT);
        k.move(Direction.RIGHT);
        k.move(Direction.RIGHT);
        assertEquals(3, k.getLocation().x);
        assertEquals(3, k.getLocation().y);
    }
}

package com.ryanluedders.aoc.daytwo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ryanluedders.aoc.daytwo.AdvancedKeypad.Direction;

public class AdvancedKeypadTest {
    
    @Test
    public void testMove_happy_path() {
        AdvancedKeypad k = new AdvancedKeypad();
        
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
        assertEquals("5", AdvancedKeypad.getLabel(1,3));
        assertEquals("6", AdvancedKeypad.getLabel(2,3));
        assertEquals("D", AdvancedKeypad.getLabel(3,1));
    }
    
}

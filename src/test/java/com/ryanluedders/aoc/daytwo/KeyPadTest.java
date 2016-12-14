package com.ryanluedders.aoc.daytwo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ryanluedders.aoc.daytwo.KeyPad.Coord;
import com.ryanluedders.aoc.daytwo.KeyPad.Direction;

public class KeyPadTest {
    
    @Test
    public void testMove_happy_path() {
        KeyPad k = new KeyPad(3, 3);
        
        Coord location = new Coord();
        location.x = 0;
        location.y = 0;
        k.setLocation(location);
        
        assertEquals(0, k.getLocation().x);
        assertEquals(0, k.getLocation().y);
        
        k.move(Direction.DOWN);
        assertEquals(0, k.getLocation().x);
        assertEquals(0, k.getLocation().y);
        
        k.move(Direction.LEFT);
        assertEquals(0, k.getLocation().x);
        assertEquals(0, k.getLocation().y);
        
        k.move(Direction.RIGHT);
        assertEquals(1, k.getLocation().x);
        assertEquals(0, k.getLocation().y);
        
        k.move(Direction.UP);
        assertEquals(1, k.getLocation().x);
        assertEquals(1, k.getLocation().y);
        
        k.move(Direction.UP);
        k.move(Direction.UP);
        k.move(Direction.UP);
        assertEquals(1, k.getLocation().x);
        assertEquals(2, k.getLocation().y);
        
        k.move(Direction.RIGHT);
        k.move(Direction.RIGHT);
        k.move(Direction.RIGHT);
        assertEquals(2, k.getLocation().x);
        assertEquals(2, k.getLocation().y);
    }
}

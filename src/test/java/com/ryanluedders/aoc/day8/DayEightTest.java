package com.ryanluedders.aoc.day8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ryanluedders.aoc.day8.DayEight.Operation;
import com.ryanluedders.aoc.day8.DayEight.RectOperation;
import com.ryanluedders.aoc.day8.DayEight.RotateColumnOperation;
import com.ryanluedders.aoc.day8.DayEight.RotateRowOperation;
import com.ryanluedders.aoc.day8.DayEight.Screen;

public class DayEightTest {

    @Test
    public void parseCommandsTest() {
        List<String> input = Arrays.asList(
                "rotate row y=1 by 10",
                "rotate column x=48 by 4",
                "rect 7x1"
                );
        
        List<Operation> result = DayEight.parseCommands(input);
        
        assertTrue(result.get(0) instanceof RotateRowOperation);
        assertEquals(1, ((RotateRowOperation) result.get(0)).row);
        assertEquals(10, ((RotateRowOperation) result.get(0)).shift);
        
        assertTrue(result.get(1) instanceof RotateColumnOperation);
        assertEquals(48, ((RotateColumnOperation) result.get(1)).column);
        assertEquals(4, ((RotateColumnOperation) result.get(1)).shift);
        
        assertTrue(result.get(2) instanceof RectOperation);
        assertEquals(7, ((RectOperation) result.get(2)).width);
        assertEquals(1, ((RectOperation) result.get(2)).height);
    }
    
    @Test
    public void testScreenOperation() {
        Screen s = new Screen(50, 6);
        s.set(0, 0, true);
        s.set(0, 1, true);
        s.set(3, 2, true);
        s.set(3, 3, true);
        
        System.out.println(s.toString());
        
        assertEquals(4, s.getNumberLit());
        
        assertEquals(true, s.get(0, 0));
        assertEquals(true, s.get(0, 1));
        assertEquals(false, s.get(0, 2));
        assertEquals(false, s.get(3, 1));
        assertEquals(true, s.get(3, 2));
        assertEquals(true, s.get(3, 3));
        assertEquals(false, s.get(3, 4));
        assertEquals(false, s.get(4, 3));
        
        s.rotateRow(1, 2);
        System.out.println("\n\n" + s.toString());
        assertEquals(false, s.get(0, 1));
        assertEquals(true, s.get(2, 1));
        
        s.rotateColumn(3, 2);
        System.out.println("\n\n" + s.toString());
        assertEquals(false, s.get(3, 2));
        assertEquals(false, s.get(3, 3));
        assertEquals(true, s.get(3, 4));
        assertEquals(true, s.get(3, 5));
        
        s.rotateColumn(3,  1);
        System.out.println("\n\n" + s.toString());
        assertEquals(true, s.get(3, 5));
        assertEquals(true, s.get(3, 0));
        
        s.rotateRow(1, 60);
        System.out.println("\n\n" + s.toString());
        assertEquals(true, s.get(12, 1));
        
        assertEquals(4, s.getNumberLit());
    }
    
}

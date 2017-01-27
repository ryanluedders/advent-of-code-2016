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
    
}

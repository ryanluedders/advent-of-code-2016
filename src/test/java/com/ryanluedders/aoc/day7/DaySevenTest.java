package com.ryanluedders.aoc.day7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DaySevenTest {

    @Test
    public void testIsABBAPattern() {
        assertEquals(false, DaySeven.isABBAPattern("abcd"));
        assertEquals(true, DaySeven.isABBAPattern("abba"));
        assertEquals(true, DaySeven.isABBAPattern("cmmc"));
        assertEquals(false, DaySeven.isABBAPattern("aaab"));
        assertEquals(true, DaySeven.isABBAPattern("aaaa"));
        assertEquals(true, DaySeven.isABBAPattern("xyzabbaghj"));
    }

    @Test
    public void testIsAAAAPattern() {
        assertEquals(false, DaySeven.isAAAAPattern("abcd"));
        assertEquals(false, DaySeven.isAAAAPattern("abba"));
        assertEquals(false, DaySeven.isAAAAPattern("cmmc"));
        assertEquals(false, DaySeven.isAAAAPattern("aaab"));
        assertEquals(true, DaySeven.isAAAAPattern("aaaa"));
    }
    
    @Test
    public void testReplaceBracketedText_happy_path() {
        assertEquals("abc-ghi-mno", DaySeven.replaceBracketedText("abc[def]ghi[jkl]mno", "-"));
        assertEquals("abcd", DaySeven.replaceBracketedText("abcd", "-"));
    }
    
    @Test
    public void testReplaceTextOutsideBrackets_happy_path() {
        assertEquals("def-jkl", DaySeven.replaceTextOutsideBrackets("abc[def]ghi[jkl]mno", "-"));
        assertEquals("", DaySeven.replaceTextOutsideBrackets("abcd", "-"));
    }
    
}

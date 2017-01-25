package com.ryanluedders.aoc.day7;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class DaySevenPartTwoTest {
	
	@Test
	public void testIsABA_true() {
		assertEquals(true, DaySevenPartTwo.isAba("aba"));
		assertEquals(true, DaySevenPartTwo.isAba("yhy"));
	}
	
	@Test
	public void testIsABA_false() {
		assertEquals(false, DaySevenPartTwo.isAba("hhy"));
		assertEquals(false, DaySevenPartTwo.isAba("aaa"));
		assertEquals(false, DaySevenPartTwo.isAba("bb"));
	}
	
	@Test
	public void testIsABA_null_empty() {
		assertEquals(false, DaySevenPartTwo.isAba(""));
		assertEquals(false, DaySevenPartTwo.isAba(null));
	}
	
	@Test
	public void testIsCorrespondingBab_true() {
		assertEquals(true, DaySevenPartTwo.isCorrespondingBab("bab", "aba"));
		assertEquals(true, DaySevenPartTwo.isCorrespondingBab("rhr", "hrh"));
	}
	
	@Test
	public void testIsCorrespondingBab_false() {
		assertEquals(false, DaySevenPartTwo.isCorrespondingBab("baa", "aba"));
		assertEquals(false, DaySevenPartTwo.isCorrespondingBab("nn", "hrh"));
	}
    
	@Test
	public void testIsCorrespondingBab_empty_null_input() {
		assertEquals(false, DaySevenPartTwo.isCorrespondingBab("", "aba"));
		assertEquals(false, DaySevenPartTwo.isCorrespondingBab(null, "hrh"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsCorrespondingBab_invalid_aba() {
		assertEquals(false, DaySevenPartTwo.isCorrespondingBab("", "ab"));
	}
	
	@Test
	public void testGetOuters() {
		List<String> result = DaySevenPartTwo.getOuters("abc[def]hij[klm]nop");
		
		assertEquals("abc", result.get(0));
		assertEquals("hij", result.get(1));
		assertEquals("nop", result.get(2));
	}
	
	@Test
	public void testGetOuters_no_brackets() {
		List<String> result = DaySevenPartTwo.getOuters("abcdef");
		
		assertEquals("abcdef", result.get(0));
	}
	
	@Test
	public void testGetOuters_empty_nul() {
		List<String> result = DaySevenPartTwo.getOuters("");
		
		assertEquals(1, result.size());
		assertEquals("", result.get(0));
		
		assertEquals(null, DaySevenPartTwo.getOuters(null));
	}
	
	@Test
	public void testGetInners() {
		List<String> result = DaySevenPartTwo.getInners("abc[def]hij[klm]nop");
		
		assertEquals("def", result.get(0));
		assertEquals("klm", result.get(1));
	}
	
	@Test
	public void testGetInners_no_brackets() {
		List<String> result = DaySevenPartTwo.getInners("abcdef");
		
		assertEquals(0, result.size());
	}
	
	@Test
	public void testGetInners_empty_nul() {
		List<String> result = DaySevenPartTwo.getInners("");
		
		assertEquals(0, result.size());
		
		assertEquals(null, DaySevenPartTwo.getInners(null));
	}
	
	@Test
	public void testIsMatchingRecord() {
		assertEquals(true, DaySevenPartTwo.isMatchingRecord("nhsabaakgd[aiobabaeg]"));
		assertEquals(true, DaySevenPartTwo.isMatchingRecord("nhsxyzaaba[aiobabaeg]"));
		assertEquals(true, DaySevenPartTwo.isMatchingRecord("nhsabaakgd[aioaegbab]"));
	}
	
}

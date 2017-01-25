package com.ryanluedders.aoc.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DaySevenPartTwo {
	
	private static final int ABA_BAB_LENGTH = 3;
	
	public static void main(String[] argvs) throws IOException {
		solveProblem();
	}
	
	public static void solveProblem() throws IOException {
		List<String> input = parseStdIn();
		
		int count = 0;
		
		for (String s : input) {
			count += (isMatchingRecord(s) ? 1 : 0);
		}
		
		System.out.println("matchCount=" + Integer.toString(count));
	}
	
	public static boolean isMatchingRecord(String input) {
		List<String> outers = getOuters(input);
		List<String> inners = getInners(input);
		
		for (String o : outers) {
			for (int i = 0; i + ABA_BAB_LENGTH <= o.length(); i++) {
				String aba = o.substring(i, i + ABA_BAB_LENGTH);
				if (isAba(aba)) {
					for (String inr : inners) {
						for (int j = 0; j + ABA_BAB_LENGTH <= inr.length(); j++) {
							String bab = inr.substring(j, j + ABA_BAB_LENGTH);
							if (isCorrespondingBab(bab, aba)) {
								System.out.println("pair=" + aba + "," + bab + "; input=" + input);
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public static List<String> getOuters(String input) {
		if (input == null) {
			return null;
		}
		
		String[] tokens = input.split("[\\[\\]]");
		
		List<String> results = new ArrayList<>();
		
		for (int i = 0; i < tokens.length; i++) {
			if (i % 2 == 0) {
				results.add(tokens[i]);
			}
		}
		
		return results;
	}
	
	public static List<String> getInners(String input) {
		if (input == null) {
			return null;
		}
		
		String[] tokens = input.split("[\\[\\]]");
		
		List<String> results = new ArrayList<>();
		
		for (int i = 0; i < tokens.length; i++) {
			if (i % 2 != 0) {
				results.add(tokens[i]);
			}
		}
		
		return results;
	}

	public static boolean isAba(String input) {
		if (input != null 
				&& input.length() == ABA_BAB_LENGTH 
				&& input.charAt(2) == input.charAt(0)
				&& input.charAt(1) != input.charAt(0)) {
			return true;
		}
		return false;
	}

	public static boolean isCorrespondingBab(String input, String aba) {
		if (aba == null || aba.length() != ABA_BAB_LENGTH) {
			throw new IllegalArgumentException("invalid aba");
		}

		if (input != null 
				&& input.length() == ABA_BAB_LENGTH 
				&& input.charAt(0) == aba.charAt(1) 
				&& input.charAt(1) == aba.charAt(0)
				&& input.charAt(2) == aba.charAt(1)) {
			return true;
		}

		return false;
	}
	
    private static List<String> parseStdIn() throws IOException {
        List<String> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            values.add(line);
        }
        
        return values;
    }  

}

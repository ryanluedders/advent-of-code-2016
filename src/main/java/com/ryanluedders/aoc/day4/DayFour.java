package com.ryanluedders.aoc.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFour {
    
    private static final int IDX_SECTOR_ID = 1;
    private static final int IDX_ENC_NAME = 0;
    private static final int IDX_HASH = 2;

    public static void main(String[] argvs) throws IOException {
        List<List<String>> inputs = parseStdIn();
        
        int sum = 0;
        
        for (List<String> l : inputs) {
            String calculatedHash = convertLetterCountToHash(getLetterCount(l.get(IDX_ENC_NAME)));
            //System.out.println("id=" + l.get(IDX_SECTOR_ID) + " inputHash=" + l.get(IDX_HASH) 
            //    + " calculatedHash=" + calculatedHash);
            
            int offset = Integer.valueOf(l.get(1));
            System.out.println("sectorId=" + l.get(1)
                + " decryptedName=" + shiftWord(l.get(0), offset));
                
            if (l.get(IDX_HASH).equals(calculatedHash)) {
                sum += Integer.valueOf(l.get(IDX_SECTOR_ID));
            }
        }
        
        System.out.println("sum-of-ids=" + Integer.toString(sum));
    }
    
    private static List<List<String>> parseStdIn() throws IOException {
        List<List<String>> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            Pattern p = Pattern.compile("^(.*)-(\\d+)\\[(.*)\\]$");
            Matcher m = p.matcher(line);
            if (m.matches()) {
                List<String> addition = Arrays.asList(
                    m.group(IDX_ENC_NAME + 1), 
                    m.group(IDX_SECTOR_ID + 1), 
                    m.group(IDX_HASH + 1));
                values.add(addition);
                
                System.out.println("parsed line=" + line + " to ["
                    + addition.toString() + "]");
            }
        }
        
        return values;
    }
    
    static Map<Character, Integer> getLetterCount(String input) {
        Map<Character, Integer> letterCount = new HashMap<Character, Integer>();

        for (Character c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!letterCount.containsKey(c)) {
                    letterCount.put(c, 1);
                } else {
                    letterCount.put(c, letterCount.get(c) + 1);
                }
            }   
        }
    
        return letterCount;
    }
    
    static String convertLetterCountToHash(Map<Character, Integer> input) {
        List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(input.entrySet());

        Collections.sort(sorted, new Comparator<Map.Entry<Character, Integer>>() {
           public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
               if (a.getValue() != b.getValue()) {
                   return Integer.compare(b.getValue(), a.getValue());
               } else {
                   return Character.compare(a.getKey(), b.getKey());
               }
           } 
        });
        
        String result = "";
        
        for (int i = 0; i < 5; i++) {
            result += sorted.get(i).getKey();
        }
        
        return result;
    }
    
    static String shiftWord(String input, int offset) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c.equals('-')) {
                result += ' ';
            } else {
                result += shiftLetter(input.charAt(i), offset);
            }
        }
        return result;
    }
    
    static String shiftLetter(Character c, int offset) {
        int shift = offset % 26;
        int startingOffsetFromA = c.charValue() - 'a';
        int newOffsetFromA = (startingOffsetFromA + shift) % 26;
        char newValue = (char) (newOffsetFromA + (int) 'a');
        return Character.toString(newValue);
    }
    
}

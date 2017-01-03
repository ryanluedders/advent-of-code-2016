package com.ryanluedders.aoc.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

public class DayFive {

    public static void main(String[] argvs) throws IOException, NoSuchAlgorithmException {
        String input = parseStdIn().get(0);
        
        int idx = 0;
        String result = "";
        ArrayList<Character> secondResult = new ArrayList<>(
            Collections.nCopies(8, (Character)null));
        
        while (result.length() < 8 || !isComplete(secondResult)) {
            String combo = input + Integer.toString(idx);
            
            byte[] md5 = MessageDigest.getInstance("MD5").digest(combo.getBytes("UTF-8"));
            String md5String = DatatypeConverter.printHexBinary(md5);
            
            if (md5String.startsWith("00000")) {
                if (result.length() < 8) {
                    result += String.valueOf(md5String.charAt(5));
                }

                if (!isComplete(secondResult)) {
                    int secondResultIdx = Character.getNumericValue(md5String.charAt(5));
                    if (secondResultIdx >= 0 && secondResultIdx < 8 
                        && secondResult.get(secondResultIdx) == null) 
                    {
                        char secondResultCharacter = md5String.charAt(6);
                        secondResult.set(secondResultIdx, secondResultCharacter);
                    }
                }
            }
            idx++;
        }
        
        System.out.println("password=" + result);
        System.out.println("second Password=" + characterArrayToString(secondResult));
    }
    
    private static boolean isComplete(List<Character> in) {
        for (Character c : in) {
            if (c == null) {
                return false;
            }
        }
        return true;
    }
    
    private static String characterArrayToString(List<Character> in ) {
        String result = "";
        for (Character c : in) {
            result += c.toString();
        }
        return result;
    }
    
    private static List<String> parseStdIn() throws IOException {
        List<String> values = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            Pattern p = Pattern.compile("^(.*)$");
            Matcher m = p.matcher(line);
            if (m.matches()) {
                values.add(m.group(1));
            }
        }
        
        return values;
    }    
}

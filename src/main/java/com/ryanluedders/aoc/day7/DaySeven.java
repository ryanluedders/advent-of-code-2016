package com.ryanluedders.aoc.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DaySeven {
    
    private static Pattern ABBA = 
        Pattern.compile(".*(?<firstletter>[a-zA-Z])(?<secondletter>[a-zA-Z])\\k<secondletter>\\k<firstletter>.*");
    
    private static Pattern AAAA =
        Pattern.compile(".*(?<firstletter>[a-zA-Z])\\k<firstletter>{3}.*");
    
    public static void main(String[] argvs) throws IOException, NoSuchAlgorithmException {
        List<String> input = parseStdIn();
        
        int count = 0;
        
        for (String s : input) {
            List<String> outsideBrackets = Arrays.asList(
                replaceBracketedText(s, "-").split("-"));
            List<String> insideBrackets = Arrays.asList(
                replaceTextOutsideBrackets(s, "-").split("-"));
            
            boolean isTls = false;
            for (String g : outsideBrackets) {
                if (isABBAPattern(g) && !isAAAAPattern(g)) {
                    isTls = true;
                }
            }
            
            for (String g : insideBrackets) {
                if (isABBAPattern(g) && !isAAAAPattern(g)) {
                    isTls = false;
                }
            }
            
            if (isTls) {
                count += 1;
            }
        }
        
        System.out.println("tls-count=" + Integer.toString(count));
        
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
    
    public static String replaceBracketedText(String source, String replaceWith) {
        if (source == null) {
            return null;
        }
        
        return source.replaceAll("\\[[^\\[\\]]*\\]", replaceWith);
    }
    
    public static String replaceTextOutsideBrackets(String source, String replaceWith) {
        if (source == null) {
            return null;
        }
        
        String result = source.replaceAll("^[^\\[]*\\[?", "");
        result = result.replaceAll("\\][^\\[]*\\[", replaceWith);
        result = result.replaceAll("\\][^\\[]*$", "");
        
        return result;
    }
    
    public static boolean isABBAPattern(String input) {
        return ABBA.matcher(input).matches();
    }
    
    public static boolean isAAAAPattern(String input) {
        return AAAA.matcher(input).matches();
    }
}

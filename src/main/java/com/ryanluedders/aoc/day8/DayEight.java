package com.ryanluedders.aoc.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEight {
    
    static abstract class Operation { }
    
    static class RotateRowOperation extends Operation {
        public int row;
        public int shift;
    }
    
    static class RotateColumnOperation extends Operation {
        public int column;
        public int shift;
    }
    
    static class RectOperation extends Operation {
        public int width;
        public int height;
    }
    
    static class Screen {
        
        private boolean segments[][];
        
        public Screen (int width, int height) {
            segments = new boolean[height][width];
        }
        
        public void set(int x, int y, boolean on) {
            System.out.println("x=" + x + " y=" + y + " w=" + segments.length + " h=" + segments[0].length);
            segments[y][x] = on;
        }
        
        public boolean get(int x, int y) {
            System.out.println("x=" + x + " y=" + y + " w=" + segments.length + " h=" + segments[0].length);
            return segments[y][x];
        }
        
        public void rotateRow(int row, int shift) {
            int realShift = shift % segments[row].length;
            boolean newRow[] = new boolean[segments[row].length];
            for (int i = 0; i < segments[row].length; i++) {
                newRow[(i + realShift) % newRow.length] = segments[row][i];
            }
            segments[row] = newRow;
        }
        
        public void rotateColumn(int column, int shift) {
            int realShift = shift % segments.length;
            boolean newColumn[] = new boolean[segments.length];
            for (int i = 0; i < segments.length; i++) {
                newColumn[(i + realShift) % newColumn.length] = segments[i][column];
            }
            for (int i = 0; i < segments.length; i++) {
                segments[i][column] = newColumn[i];
            }
        }
        
        public int getNumberLit() {
            int result = 0;
            for (int i = 0; i < segments.length; i++) {
                for (int j = 0; j < segments[i].length; j++) {
                    result += (segments[i][j] ? 1 : 0);
                }
            }
            return result;
        }
        
        public String toString() {
            String result = "";
            for (int i = 0; i < segments.length; i++) {
                for (int j = 0; j < segments[i].length; j++) {
                    result += (segments[i][j] ? "X" : ".");
                    result += " ";
                }
                result += "\n";
            }
            return result;
        }
    }
    
    private static Pattern RECT_PATTERN = Pattern.compile("rect ([0-9]+)x([0-9]+)");
    private static Pattern ROTATE_ROW_PATTERN = Pattern.compile("rotate row y=([0-9]+) by ([0-9]+)");
    private static Pattern ROTATE_COL_PATTERN = Pattern.compile("rotate column x=([0-9]+) by ([0-9]+)");
    
    private static final int SCREEN_WIDTH = 50;
    private static final int SCREEN_HEIGHT = 6;
    
    public static void main(String[] argvs) throws IOException {
        List<String> input = parseStdIn();
        
        List<Operation> operations = parseCommands(input);
        
        System.out.println(operations.toString());
        
        Screen s = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        for (Operation o : operations) {
            if (o instanceof RectOperation) {
                RectOperation ro = (RectOperation) o;
                for (int i = 0; i < ro.width; i++) {
                    for (int j = 0; j < ro.height; j++) {
                        s.set(i, j, true);
                    }
                }
            }
            if (o instanceof RotateRowOperation) {
                RotateRowOperation ro = (RotateRowOperation) o;
                s.rotateRow(ro.row, ro.shift);
            }
            if (o instanceof RotateColumnOperation) {
                RotateColumnOperation ro = (RotateColumnOperation) o;
                s.rotateColumn(ro.column, ro.shift);
            }
        }
        
        System.out.println("numberLit=" + s.getNumberLit() + "\n\n");
        
        System.out.println(s.toString());
    }
    
    static List<Operation> parseCommands(List<String> input) {
        List<Operation> result = new ArrayList<>();
        
        for (String s : input) {
            Matcher rectMatcher = RECT_PATTERN.matcher(s);
            Matcher rrMatcher = ROTATE_ROW_PATTERN.matcher(s);
            Matcher rcMatcher = ROTATE_COL_PATTERN.matcher(s);
            
            if (rectMatcher.matches()) {
                //System.out.println("rect w=" + rectMatcher.group(1) + " h=" + rectMatcher.group(2));
                RectOperation o = new RectOperation();
                o.height = Integer.parseInt(rectMatcher.group(2));
                o.width = Integer.parseInt(rectMatcher.group(1));
                result.add(o);
            } else if (rrMatcher.matches()) {
                //System.out.println("rotate row y=" + rrMatcher.group(1) + " amt=" + rrMatcher.group(2));
                RotateRowOperation o = new RotateRowOperation();
                o.row = Integer.parseInt(rrMatcher.group(1));
                o.shift = Integer.parseInt(rrMatcher.group(2));
                result.add(o);
            } else if (rcMatcher.matches()) {
                //System.out.println("rotate col c=" + rcMatcher.group(1) + " amt=" + rcMatcher.group(2));
                RotateColumnOperation o = new RotateColumnOperation();
                o.column = Integer.parseInt(rcMatcher.group(1));
                o.shift = Integer.parseInt(rcMatcher.group(2));
                result.add(o);
            }
        }
        
        return result;
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

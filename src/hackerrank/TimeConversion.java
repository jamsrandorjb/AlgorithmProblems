package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/time-conversion/problem
 * solved by jama
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeConversion {

    static String timeConversion(String s) {
        // Complete this function
        String ret ="";
        if(s.contains("P"))
            if(Integer.parseInt(s.substring(0, 2)) == 12)
                ret += "12";
            else
                ret += ""+(Integer.parseInt(s.substring(0, 2))+12);    
        else
            if(Integer.parseInt(s.substring(0, 2)) == 12)
                ret += "00";
            else
                ret += s.substring(0, 2);
            
        ret += ":";
        ret += s.substring(3, 5);
        ret += ":";
        ret += s.substring(6, 8);
        return ret;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}

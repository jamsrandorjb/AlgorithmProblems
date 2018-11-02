package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/kangaroo/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        
        if((x1 == x2 && v1 != v2) || (x1 != x2 && v1 == v2) || 
           (x1 < x2 && v1 <= v2) || (x1 > x2 && v1 >= v2)) return "NO";
        int temp = x2-x1;
        for(int i=0; i < temp; i++)
        {
            x1 += v1;
            x2 += v2;
            if(x1 == x2) return "YES";
            if(x1 > x2) return "NO"; 
        }
        return "NO";
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/staircase/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            for(int i=1;i<=n;i++){
                System.out.print(i<n-j?" ":"#");
            }
            System.out.println("");
        }
    }
}


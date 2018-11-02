package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/java-2d-array/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class twoDarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[][] = new int[6][6];
        
        int sum = -1000;
        int tempSum = -1000;
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                a[i][j] = in.nextInt();
            }
        }
        
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                tempSum = a[i][j] + a[i][j+1]+a[i][j+2]
                                    + a[i+1][j+1]
                          +a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
                if(tempSum > sum)
                     sum = tempSum;
            }
        }
        System.out.println(sum);
    }
}

package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        int max = ar[0];
        int cnt =1;
        for(int i =1; i<ar.length; i++)
            if(max <ar[i])
            {
                cnt=1;
                max = ar[i];
            }
            else if(max == ar[i])
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}

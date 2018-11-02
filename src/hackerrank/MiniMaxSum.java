package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/mini-max-sum/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        long maxSum =0;
        long minSum =0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        java.util.Arrays.sort(arr);
        for (int i=0; i< arr.length-1; i++)
            minSum = minSum+arr[i];
        for (int i=1; i< arr.length; i++)
            maxSum = maxSum+arr[i];
        System.out.println(minSum+" "+maxSum);
    }
}

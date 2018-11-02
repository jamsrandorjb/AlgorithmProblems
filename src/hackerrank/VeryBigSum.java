package hackerrank;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 * solved by jama
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VeryBigSum {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("0");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            a = a.add(BigInteger.valueOf(arr[arr_i]));
        }
        System.out.println(a);
    }
}

package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/plus-minus/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        double negativeCount=0.0,positiveCount=0.0,zeroCount=0.0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            int num = arr[arr_i];
            if(num<0){
                negativeCount++;
            }else if(num>0){
                positiveCount++;
            }else{
                zeroCount++;
            }
        }
        System.out.printf("%.6f\n%.6f\n%.6f",positiveCount/n,negativeCount/n,zeroCount/n);
    }
}




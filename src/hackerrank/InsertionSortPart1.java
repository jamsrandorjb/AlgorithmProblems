package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/insertionsort1/problem
 * solved by jama
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart1 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int temp = arr[arr.length-1];
        for(int i= arr.length-2; i >-1 ; i--)
        {
            if(arr[i]>=temp)
            {
                arr[i+1] = arr[i];
                for(int j=0; j< arr.length; j++)
                    System.out.print(arr[j]+" ");
                System.out.println();
            }
            else
            {
                arr[i+1] = temp;
                for(int j=0; j< arr.length; j++)
                    System.out.print(arr[j]+" ");
                return;
            }                
        }
        arr[0] = temp;
        for(int j=0; j< arr.length; j++)
            System.out.print(arr[j]+" ");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}

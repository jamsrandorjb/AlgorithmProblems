package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/countingsort2/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingSortPart2 {

    // Complete the countingSort function below.
    static void countingSort(int[] arr) throws IOException {
    int[] result = new int[100];
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    for(int i : arr)
        result[i]++;
    for(int i=0;i<result.length;i++)
    {
        for(int j=0;j<result[i];j++)
        {
            bufferedWriter.write(String.valueOf(i));
            if (i != result.length) {
                bufferedWriter.write(" ");
            }
        }
    }
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        countingSort(arr);

                

        scanner.close();
    }
}

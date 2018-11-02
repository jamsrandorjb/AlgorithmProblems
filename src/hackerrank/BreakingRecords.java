package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * solved by jama
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] score) {
        int max=score[0];
        int min=score[0];
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        for(int i=1; i<score.length; i++)
        {
            if(score[i] > max)
            {
                max = score[i];
                result[0] = result[0]+1;
            }
            if(score[i] < min)
            {
                min = score[i];
                result[1] = result[1]+1;
            } 
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] score = new int[n];

        String[] scoreItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoreItem = Integer.parseInt(scoreItems[i]);
            score[i] = scoreItem;
        }

        int[] result = breakingRecords(score);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

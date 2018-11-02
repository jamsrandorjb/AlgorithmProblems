package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/migratory-birds/problem
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

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
            int max =0;
            for(int i =0; i< ar.length; i++)
              max = ar[i] > max ? ar[i] : max;  
            int cnt = 0;
            int[] temp = new int[max+1];
            for(int i =0; i< ar.length; i++)
            {
                temp[ar[i]]++;
                cnt = temp[ar[i]] > cnt ? temp[ar[i]] : cnt;
            }
            for(int i =0; i< temp.length; i++)
            		if(temp[i] == cnt)
            			return i;
            return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

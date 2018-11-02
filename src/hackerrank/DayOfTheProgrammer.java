package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/day-of-the-programmer/problem
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

public class DayOfTheProgrammer {

    // Complete the solve function below.
    static String solve(int year) {
        if( year == 1918 ) 
            return "26.09.1918";
        if( year % 4 != 0 ) 
            return "13.09." + Integer.toString( year );
        if( year > 1918 && year % 100 == 0 && year % 400 != 0 ) 
            return "13.09." + Integer.toString( year );
        return "12.09." + Integer.toString( year );
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/marcs-cakewalk/problem
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

public class MarksCakeWalk {

    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {
    	List<Integer> test = new ArrayList<Integer>();
    	for(int i=0; i<calorie.length-1; i++)
        {
    		for(int j=i; j<calorie.length; j++)	
	           if(calorie[i]<calorie[j]) {
	        	   		int temp = calorie[i];
	        	   		calorie[i] = calorie[j];
	        	   		calorie[j] = temp;
               }   	
        }
        long result =0;
        for(int i=0; i<calorie.length; i++)
            result += calorie[i]*Math.pow(2, i);
        return result;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/find-the-median/problem
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

public class FindTheMedian {

    // Complete the findMedian function below.
    static int findMedian(int[] arr) {
        int a_length = arr.length;
        if(a_length%2==0)
            return selectRecursive(arr, a_length/2-1);
        return selectRecursive(arr, a_length/2);
    }
    
    public static int selectRecursive(int[] array, int n) {
		return recursive(array, 0, array.length - 1, n);
	}
	private static int recursive(int[] array, int left, int right, int n) {
		if (left == right) {
			return array[left]; 
		}
		
		int pivotIndex = randomPivot(left, right); 
		pivotIndex = partition(array, left, right, pivotIndex);
		if (n == pivotIndex) {
			return array[n];
		} else if (n < pivotIndex) {
			return recursive(array, left, pivotIndex - 1, n);
		} else {
			return recursive(array, pivotIndex + 1, right, n);
		}
	}
    private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right); 
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex);
		return storeIndex;
	}
    private static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
    private static int randomPivot(int left, int right) {
		return left + (int) Math.floor(Math.random() * (right - left + 1));
	}	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

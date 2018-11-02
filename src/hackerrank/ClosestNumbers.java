package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/closest-numbers/problem
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

public class ClosestNumbers {

    // Complete the closestNumbers function below.
    static void closestNumbers(int[] arr) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int temp=0;
        int[] res = sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<res.length-1; i++)
        {
            if(min> res[i+1] - res[i])
                min = res[i+1] - res[i];
        }
        for(int i=0; i<res.length-1; i++)
        {
            
            if(min == res[i+1] - res[i])
            {
                if(temp>0)
                    bufferedWriter.write(" ");    
                bufferedWriter.write(String.valueOf(res[i]));
                bufferedWriter.write(" ");
                bufferedWriter.write(String.valueOf(res[i+1]));
                temp++;
            }
            
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

    }
    static int[] sort(int[] arr){
		int[] prepared = prepare(arr);
		qsort(prepared,1, prepared.length-2);
		return prepared;
	}
    static int[] prepare(int[] input){
		int[] prepared = new int[input.length+2];
		prepared[0]=Integer.MIN_VALUE;
		prepared[input.length+1] = Integer.MAX_VALUE;
		for(int i=0; i < input.length;++i){
			prepared[i+1]=input[i];
		}	
		return prepared;
	}
    static void qsort(int[] keyArray, int lower, int upper) {
		int lowPtr, highPtr;		// these are the moving pointers into the array
		int temp;
				
		if (upper <= lower) {
			return;			// base case
		} 
		else {
			//locate position of pivot
			int pivotPos = medianOfThree(keyArray,lower,upper);
			
			//swap pivot to last position
			swap(keyArray,pivotPos,upper);
			
			//pivot is now in rightmost slot
			int pivot = keyArray[upper];
			
			//define the pointers
			lowPtr = lower;
			highPtr = upper-1;
			
			//use the pointers to create the partitions in the array
			
			while (true) {
				while (keyArray[lowPtr] < pivot && lowPtr<=highPtr) lowPtr++;
				while (keyArray[highPtr] > pivot && lowPtr <= highPtr) highPtr--;			
				if(lowPtr <= highPtr) {
					swap(keyArray, lowPtr++,highPtr--);
				}
				else break;
			}
			
			
			//restore pivot to correct spot
			swap(keyArray, upper,lowPtr);
			
			
			qsort(keyArray,lower, lowPtr-1);
			qsort(keyArray,lowPtr+1, upper);
		}
	}
    static void swap(int[] arr, int i, int j){
		if(arr == null || i == j || i >= arr.length || j >=arr.length) return;
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
		
	}
    static int medianOfThree(int[] arr, int left, int right){
		if(right-left < 2) return left;
		int center = (left+right)/2;
		//arrange the three
		if(arr[center] < arr[left]) swap(arr,center,left);
		if(arr[right] < arr[left]) swap(arr,right,left);
		if(arr[right] < arr[center]) swap(arr,right,center);
		return center;
		
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

        closestNumbers(arr);

        
        scanner.close();
    }
}


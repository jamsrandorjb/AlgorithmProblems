package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/java-negative-subarray/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

import java.io.*;
import java.util.*;

public class SubArray {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int counter = 0;
		for (int k = 0; k < n; k++)
			a[k] = sc.nextInt();

		for (int j = 0; j < n; j++) {
			int sum = 0;
			for (int k = j; k < n; k++) {
				sum = a[k] + sum;
				if (sum < 0) {
					counter++;
				}
			}
		}
		sc.close();
		System.out.println(counter);
	}
}
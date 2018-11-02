package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/sock-merchant/problem
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

public class SockMerchant {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int ret = 0;
		List<Integer> x = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++)
			if (!x.contains(ar[i]))
				x.add(ar[i]);
		for (int i = 0; i < x.size(); i++) {
			int temp = 0;
			for (int j = 0; j < ar.length; j++) {
				if (x.get(i) == ar[j])
					temp++;
			}
			ret += temp / 2;
		}
		return ret;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

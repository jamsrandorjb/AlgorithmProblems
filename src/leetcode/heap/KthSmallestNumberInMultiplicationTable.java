package leetcode.heap;

import java.util.PriorityQueue;

/*
* 668. Kth Smallest Number in Multiplication Table
* problem url: https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class KthSmallestNumberInMultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthNumber(3, 3, 5));
		System.out.println(findKthNumberBruteForce(3, 3, 5));
	}

	static int m;
	static int n;

	public static int findKthNumber(int im, int in, int k) {
		m = im;
		n = in;

		int low = 1;
		int high = m * n;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (!checkLimit(mid, k)) {
				low = mid + 1;
				continue;
			}
			high = mid;
		}

		return low;
	}
	
	private static boolean checkLimit(int x, int k) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count = count + Math.min(x / i, n);
		}

		return count >= k;
	}

	// Time Limit Exceeds but works
	public static int findKthNumberBruteForce(int m, int n, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				minHeap.offer(i * j);
			}
		}

		int result = 0;
		while (k > 0) {
			result = minHeap.poll();
			k--;
		}

		return result;
	}
}

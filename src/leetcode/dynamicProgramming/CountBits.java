package leetcode.dynamicProgramming;

/*
* 338. Counting Bits
* problem url: https://leetcode.com/problems/counting-bits/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class CountBits {
	public static void main(String[] args) {
		for (int i : countBits(512)) {
			System.out.print(i);
		}

	}

	public static int[] countBits(int num) {
		int[] res = new int[num + 1];
		int[] map = new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };

		int lastTwoPow = 0;
		int nextTwoPow = 16;
		int bitMemorization = 0;

		for (int i = 0; i <= num; i++) {

			if (nextTwoPow == i) {
				lastTwoPow = nextTwoPow;
				nextTwoPow = nextTwoPow + nextTwoPow;
				bitMemorization = 1;
				res[i] = 1;
				continue;
			}

			if (i > 16)
				res[i] = bitMemorization + res[i - lastTwoPow];
			else
				res[i] = bitMemorization + map[i - lastTwoPow];
		}

		return res;
	}
}

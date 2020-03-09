package leetcode;

/*
* 41. First Missing Positive
* problem url: https://leetcode.com/problems/first-missing-positive/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstMissingPositive(new int[] { 3, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 1 }));
		System.out.println(firstMissingPositive(new int[] {}));
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
	}

	public static int firstMissingPositive(int[] input) {
		int n = input.length;
		for (int i = 0; i < n; i++) {
			if (input[i] <= 0) {
				input[i] = n + 1;
			}
		}

		for (int i = 0; i < n; i++) {
			int current = Math.abs(input[i]);
			if (current > n)
				continue;
			if (input[current - 1] > 0)
				input[current - 1] *= -1;
		}

		for (int i = 0; i < n; i++) {
			if (input[i] > 0)
				return i + 1;
		}

		return n + 1;
	}
}

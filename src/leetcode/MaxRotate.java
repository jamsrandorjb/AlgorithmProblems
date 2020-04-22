package leetcode;

/*
* 396. Rotate Function
* problem url: https://leetcode.com/problems/rotate-function/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaxRotate {

	public static void main(String[] args) {
		int[] intArray = new int[] { 4, 3, 2, 6 };
		int[] intArray1 = new int[] { -2147483648, -2147483648 };
		System.out.println(maxRotateFunction(intArray));
		System.out.println(maxRotateFunction(intArray1));

	}

	public static int maxRotateFunction(int[] A) {
		if (A.length < 1)
			return 0;

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = 0; j < A.length; j++) {
				sum += (j + i >= A.length ? j + i - A.length : j + i) * A[j];
			}
			result = sum > result ? sum : result;
		}

		return result;
	}
}

package leetcode;

/*
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * problem url: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class SubtractProductAndSum {
	public static void main(String[] args) {
		System.out.println(subtractProductAndSum(705));
	}

	public static int subtractProductAndSum(int n) {
		int sum = 0;
		int product = 0;
		boolean firstFlag = false;
		while (n > 0) {
			int temp = n % 10;
			sum += temp;
			if (product == 0 && !firstFlag) {
				firstFlag = true;
				product = temp;
			} else {
				product = product * temp;
			}

			n = n / 10;
		}

		return product - sum;
	}
}
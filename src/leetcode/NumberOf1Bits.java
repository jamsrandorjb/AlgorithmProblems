package leetcode;

/*
* 191. Number of 1 Bits
* problem url: https://leetcode.com/problems/number-of-1-bits/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(000001));
		System.out.println(hammingWeight(00100110011));
	}

	public static int hammingWeight(int n) {
		int count = 0;

		while (n != 0) {
			count += (n & 1);
			n = n >>> 1;
		}

		return count;
	}
}

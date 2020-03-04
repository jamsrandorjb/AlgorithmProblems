package leetcode;

/*
* 190. Reverse Bits
* problem url: https://leetcode.com/problems/reverse-bits/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(00111100));
	}

	public static int reverseBits(int n) {
		int rev = 0;
		for (int i = 0; i < 32; i++) {
			int rightBit = (n & 1);
			n = n >> 1;
			rev = (rev | rightBit);

			if (i < 31)
				rev = rev << 1;
		}

		return rev;
	}

}

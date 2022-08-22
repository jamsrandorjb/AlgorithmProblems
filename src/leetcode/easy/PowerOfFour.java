package leetcode.easy;

/*
* 342. Power of Four
* problem url: https://leetcode.com/problems/power-of-four/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class PowerOfFour {
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(4));
		System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(-1));
        System.out.println(isPowerOfFour(62));
	}

	public static boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n < 4) return false;
        
        return n % 4 == 0 && isPowerOfFour(n/4);
    }
}
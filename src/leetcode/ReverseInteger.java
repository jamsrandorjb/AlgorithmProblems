package leetcode;

/*
* Reverse Integer
* problem url: https://leetcode.com/problems/reverse-integer/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(789));
	}
	
	public static int reverse(int x) {
		
		boolean checkNegative = false;
		int result = 0;
		
		//checking if the x is negative
		//if yes we have to do some calculations here and there
		if(x < 0) {
			checkNegative = true;
			x = 0 - x;
		}
		
		while(x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}
		
		if(checkNegative) result = 0 - result;
		
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
			return 0;
		}
		
        return result;
    }
}

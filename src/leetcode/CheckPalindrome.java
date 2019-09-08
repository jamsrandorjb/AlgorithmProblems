package leetcode;

/*
* Check Palindrome
* problem url: https://leetcode.com/problems/palindrome-number/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(313));
	}
	
	public static boolean isPalindrome(int x) {
		//if the input is less than zero it is always false
        if(x < 0 ) return false;
        
        int reversedNum = 0;
        int input = x;
        
        //reversing the integer
        while (x != 0) {    
            reversedNum = reversedNum * 10 + x % 10;
            x = x / 10; 
        }
        
        //if the input and reversedInteger is equal then it is Palindrome
        return reversedNum == input;
    }
}

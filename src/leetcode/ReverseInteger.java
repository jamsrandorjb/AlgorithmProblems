package leetcode;

/*
* Reverse Integer
* problem url: https://leetcode.com/problems/reverse-integer/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
* pretty ugly solution but it does the job
* gonna improve it soon
*/

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(789));
	}
	
	public static int reverse(int x) {
        boolean checkNegative = x < 0 ? true : false;
        x = x < 0 ? 0 - x : x;
        
        //declaring String s to hold the string value of input x
        String s = "" + x;
        //declaring String result to hold reversed string
        String result = "";
        
        //reversing the string
        for(int i = 0; i < s.length(); i++){
            result += s.charAt(s.length()-1-i);
        }
        
        //returning the reversed string as an Integer
        try
        {
            return checkNegative ?  0 - Integer.parseInt(result) : Integer.parseInt(result) ;
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
    }
}

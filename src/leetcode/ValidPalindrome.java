package leetcode;

import java.util.Arrays;

/*
* Check First Bad Version
* problem url: https://leetcode.com/problems/first-bad-version/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(validPalindrome("aba"));
		//System.out.println(validPalindrome("abca"));
		//System.out.println(validPalindrome("abc"));
		System.out.println(validPalindrome("eccer"));
		
	}
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */

	public static boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        if(checkPalindrome(array)) 
            return true;
        for(int i = 0; i < array.length-1; i++){
            if(checkPalindrome1(Arrays.copyOfRange(array, 0, i), Arrays.copyOfRange(array, i+1, array.length))) 
                return true;
        }
        if(checkPalindrome(Arrays.copyOfRange(array, 0, array.length-1))) 
            return true;
        return false;
    }
    
    private static boolean checkPalindrome(char[] array){
        for(int i = 0; i < array.length/2; i++){
            if(array[i] != array[array.length-i-1])
                return false;
        }    
        return true;
    }
    
    private static boolean checkPalindrome1(char[] array1, char[] array2){
    	char[] array = new char[array1.length + array2.length];
    	int i = 0;
        for(; i < array1.length; i++)
            array[i]= array1[i];
        for(int j=0; j < array2.length; j++) {
        	array[i]= array2[j];
        	i++;
        }
            
        return checkPalindrome(array);
    }
}

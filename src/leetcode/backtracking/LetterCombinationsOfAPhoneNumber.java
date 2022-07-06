package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
* 17. Letter Combinations of a Phone Number
* problem url: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		for(String s : letterCombinations("23")) {
			System.out.print(s +" ");
		}
	}

	static String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	static List<String> result;
    
    public static List<String> letterCombinations(String digits) {
        result = new LinkedList<>();
        if(digits.length() == 0)
        {
            return result;
        }
        
        dfs(0, digits, "");
        return result;
    }
    
    private static void dfs(int ind, String digits, String tempRes){
        if(ind == digits.length())
        {
            result.add(tempRes);
            return;
        }
        
        String s = arr[digits.charAt(ind)-'0'];
        for(char c : s.toCharArray()){
            dfs(ind + 1, digits, tempRes+c);
        }
    }
}

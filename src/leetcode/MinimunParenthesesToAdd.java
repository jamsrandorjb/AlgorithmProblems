package leetcode;

import java.util.Stack;

/*
* Minimum Add to Make Parentheses Valid
* problem url: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class MinimunParenthesesToAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minAddToMakeValid("()))))(((("));
	}
	
	public static int minAddToMakeValid(String S) {
        Stack<Character> charStack = new Stack<Character>();
        
        for(char c : S.toCharArray()){
            if(c == '(') {
                charStack.push(c);
                continue;
            }
            if(!charStack.isEmpty() && charStack.peek() == '('){
              charStack.pop(); 
              continue;
            }
            
            charStack.push(c);
        }
        
        return charStack.size();
    }  
}

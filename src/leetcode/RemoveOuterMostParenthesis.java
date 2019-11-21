package leetcode;

/*
* 1021. Remove Outermost Parentheses
* problem url: https://leetcode.com/problems/remove-outermost-parentheses/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RemoveOuterMostParenthesis {

	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())"));
	}
		
	public static String removeOuterParentheses(String S) {
		int counter = 0;
		StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray()){
            if(c == '('){
                if(counter != 0) sb.append(c);
                counter++;
            }
            else{
                counter--;
                if(counter != 0) sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

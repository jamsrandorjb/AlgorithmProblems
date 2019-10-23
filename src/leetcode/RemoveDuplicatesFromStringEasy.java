package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/*
* Two Sum
* problem url: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RemoveDuplicatesFromStringEasy {

	public static void main(String[] args) {
		
			System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy"));
		
	}
		
	public static String removeDuplicates(String S) {
        Stack<Character> charStack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray()){
            if(!charStack.isEmpty() && charStack.peek() == c){
                charStack.pop();
                continue;
            }
            charStack.push(c);
        }
               
        for(char c : charStack){  
            sb.append(c);  
        }
               
        return sb.toString();
    }
}

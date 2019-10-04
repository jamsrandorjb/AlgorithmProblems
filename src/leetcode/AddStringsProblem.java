package leetcode;

import java.util.Iterator;
import java.util.Stack;

/*
* Add Two Linked Lists numbers
* problem url: https://leetcode.com/problems/add-two-numbers/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AddStringsProblem {

	public static void main(String[] args) {
	    System.out.println(addStrings("98", "9"));
	}

	public static String addStrings(String num1, String num2) {
        Stack<Integer> intStack1 = new Stack<Integer>();
        Stack<Integer> intStack2 = new Stack<Integer>();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        
        for(int i = 0; i < chars1.length; i++){
            intStack1.push(Character.getNumericValue(chars1[chars1.length - 1 -i]));
        }
        for(int i = 0; i < chars2.length; i++){
            intStack2.push(Character.getNumericValue(chars2[chars2.length - 1 -i]));
        }
        
        Iterator<Integer> it1 = intStack1.iterator();
        Iterator<Integer> it2 = intStack2.iterator();
        int extra = 0;
        StringBuilder sb = new StringBuilder();
        while(it1.hasNext() && it2.hasNext()){
            int x1 = it1.next();
            int x2 = it2.next();
            int sum = (x1 + x2 + extra) % 10;
            extra = (x1 + x2 + extra) / 10;
            sb.append(sum);
        }
        while(it1.hasNext()){
            int x1 = it1.next();
            int sum = (x1 + extra) % 10;
            extra = (x1 + extra) / 10;
            sb.append(sum);
        }
        while(it2.hasNext()){
            int x2 = it2.next();
            int sum = (x2 + extra) % 10;
            extra = (x2 + extra) / 10;
            sb.append(sum);
        }
        if(extra > 0){
            sb.append(extra);
        }
        sb.reverse();
        
        return sb.toString();
    }
}

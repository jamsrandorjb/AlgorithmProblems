package leetcode;

import java.util.Set;
import java.util.HashSet;

/*
* Given a list of n strings. Each string has length k. 
* Return true if there're 2 strings that only differ by 1 character, 
* otherwise false. You can assume that all strings contain only lowercase English letters [a-z].
* 
* problem url: https://leetcode.com/discuss/interview-question/382955/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FindOnlyOneDifferedCharFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkSimilar(new String[] {"abc","xyz","asd"}));
	}
	
	public static boolean checkSimilar(String[] words) {
        Set<String> wordOptions = new HashSet<String>();
        
        for(int i = 0; i < words.length; i++){
        	for(int j = 0; j < words[i].length(); j++) {
        		String temp = ""; 
        		temp += words[i].substring(0, j);
        		temp += words[i].substring(j+1, words[i].length());
        		
        		if(wordOptions.contains(temp)) return true;
        		
        		wordOptions.add(temp);
        	}
        }
        
        return false;
    }
}

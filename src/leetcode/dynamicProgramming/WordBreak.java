package leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
* 139. Word Break
* problem url: https://leetcode.com/problems/word-break/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class WordBreak {
	public static void main(String[] args) {
		
		System.out.println(wordBreak("leetcode",new ArrayList<String>(Arrays.asList(new String[] {"leet","code"})) ));
		System.out.println(wordBreak("applepenapple",new ArrayList<String>(Arrays.asList(new String[] {"apple","pen"})) ));
		System.out.println(wordBreak("catsandog",new ArrayList<String>(Arrays.asList(new String[] {"cats","dog", "sand", "and", "cat"})) ));
		System.out.println(wordBreak("aaaaaaa",new ArrayList<String>(Arrays.asList(new String[] {"aaaa","aaa"}))));
		
		
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		   int maxLength = 0;
		   HashSet<String> hSet = new HashSet<>();
		   boolean[] storage = new boolean[s.length()+1];
		   storage[0] = true;
		   
		   
		   for(String tempString : wordDict) {
			   maxLength = maxLength < tempString.length() ? tempString.length() : maxLength;
			   hSet.add(tempString);
		   }
		   
		   for(int i = 1; i <= s.length(); i++){
		        for(int j = 1; j <= maxLength && j <= i; j++){
		            if(storage[i-j] && hSet.contains(s.substring(i-j,i))){
		                storage[i] = true;
		                break;
		            }
		        }
		    }
		   
		   return storage[s.length()];
	}
}



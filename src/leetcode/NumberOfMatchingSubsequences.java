package leetcode;

/*
* Is Subsequence
* problem url: https://leetcode.com/problems/is-subsequence/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class NumberOfMatchingSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
	}
	
	public static int numMatchingSubseq(String t, String[] words) {
		int result = 0;
        
		for(String s : words){
            int matchedCount=0; 
            int pointerT=0;
            while(matchedCount < s.length() && pointerT < t.length()){
                if(s.charAt(matchedCount) != t.charAt(pointerT)){
                    pointerT++;
                    continue;
                }
                matchedCount++;
                pointerT++;
            }

            if(matchedCount == s.length()) result++;       
        }
        
        return result;
    }
}

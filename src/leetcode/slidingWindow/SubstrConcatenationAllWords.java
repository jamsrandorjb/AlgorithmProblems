package leetcode.slidingWindow;

/*
* 30. Substring with Concatenation of All Words
* problem url: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class SubstrConcatenationAllWords {
	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", {"foo","bar"}));
	}

	HashMap<String, Integer> wordCount = new HashMap<>();
    int wordLen;
    int totalLen;
    int k;

    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        k = words.length;
        wordLen = words[0].length();
        totalLen = k * wordLen;
        
        for(String w: words){
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < n - totalLen + 1; i++){
            if(check(i, s))
            {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private static boolean check(int i, String s){
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsFound = 0;
        for(int j = i; j < i + totalLen; j += wordLen){
            String sub = s.substring(j, j + wordLen);
            if(remaining.getOrDefault(sub, 0) != 0)
            {
                remaining.put(sub, remaining.getOrDefault(sub, 0) -1);
                wordsFound++;
            }
            else
            {
                break;
            }
        }
        
        return wordsFound == k;
    }
}
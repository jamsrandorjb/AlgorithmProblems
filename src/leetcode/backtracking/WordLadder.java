package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* 126. Word Ladder II
* problem url: https://leetcode.com/problems/word-ladder-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<>();
		arr.add("hot");
		arr.add("dot");
		arr.add("dog");
		arr.add("lot");
		arr.add("log");
		arr.add("cog");
		System.out.println(ladderLength("hit", "cog", arr));
	}
    
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hSet = new HashSet<>();
        for(String s : wordList) hSet.add(s);
        
        if(!hSet.contains(endWord)) return 0;
        
        int[] minPath = new int[1];
        minPath[0] = Integer.MAX_VALUE;
        dfs(beginWord, endWord, hSet, new ArrayList<String>(), minPath);
        
        return minPath[0] == Integer.MAX_VALUE ? 0 : minPath[0];  
    }
    
    private static void dfs(String beginWord, String endWord, HashSet<String> wordSet, List<String> tempResult, int[] minPath){
        tempResult.add(beginWord);
        if(beginWord.equals(endWord)) {
            minPath[0] = minPath[0] > tempResult.size() ? tempResult.size() : minPath[0];
        }
        else{
        	char[] arr = beginWord.toCharArray();
        	for(int i = 0; i < arr.length; i++){
            	char c1 = arr[i];
                for(char c = 'a'; c <= 'z'; ++c){
                    if(beginWord.charAt(i) == c) continue;
                    arr[i] = c;
                    String mutatedWord = new String(arr);
                    if(wordSet.contains(mutatedWord) && !tempResult.contains(mutatedWord)){
                        dfs(mutatedWord, endWord, wordSet, tempResult, minPath);
                    }
                    arr[i] = c1;
                }
            }    
        }
        tempResult.remove(beginWord);
    }
}

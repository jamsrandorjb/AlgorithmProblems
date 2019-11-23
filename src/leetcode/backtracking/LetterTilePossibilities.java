package leetcode.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
* 1079. Letter Tile Possibilities
* problem url: https://leetcode.com/problems/letter-tile-possibilities/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class LetterTilePossibilities {
	public static void main(String[] args) {
		System.out.println(numTilePossibilities("AAB"));
		
	}
	
	public static int numTilePossibilities(String tiles) {
        HashSet<String> results = new HashSet<>();
        StringBuilder tempResult = new StringBuilder();
        HashMap<Character, Integer> hMap = new HashMap<>();
        for(char c : tiles.toCharArray()) hMap.put(c, hMap.getOrDefault(c, 0)+1);
        dfs(tiles, 0, results, tempResult, hMap);        
        return results.size();
    }
    
    private static void dfs(String tiles, int startPoint, HashSet<String> results, StringBuilder tempResult, HashMap<Character, Integer> checker){
        if(startPoint >= tiles.length()) return;  
        
        for(int j = 0; j < tiles.length(); j++){
            tempResult.append(tiles.charAt(j));
            if(validate(results, tempResult.toString(), checker)){
                results.add(tempResult.toString());
                dfs(tiles, startPoint+1, results, tempResult, checker);
            }
            tempResult.deleteCharAt(tempResult.length()-1);
        }
    }
    
    private static boolean validate(HashSet<String> results, String input, HashMap<Character, Integer> checker){
    	if(results.contains(input)) return false;
    	HashMap<Character, Integer> hMap = new HashMap<>();
        for(char c : input.toCharArray()) hMap.put(c, hMap.getOrDefault(c, 0)+1);
        for(Map.Entry<Character, Integer> entry : hMap.entrySet()){
        	if(checker.get(entry.getKey()) < entry.getValue()) return false;
        }
        
        return true;
    }
}



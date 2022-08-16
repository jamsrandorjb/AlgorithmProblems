package leetcode.easy;

import java.util.HashMap;

/*
* 387. First Unique Character in a String
* problem url: https://leetcode.com/problems/first-unique-character-in-a-string/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class FistUniqueCharacter {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("a"));
		System.out.println(firstUniqChar("aba"));
	}

	 public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
}
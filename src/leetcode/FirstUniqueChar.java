package leetcode;

import java.util.HashMap;

/*
* 387. First Unique Character in a String
* problem url: https://leetcode.com/problems/first-unique-character-in-a-string/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FirstUniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("leetcodeBro"));
	}
	
	 public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hMap = new HashMap<>();
        char[] arr = s.toCharArray();
        
        for(char c : arr) hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        for(int i = 0; i < arr.length; i++){
          if(hMap.get(arr[i]) == 1) return i;
        } 
        
        return -1;
    }
}

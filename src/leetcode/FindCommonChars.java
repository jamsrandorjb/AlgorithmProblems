package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 1002. Find Common Characters
* problem url: https://leetcode.com/problems/find-common-characters/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FindCommonChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(commonChars(new String[] {"bella", "label", "roller"}));
	}
	
	public static List<String> commonChars(String[] A) {
		List<String> result = new ArrayList<>();    
        HashMap<Character, Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < A[0].length(); i++){
            for(int j = 0; j < A.length; j++){
                hMap.put(A[j].charAt(i), hMap.getOrDefault(A[j].charAt(i), 0) +j);
            }   
        }
        
        for(Map.Entry<Character, Integer> m : hMap.entrySet()){
            for(int i = 0; i < m.getValue() / A.length; i++){
                result.add(""+m.getKey());
            }
        }
        
        return result;
    }
}

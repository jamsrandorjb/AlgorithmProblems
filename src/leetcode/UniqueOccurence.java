package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
* Unique Number of Occurences
* problem url: https://leetcode.com/problems/unique-number-of-occurrences/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class UniqueOccurence {

	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] {1, 2, 2, 1, 1, 3}));
	}
		
	public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        HashSet<Integer> hSet = new HashSet<Integer>();
        
        for(int i = 0; i < arr.length; i++){
            if(hMap.containsKey(arr[i])){
                hMap.put(arr[i], (Integer)hMap.get(arr[i]) + 1);
                continue;
            }
            hMap.put(arr[i], 1);    
        }
        
        for(int x : hMap.values()){
            if(hSet.contains(x)) return false;   
            hSet.add(x);  
        }
            
        return true;
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* 169. Majority Element
* problem url: https://leetcode.com/problems/majority-element/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(majorityElement(new int[] {1, 1, 1, 2, 2, 2, 2, 2, 3}));
	}
	
	public static int majorityElement(int[] nums) {
        Map.Entry<Integer, Integer> majorityEntry = null;
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();   
        
        for(int i : nums) hMap.put(i, hMap.getOrDefault(i, 0) + 1);
        
        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()){
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
               majorityEntry = entry; 
            }
        }
        
        return majorityEntry.getKey();    
    }
}

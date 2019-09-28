package leetcode;

import java.util.HashMap;

/*
* Two Sum
* problem url: https://leetcode.com/problems/two-sum/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int x : twoSum(new int[] {3, 2, 4}, 6)) {
			System.out.println(x);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] returnList = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for(int i=0; i < nums.length; i++)
            hmap.put(nums[i], i);
        
        
        for(int i=0; i < nums.length; i++){
            if(hmap.containsKey(target - nums[i])){
               int index = (int)hmap.get(target - nums[i]);
               if(index == i) continue;
               returnList[0]= i;
               returnList[1]= index;
               return returnList; 
            }
        }
        
        return returnList;         
    }
}

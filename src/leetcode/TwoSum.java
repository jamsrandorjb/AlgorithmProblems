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
		for(int x : twoSumFast(new int[] {3, 2, 4}, 6)) {
			System.out.println(x);
		}
	}
	
	public static int[] twoSumFast(int[] nums, int target) {
		int[] result = new int[2];
        if(nums == null || nums.length < 2)
            return result;
        
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        
        for(int i = 0; i < nums.length; i++){
            int targetInt = target - nums[i];
            if(map.containsKey(targetInt) && map.get(targetInt) != i){
                result[0] = i;
                result[1] = map.get(targetInt);
                return result;
            }
            map.put(nums[i], i);
        }
        
        return result;         
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

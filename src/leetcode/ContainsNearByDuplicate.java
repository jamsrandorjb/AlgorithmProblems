package leetcode;
import java.util.HashMap;
import java.util.Map;

/*
 * Contains near by Duplicate
 * problem url: https://leetcode.com/problems/contains-duplicate-ii/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class ContainsNearByDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsNearbyDuplicate(new int[] {99,99}, 2));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) 
            	return true;
            
            map.put(nums[i], i);
        }
        
        return false;
    }

}

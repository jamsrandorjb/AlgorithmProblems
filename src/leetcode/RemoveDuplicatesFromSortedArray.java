package leetcode;
import java.util.LinkedHashMap;

/**
* Remove Duplicates From Sorted Array
* problem url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//time complexity O(n)
	public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer, Integer> hashtable = new LinkedHashMap<Integer, Integer>();
        int j=0;
        for(int i =0; i< nums.length; i++){
            if(hashtable.get(nums[i]) != null) continue;    
            hashtable.put(nums[i],nums[i]);    
        }
        for(Integer i : hashtable.values()){
            nums[j] = i;
            j++;
        }
        return j;
    }
}
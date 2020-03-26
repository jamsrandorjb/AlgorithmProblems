package leetcode.dynamicProgramming;

import java.util.HashMap;

/*
* 416. Partition Equal Subset Sum
* problem url: https://leetcode.com/problems/partition-equal-subset-sum/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 233, 7 }));
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
	}

	public static boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums) total += i;
        if(total % 2 != 0) return false;
        
        return canPartitionRec(nums, 0, 0, total, new HashMap<String, Boolean>());
    }
    
    private static boolean canPartitionRec(int[] nums, int index, int sum, int total, HashMap<String, Boolean> state){
        String current = index + "" + sum;
        //if we already calculated it before don't have to do it again
        if(state.containsKey(current)) return state.get(current);
        //bingo we found our guy
        if(sum * 2 == total) return true;
        if(sum > total /2 || index >= nums.length) return false;
        //not taking || taking for the partition
        Boolean result = canPartitionRec(nums, index+1, sum, total, state) || canPartitionRec(nums, index+1, sum + nums[index], total, state);
        //this is how we save it in our DP
        state.put(current, result);
        
        return result;
    }
}

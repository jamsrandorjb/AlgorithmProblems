package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
* 47. Permutations II
* problem url: https://leetcode.com/problems/permutations-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[] {1,2,1}));
	}
	
	       
	public static List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		
		permuteBacktrack(nums, result, new ArrayList<Integer>(), new HashSet<Integer>());
		
        return result;
    }
	
	private static void permuteBacktrack(int[] nums, List<List<Integer>> result, List<Integer> permutation, HashSet<Integer> usedIndexes) {
		if(nums.length == permutation.size()) {
			result.add(new ArrayList<>(permutation));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(usedIndexes.contains(i)) continue;
			if(i > 0 && nums[i] == nums[i-1] && usedIndexes.contains(i-1)) continue;
			
			usedIndexes.add(i);
			permutation.add(nums[i]);
			permuteBacktrack(nums, result, permutation, usedIndexes);
			usedIndexes.remove(i);
			permutation.remove(permutation.size()-1);
		}
	}
	
}

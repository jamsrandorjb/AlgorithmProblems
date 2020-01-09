package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 46. Permutations
* problem url: https://leetcode.com/problems/permutations/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[] {1,2,3}));
	}
	
	       
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permuteBacktrack(nums, result, new ArrayList<Integer>());
		
        return result;
    }
	
	private static void permuteBacktrack(int[] nums, List<List<Integer>> result, List<Integer> permutations) {
		if(nums.length == permutations.size()) {
			result.add(new ArrayList<>(permutations));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(permutations.contains(nums[i])) continue;
			
			permutations.add(nums[i]);
			permuteBacktrack(nums, result, permutations);
			permutations.remove(permutations.size()-1);
		}
	}
}

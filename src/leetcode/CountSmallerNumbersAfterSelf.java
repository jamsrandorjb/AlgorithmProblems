package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
* 315. Count of Smaller Numbers After Self
* problem url: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CountSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSmaller(new int[] {5,2,6,1}));
	}

	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new LinkedList<>();
		
		for(int i = 0; i < nums.length; i++) {
			int cnt = 0;
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] > nums[j]) cnt++;
			}
			
			result.add(cnt);
		}
		
		return result;
	}
}

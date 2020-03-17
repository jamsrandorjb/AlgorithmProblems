package leetcode.greedy;

/*
 * 55. Jump Game
 * problem url: https://leetcode.com/problems/jump-game/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public static boolean canJump(int[] nums) {
		int lastLandedIndex = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastLandedIndex)
				lastLandedIndex = i;
		}

		return lastLandedIndex == 0;
	}
}

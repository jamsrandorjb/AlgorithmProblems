package leetcode.dynamicProgramming;
/*
* 139. Word Break
* problem url: https://leetcode.com/problems/word-break/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class PredictTheWinnerProblem {
	public static void main(String[] args) {

		// System.out.println(PredictTheWinner(new int[] {1,5,2}));
		System.out.println(PredictTheWinner(new int[] { 1, 5, 233, 7 }));
		// System.out.println(PredictTheWinner(new int[] {1,1,1,1}));
		// System.out.println(PredictTheWinner(new int[] {1}));

	}

	public static boolean PredictTheWinner(int[] nums) {
		int score1 = 0;
		int sum = 0;
		boolean isFirstPlayer = true;
		int lastChosenIndexStart = -1;
		int lastChosenIndexEnd = nums.length;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (lastChosenIndexStart > lastChosenIndexEnd)
				break;

			if (isFirstPlayer) {
				isFirstPlayer = false;
				if (nums[lastChosenIndexStart + 1] > nums[lastChosenIndexEnd - 1]) {
					score1 += nums[lastChosenIndexStart + 1];
					lastChosenIndexStart++;
					continue;
				}
				score1 += nums[lastChosenIndexEnd - 1];
				lastChosenIndexEnd--;
				continue;
			}

			isFirstPlayer = true;
			if (nums[lastChosenIndexStart + 1] > nums[lastChosenIndexEnd - 1]) {
				lastChosenIndexStart++;
				continue;
			}
			lastChosenIndexEnd--;
		}

		return score1 + score1 >= sum;
	}
}

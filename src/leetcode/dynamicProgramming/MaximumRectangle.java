package leetcode.dynamicProgramming;

import java.util.Stack;

/*
 * 85. Maximal Rectangle
 * problem url: https://leetcode.com/problems/maximal-rectangle/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class MaximumRectangle {
	public static void main(String[] args) {
		System.out.println(maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
	}

	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int[] dp = new int[matrix[0].length];
		int result = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == '0') {
					dp[col] = 0;
				} else {
					dp[col] += 1;
				}
			}
			// do the histogram
			result = Math.max(largestRectangleArea(dp, dp.length), result);
		}

		return result;
	}

	private static int largestRectangleArea(int[] heights, int n) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				int area = heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = maxArea > area ? maxArea : area;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int area = heights[stack.pop()] * (stack.isEmpty() ? n : n - stack.peek() - 1);
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}
}

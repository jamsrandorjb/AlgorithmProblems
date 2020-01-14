package leetcode;

import java.util.Stack;

/*
* 42. Trapping Rain Water
* problem url: https://leetcode.com/problems/trapping-rain-water/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	public static int trap(int[] height) {
		if (height.length == 0)
			return 0;

		int trappedRain = 0;
		Stack<Integer> stack = new Stack<>();
		int previousMaxHeight = height[0];

		for (int i = 1; i < height.length; i++) {
			if (height[i] < previousMaxHeight) {
				stack.push(height[i]);
				continue;
			}
			while (!stack.isEmpty()) {
				trappedRain += previousMaxHeight - stack.pop();
			}
			previousMaxHeight = height[i];
		}
		
		//checking the leftovers in the stack
		if (!stack.isEmpty()) {
			int rightMax = stack.pop();
			while (!stack.isEmpty()) {
				int curr = stack.pop();
				trappedRain += Math.max(0, rightMax - curr);
				rightMax = Math.max(rightMax, curr);
			}
		}

		return trappedRain;
	}
}

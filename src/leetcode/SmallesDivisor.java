package leetcode;

/*
 * 1283. Find the Smallest Divisor Given a Threshold
 * problem url: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class SmallesDivisor {
	public static void main(String[] args) {
		System.out.println(smallestDivisor(new int[] { 2, 3, 5, 7, 11 }, 11));
	}

	public static int smallestDivisor(int[] nums, int threshold) {

		long sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += (long) nums[i];

		long start = 1;
		long end = sum;

		long ans = Long.MAX_VALUE;

		while (start <= end) {
			long mid = (start) + (end - start) / 2;
			long c = check(nums, mid);
			if (c > (long) threshold)
				start = mid + 1;
			else {
				ans = Math.min(mid, ans);
				end = mid - 1;
			}
		}

		return (int) ans;

	}

	private static long check(int[] nums, long mid) {

		long ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % mid == 0) {
				ans += (long) (nums[i] / mid);
				continue;
			} else {
				ans += (long) (nums[i] / mid + 1);
			}
		}

		return (int) ans;

	}
}
package leetcode;

/*
* 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
* problem url: 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaxSideLength {

	public static void main(String[] args) {

		System.out.println(maxSideLength(
				new int[][] { { 18, 70 }, { 61, 1 }, { 25, 85 }, { 14, 40 }, { 11, 96 }, { 97, 96 }, { 63, 45 } },
				40184));

	}

	static int m, n;

	public static int maxSideLength(int[][] mat, int threshold) {
		m = mat.length;
		n = mat[0].length;
		int[][] sum = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
			}
		}

		int lo = 0;
		int hi = Math.min(m, n);

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (isSquareExist(sum, threshold, mid)) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return hi;

	}

	private static boolean isSquareExist(int[][] sum, int threshold, int len) {
		for (int i = len; i <= m; i++) {
			for (int j = len; j <= n; j++) {
				if (sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold)
					return true;
			}
		}
		return false;
	}
}

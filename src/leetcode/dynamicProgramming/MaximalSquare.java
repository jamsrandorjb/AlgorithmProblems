package leetcode.dynamicProgramming;

/*
 * 221. Maximal Square 
 * problem url: https://leetcode.com/problems/maximal-square/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class MaximalSquare {
	public static void main(String[] args) {

		System.out.println(maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));

	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int maxSquare = 0;
		int[][] memorize = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (i == 0 || j == 0) {
					memorize[i][j] = matrix[i][j] - '0';

					if (maxSquare == 0)
						maxSquare = maxSquare > memorize[i][j] ? maxSquare : memorize[i][j];

					continue;
				}

				if (matrix[i][j] == '0') {
					memorize[i][j] = 0;
					continue;
				}

				int checkNeighbors = memorize[i - 1][j] > memorize[i - 1][j - 1] ? memorize[i - 1][j - 1]
						: memorize[i - 1][j];
				checkNeighbors = checkNeighbors > memorize[i][j - 1] ? memorize[i][j - 1] : checkNeighbors;
				memorize[i][j] = 1 + checkNeighbors;
				maxSquare = maxSquare > memorize[i][j] ? maxSquare : memorize[i][j];
			}
		}

		return maxSquare * maxSquare;
	}
}

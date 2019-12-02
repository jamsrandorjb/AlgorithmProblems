package leetcode;

/*
* 566. Reshape the Matrix
* problem url: https://leetcode.com/problems/reshape-the-matrix/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReshapeTheMatrix {
    
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if(n * m != r * c) return nums;
        
        int new_i = 0;
        int new_j = 0; 
        int[][] result = new int[r][c];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[new_i][new_j++] = nums[i][j];
                if(new_j != c) continue;
                new_j = 0;
                new_i++;
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int[] i : matrixReshape(new int[][] {{1, 2}, {3,4}}, 1, 4))
			for(int j : i) System.out.print(" " + j);
			
	}
}
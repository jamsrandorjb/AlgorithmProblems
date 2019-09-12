package leetcode;

/*
 * Flipping an Image
 * problem url: https://leetcode.com/problems/flipping-an-image/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class FlipAnImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] result = flipAndInvertImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}});
		
		for(int[] row: result){
            for(int j = 0; j < row.length; j++){
            	System.out.print(row[j]);
            }
            System.out.println();
        }
	}
	
	public static int[][] flipAndInvertImage(int[][] A) {
		
		//storing the mid point and length of the inner array
		int len = A[0].length;
        int mid = len/2;
		
		//we have to go through outer array
        for(int[] row: A){
            
            //reversing each row
            for(int j = 0; j < mid; j++){
            	int temp = row[j];
                row[j] = row[len-j-1];
                row[len-j-1] = temp;
            }
            
            //inverting the each row
            for(int j = 0; j < len; j++){
                row[j] =  row[j] == 1 ? 0 : 1;
            }
        }
        
        //returning the result
        return A;
    }
}

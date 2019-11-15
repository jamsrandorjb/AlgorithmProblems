package leetcode;

/*
* 1232. Check If It Is a Straight Line
* problem url: https://leetcode.com/problems/check-if-it-is-a-straight-line/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CheckStraightLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkStraightLine(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
	}
	
	public static boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        double tanA = Math.abs(((double) (second[0] - first[0])) / ((double) (second[1] - first[1])));
        
        for(int i = 2; i < coordinates.length; i++){
            second = coordinates[i];
            first = coordinates[i-1];
            
            double tanB = Math.abs(((double) (second[0] - first[0])) / ((double) (second[1] - first[1])));
            
            if(tanA != tanB) return false;
        }
        
        return true;
    }
}

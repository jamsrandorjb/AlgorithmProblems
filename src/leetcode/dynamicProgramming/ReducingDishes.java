package leetcode.dynamicProgramming;

/*
 * 1402. Reducing Dishes
 * problem url: https://leetcode.com/problems/reducing-dishes/description/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class ReducingDishes {
	public static void main(String[] args) {
		System.out.println(maxSatisfaction(new int[] {-1,-8,0,5,-9}));
	}

	public static int maxSatisfaction(int[] satisfaction) {
		Arrays.sort(satisfaction);
		int n = satisfaction.length;
		int result = 0;
		int last = 0;//sum of all the digits
		int sum = 0;//total sum, including current digit
		for(int i = n - 1; i >= 0; i--){
			last += satisfaction[i];
			sum += last;
			result = Math.max(result, sum);
		}
		
		return result;
    }
}

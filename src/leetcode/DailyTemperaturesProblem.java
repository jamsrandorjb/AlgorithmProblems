package leetcode;

import java.util.Stack;

/*
* 739. Daily Temperatures
* problem url: https://leetcode.com/problems/daily-temperatures/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class DailyTemperaturesProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i : dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})) {
			System.out.print(" "+i);
		}
		System.out.println();
		for(int i : dailyTemperaturesBruteForce(new int[] {73, 74, 75, 71, 69, 72, 76, 73})) {
			System.out.print(" "+i);
		}
	}
	
	public static int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
        Stack<Integer> holder = new Stack();
        
        for(int i = T.length -1; i >= 0; i--){
            while(!holder.isEmpty() && T[i] >= T[holder.peek()]) holder.pop();
            result[i] = holder.isEmpty() ? 0 : holder.peek() - i;
            holder.push(i);
        }
        
        return result;
    }
	
	public static int[] dailyTemperaturesBruteForce(int[] T) {
        int[] result = new int[T.length];
        
        for(int i = 0; i < T.length; i++){
            for(int j = i + 1; j < T.length; j++){
                if(T[j] > T[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        
        return result;
    }
}

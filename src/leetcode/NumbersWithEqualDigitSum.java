package leetcode;

import java.util.HashMap;

/*
* Numbers With Equal Digit Sum
* problem url: https://leetcode.com/discuss/interview-question/365872/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class NumbersWithEqualDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {51, 71, 17, 42}));

		System.out.println(solution(new int[] {42, 33, 60}));
	}
	
	public static int solution(int[] arr) {
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        int maxSum = -1;
        for(int i : arr) {
        	int digitSum = 0;
        	int number = i;
        	while(i != 0) {
        		digitSum += i % 10;
        		i = i/10;
        	}
        	if(hMap.containsKey(digitSum)) {
        		maxSum = Math.max(maxSum, (int)hMap.get(digitSum) + number);
                hMap.put(digitSum, Math.max(number, hMap.get(digitSum)));
        		continue;
        	}
        	hMap.put(digitSum, number);
        }    
        return maxSum;
    }
}

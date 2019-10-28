package leetcode;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
* Best Time to Buy and Sell Stock - 3
* problem url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BestTimeToBuyAndSellStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	public static int maxProfit(int[] prices) {
		int n = prices.length;
        if(n<2) return 0;
        
        int[] profit = new int[n];
        
        int min = prices[0];
        int maxProfit = 0;
        
        for(int i=1; i<n; i++){
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
            profit[i] = maxProfit;
        }
        
        int max = prices[n-1];
        maxProfit = profit[n-1];
        for(int i= n-2; i >= 0; i--){
            maxProfit = Math.max(maxProfit, max - prices[i] + profit[i]);
            max = Math.max(max,prices[i]);
        }
        
        return maxProfit;    
    }
}

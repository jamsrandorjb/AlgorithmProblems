package leetcode;

/*
* Best Time to Buy and Sell Stock - 2
* problem url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BestTimeToBuyAndSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	public static int maxProfit(int[] prices) {
        int netProfit = 0;
        int minValue = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
        	//if the existing minValue is bigger than i th element of the array, we have to update the minValue
            if(minValue >= prices[i]){
                minValue = prices[i]; 
                continue;
            }
            //if the i th element is bigger than minValue we can calculate the profit
            int profit = prices[i] - minValue;
            //calculating the netProfit
            netProfit += profit; 
            //setting the minValue again
            minValue = prices[i];
        }
        
        //returning the netProfit
        return netProfit;
    }
}


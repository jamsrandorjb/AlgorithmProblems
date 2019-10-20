package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* 134. Gas Station
* problem url: https://leetcode.com/problems/gas-station/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
	}
	
	       
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
        int remainingGas = 0;
        int startRemaining = 0;
        int startIndex = -1;
        
        
        for(int i = 0; i < gas.length; i++){
            int gap = gas[i] - cost[i];
            remainingGas += gap;
            startRemaining += gap;
            if (gap >= 0 && startIndex == -1) {
                startIndex = i;
                startRemaining = gap;
            }
            else if (startIndex >= 0 && gap < 0 && startRemaining < 0){
                startIndex = -1;
            }
        }
        
        return remainingGas < 0 ? -1 : startIndex;
    }    
}

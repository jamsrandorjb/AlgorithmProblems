package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* 728. Self Dividing Numbers
* problem url: https://leetcode.com/problems/self-dividing-numbers/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SelfDividingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(selfDividingNumbers(1, 22));
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
List<Integer> result = new ArrayList<>();
        
        for(; left <= right; left++){
            
            int dividingLeft = left;
            boolean isSelfDividing = true;
            
            while(dividingLeft != 0){
                int remainder = dividingLeft % 10;
                
                if(remainder == 0 || left % remainder != 0)
                    isSelfDividing = false;
                
                dividingLeft = dividingLeft/10;
            }
            
            if(isSelfDividing) result.add(left);
        }
        
        return result;
    }
}

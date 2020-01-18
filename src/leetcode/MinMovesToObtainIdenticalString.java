package leetcode;

/*
* Min Moves to Obtain String Without 3 Identical Consecutive Letters
* problem url: https://leetcode.com/discuss/interview-question/398026/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class MinMovesToObtainIdenticalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("baaaaa"));

		System.out.println(solution("baaabbaabbba"));
		
		System.out.println(solution("baabab"));
	}
	
	public static int solution(String input) {
		int maxMove = 0;
		char lastChar = 'c';
		int charCounter = 0;
        for(char c : input.toCharArray()) {
        	if(lastChar != c) {
        		lastChar = c;
            	charCounter = 1;
            	continue;
        	}
        	if(charCounter == 2) {
    			maxMove++;
    			charCounter = 0;
    			continue;
    		}
    		charCounter++;
        }    
        
        return maxMove;
    }
}

package leetcode;

/**
* Roman to Integer
* problem url: https://leetcode.com/problems/roman-to-integer/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/

public class RomanToInteger {
	public static void main(String[] args) {
		String roman = "LVIII";
		System.out.println(romanToInt(roman));
	}
	/**
	 * @param s-string roman
	 * @return integer value
	 */
	public static int romanToInt(String s) {
        int return_val = 0;
        
        for(int i=0; i< s.length()-1; i++)
        {
        	//if the next roman value is less iterating value then we have sum it
        	//otherwise we have deduct it IX, IV etc
            if(getIntVal(s.charAt(i)) >= getIntVal(s.charAt(i+1)))
               return_val += getIntVal(s.charAt(i));
            else
               return_val -= getIntVal(s.charAt(i));
        }
        //calculating the last roman
        return_val += getIntVal(s.charAt(s.length()-1));
        return return_val;
    }
    
	/**
	 * @param c-char
	 * @return integer value
	 */
    private static int getIntVal(char c){
        int return_val = 0;
        switch(c){
            case 'I':
                return_val = 1;
                break;
            case 'V':
                return_val = 5;
                break;
            case 'X':
                return_val = 10;
                break;
            case 'L':
                return_val = 50;
                break;
            case 'C':
                return_val = 100;
                break;
            case 'D':
                return_val = 500;
                break;
            case 'M':
                return_val = 1000;
                break;
            default: 
                return_val = 0;
                break;
        }   
        return return_val;
    }
}

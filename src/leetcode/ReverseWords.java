package leetcode;

/*
* String reverse example
* problem url: https://leetcode.com/problems/reverse-words-in-a-string/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("string reverse example"));
	}
	public static String reverseWords(String s) {
		String[] arr = s.split(" ");
		String result = "";
		int length = arr.length;
        
		for( int i = 0; i < length; i++) {
            if(arr[length-1-i].trim().length() > 0){
                result = result + " " + arr[length-1-i];   
            }
		}
        
		return result.trim();
	}
}

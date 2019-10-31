package leetcode;

import java.util.HashSet;

/*
* 804. Unique Morse Code Words
* problem url: https://leetcode.com/problems/unique-morse-code-words/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class DecodeMorse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniqueMorseRepresentations(new String[] {"gin", "zen"}));
	}
	
	static String[] morseDecode = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
			"....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
			".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	
	public static int uniqueMorseRepresentations(String[] words) {
        HashSet<String> decodedMorse = new HashSet<String>();
        StringBuilder sb;
        
        for(String s : words){
            sb = new StringBuilder();
            for(char c : s.toCharArray()){
               sb.append(morseDecode[c-'a']);
            }
            if(!decodedMorse.contains(sb.toString())){
                decodedMorse.add(sb.toString());
            }
        }
        
        return decodedMorse.size();
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
* 49. Group Anagrams
* problem url: https://leetcode.com/problems/group-anagrams/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagramsSlow(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> hMap = new HashMap<>();
		
		for(String s : strs) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			String sorted = new String(charArray);
			
			List<String> anagrams = hMap.getOrDefault(sorted, new ArrayList<String>());
			anagrams.add(s);
			hMap.put(sorted, anagrams);
		}
		
		for(Map.Entry<String, List<String>> entry : hMap.entrySet()) {
			result.add(entry.getValue());
		}
		
		return result;
	}
	
	public static List<List<String>> groupAnagramsSlow(String[] strs) {
		List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> hMap = new HashMap<>();
        
        for(String s: strs){
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Character> heap = new PriorityQueue<Character>((c1, c2) -> c1-c2);
            for(char c : s.toCharArray()) heap.offer(c);
            while(!heap.isEmpty()) sb.append(""+heap.poll());
            String sorted = sb.toString();
            
            List<String> anagrams = hMap.getOrDefault(sorted, new ArrayList<String>());
            anagrams.add(s);
            hMap.put(sorted, anagrams);
        }
        
        for(Map.Entry<String, List<String>> entry : hMap.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;
	}
}

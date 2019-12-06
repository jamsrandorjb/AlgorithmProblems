package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 1268. Search Suggestions System  
 * problem url: https://leetcode.com/problems/search-suggestions-system/ 
 * leetcode profile: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class SuggestedProducts {
	public static void main(String[] args) {
		System.out.println(suggestedProducts(new String[] { "havana" }, "tatania"));
	}

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		HashMap<String, List<String>> hMap = new HashMap<>();

		// building the hashMap
		for (String product : products) {
			for (int i = 1; i <= product.length(); i++) {
				String sub = i == product.length() ? product : product.substring(0, i);
				List<String> set = hMap.getOrDefault(sub, new ArrayList<String>());
				set.add(product);
				hMap.put(sub, set);
			}
		}

		List<List<String>> result = new ArrayList<List<String>>();
		// building the search results
		for (int i = 1; i <= searchWord.length(); i++) {
			String s = i == searchWord.length() ? searchWord : searchWord.substring(0, i);
			if (!hMap.containsKey(s)) {
				result.add(new ArrayList<String>());
				continue;
			}
			List<String> resultt = hMap.get(s);
			Collections.sort(resultt);
			if (resultt.size() > 3)
				result.add(resultt.subList(0, 3));
			else {
				result.add(resultt);
			}
		}

		return result;
	}
}
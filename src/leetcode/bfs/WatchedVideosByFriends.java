package leetcode.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
* 5305. Get Watched Videos by Your Friends
* problem url: https://leetcode.com/problems/get-watched-videos-by-your-friends/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class WatchedVideosByFriends {
	public static void main(String[] args) {
		List<List<String>> finalInput = new ArrayList<>();
		List<String> input = new ArrayList<>();
		input.add("A");
		input.add("B");
		finalInput.add(input);
		input = new ArrayList<>();
		input.add("C");
		finalInput.add(input);
		input = new ArrayList<>();
		input.add("B");
		input.add("C");
		finalInput.add(input);
		input = new ArrayList<>();
		input.add("D");
		finalInput.add(input);
		System.out.println(watchedVideosByFriends(finalInput, new int[][] {{1,2},{0,3},{0,3},{1,2}}, 0, 1));

	}
	
	public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> result = new ArrayList<>();
        Queue<Integer> levelFriends = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        HashMap<String, Integer> hMap = new HashMap<>();
        
        levelFriends.add(id);
        visited.add(id);
        int levelCount = 0;
        
        while (!levelFriends.isEmpty()) {
            if (levelCount == level) break;
            
            int size = levelFriends.size();
            for (int i = 0; i < size; i++) {
                int temp = levelFriends.poll();
                for (int friend : friends[temp]) {
                    if (!visited.contains(friend)) {
                        levelFriends.add(friend);
                        visited.add(friend);
                    }
                }
            }
            levelCount++;
        }
        
        while (!levelFriends.isEmpty()) {
            for (String v : watchedVideos.get(levelFriends.poll())) {
                hMap.put(v, hMap.getOrDefault(v, 0) + 1);
            }
        }
        
        for (String key : hMap.keySet()) result.add(key);
        
        Collections.sort(result, (a, b)->(hMap.get(a) == hMap.get(b) ? a.compareTo(b) : hMap.get(a) - hMap.get(b)));
        
        return result;
    }
}

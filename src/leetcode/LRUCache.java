package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
* 146. LRU Cache
* problem url: https://leetcode.com/problems/lru-cache/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRUCache l = new LRUCache(3);
		l.put(1, 3);
		l.put(2, 2);
		System.out.println(l.get(1));

	}

	Deque<Integer> q;
	Map<Integer, Integer> map;
	int capacity;

	public LRUCache(int capacity) {
		q = new LinkedList<>();
		map = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		q.remove(key);
		q.addFirst(key);
		return map.get(key);
	}

	public void put(int key, int value) {
		map.put(key, value);
		q.remove(key);
		q.addFirst(key);
		if (q.size() > capacity) {
			Integer keyEvicted = q.removeLast();
			map.remove(keyEvicted);
		}
	}
}

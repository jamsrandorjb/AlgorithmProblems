package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
* 841. Keys and Rooms
* problem url: https://leetcode.com/problems/keys-and-rooms/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class KeysAndRooms {

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		List<Integer> keys1 = new ArrayList<>();
		keys1.add(1);
		List<Integer> keys2 = new ArrayList<>();
		keys2.add(2);
		List<Integer> keys3 = new ArrayList<>();
		keys3.add(3);
		List<Integer> keys4 = new ArrayList<>();
		rooms.add(keys1);
		rooms.add(keys2);
		rooms.add(keys3);
		rooms.add(keys4);

		System.out.println(canVisitAllRooms(rooms));

	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

		Set<Integer> visitedRooms = new HashSet<>();
		visitedRooms.add(0);
		Stack<Integer> collectedKeys = new Stack<>();
		collectedKeys.add(0);

		while (!collectedKeys.isEmpty()) {

			int key = collectedKeys.pop();
			List<Integer> keysFromRoom = rooms.get(key);

			for (int keyFromRoom : keysFromRoom) {
				if (visitedRooms.contains(keyFromRoom))
					continue;
				visitedRooms.add(keyFromRoom);
				collectedKeys.push(keyFromRoom);
			}
		}

		return visitedRooms.size() == rooms.size();
	}
}

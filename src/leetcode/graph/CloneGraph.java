package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
* 133. Clone Graph
* problem url: https://leetcode.com/problems/clone-graph/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {
	public static void main(String[] args) {
		Node newnode1 = new Node(1);
		newnode1.neighbors.add(new Node(2));
		newnode1.neighbors.add(new Node(4));

		cloneGraph(newnode1);
	}

	public static Node cloneGraph(Node start) {
		if (start == null)
			return null;

		Map<Node, Node> clonedNodes = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();

		queue.offer(start);
		clonedNodes.put(start, new Node(start.val));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (Node neighbor : current.neighbors) {
				if (!clonedNodes.containsKey(neighbor)) {
					clonedNodes.put(neighbor, new Node(neighbor.val));
					queue.offer(neighbor);
				}
				clonedNodes.get(current).neighbors.add(clonedNodes.get(neighbor));
			}
		}

		return clonedNodes.get(start);
	}
}
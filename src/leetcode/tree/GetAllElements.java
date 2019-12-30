package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
* 5296. All Elements in Two Binary Search Trees
* problem url: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class GetAllElements {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;

		System.out.println(getAllElements(root, root));
	}

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        traverse(root1, minHeap);
        traverse(root2, minHeap);
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        
        return result;
    }
    
    private static void traverse(TreeNode root, PriorityQueue<Integer> heap){
        if(root == null) return;
        heap.offer(root.val);
        traverse(root.left, heap);
        traverse(root.right, heap);
    }
}
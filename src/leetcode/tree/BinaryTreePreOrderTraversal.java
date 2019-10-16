package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
* 144. Binary Tree Preorder Traversal
* problem url: https://leetcode.com/problems/binary-tree-preorder-traversal/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BinaryTreePreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(preorderTraversal(root));
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();    
        addToList(root, result);
        
        return result;
    }
    
    private static void addToList(TreeNode node, List<Integer> nodes){
        if(node == null) return;
        nodes.add(node.val);
        addToList(node.left, nodes);
        addToList(node.right, nodes);
    }
}

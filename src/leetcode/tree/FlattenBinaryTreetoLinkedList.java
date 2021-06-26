package leetcode.tree;

/*
* 114. Flatten Binary Tree to Linked List
* problem url: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		flatten(root);
		System.out.println(root);
	}
	
	public static void flatten(TreeNode root) {
        if(root == null)
        {
            return;
        }
        
        TreeNode leftTemp = root.left;
        TreeNode rightTemp = root.right;
        
        //flatten left sub tree
        flatten(leftTemp);
        //flatten right sub tree
        flatten(rightTemp);
        
        //set left subtree to null
        root.left = null;
        //adding to the right subtree
        root.right = leftTemp;
        TreeNode curr = root;
        //going to the most right child
        while(curr.right != null){
            curr = curr.right;
        }
        
        curr.right = rightTemp;
    }
}

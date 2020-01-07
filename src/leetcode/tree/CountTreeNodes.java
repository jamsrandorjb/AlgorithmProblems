package leetcode.tree;

/*
* 222. Count Complete Tree Nodes
* problem url: https://leetcode.com/problems/count-complete-tree-nodes/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CountTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		
		child1.left = child2;
		root.right = child1;
		
		System.out.println(countNodes(root));
	}
	
	public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right); 
    }
}

package leetcode.tree;

/*
* 1038. Binary Search Tree to Greater Sum Tree
* problem url: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BSTtoGSTProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(bstToGst(root));
	}
	
	static int tilt = 0;
	
	public static TreeNode bstToGst(TreeNode root) {
        calculateSum(root, 0);
        
        return root;
    }
    
    private static int calculateSum(TreeNode node, int sum){
        if(node == null) return sum;
        
        node.val = calculateSum(node.right, sum) + node.val;
        
        if(node.left != null) return calculateSum(node.left, node.val);
        
        return node.val;
    }
}

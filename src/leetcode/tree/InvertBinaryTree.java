package leetcode.tree;

/*
* 226. Invert Binary Tree
* problem url: https://leetcode.com/problems/invert-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(invertTree(root));
	}
	
	public static TreeNode invertTree(TreeNode root) {
        return switchNode(root);
    }
    
    private static TreeNode switchNode(TreeNode node){
        if(node == null) return null;
        
        TreeNode res = new TreeNode(node.val);
        
        res.right = node.left != null ?  node.left : null;
        res.left = node.right != null ?  node.right : null; 
        
        res.left = switchNode(res.left);
        res.right = switchNode(res.right);
        
        return res;
    }
}

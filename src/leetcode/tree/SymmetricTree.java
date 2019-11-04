package leetcode.tree;

/*
* 101. Symmetric Tree
* problem url: https://leetcode.com/problems/symmetric-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(2);
		root.left = child2;
		root.right = child1;
		
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricRec(root.left, root.right);
    }
    
    private static boolean isSymmetricRec(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        
        return isSymmetricRec(node1.left, node2.right) && isSymmetricRec(node1.right, node2.left);
    }
}

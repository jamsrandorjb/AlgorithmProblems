package leetcode.tree;

/*
* 100. Same Tree
* problem url: https://leetcode.com/problems/same-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(2);
		root.left = child2;
		root.right = child1;
		
		
		TreeNode root1 = new TreeNode(1);
		
		TreeNode child3 = new TreeNode(2);
		TreeNode child4 = new TreeNode(3);
		root1.left = child3;
		root1.right = child4;
		
		System.out.println(isSameTree(root, root1));
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}

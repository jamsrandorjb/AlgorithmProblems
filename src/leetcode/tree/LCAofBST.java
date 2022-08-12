package leetcode.tree;

/*
* 235. Lowest Common Ancestor of a Binary Search Tree
* problem url: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class LCAofBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		
		System.out.println(largestValues(root, new TreeNode(1), new TreeNode(3)));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        
        if(root.val >= min && root.val <= max)
            return root;
        
        if(root.val > max)
            return lowestCommonAncestor(root.left, p, q);
        
        return lowestCommonAncestor(root.right, p, q);
    }
}
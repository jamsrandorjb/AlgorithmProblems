package leetcode.tree;

/*
* 572. Subtree of Another Tree
* problem url: https://leetcode.com/problems/subtree-of-another-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SubTree {

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
		
		System.out.println(isSubtree(root, root1));
	}
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    private static boolean traverse(TreeNode s,TreeNode t){
        return  s != null && (isEqual(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
    
    private static boolean isEqual(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isEqual(s.right, t.right) && isEqual(s.left, t.left);
    }  
}

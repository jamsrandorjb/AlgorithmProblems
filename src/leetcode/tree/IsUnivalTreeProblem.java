package leetcode.tree;

/*
* 965. Univalued Binary Tree
* problem url: https://leetcode.com/problems/univalued-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class IsUnivalTreeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(isUnivalTree(root));
	}
	
	public static boolean isUnivalTree(TreeNode root) {
        return root == null ? true : checkNodes(root.val, root);
    }
	
	private static boolean checkNodes(int rootVal, TreeNode node){
        if(node == null) return true;    
        if(node.val != rootVal) return false;    
        if(!checkNodes(rootVal, node.left)) return false;
        
        return checkNodes(rootVal, node.right);
    }
}

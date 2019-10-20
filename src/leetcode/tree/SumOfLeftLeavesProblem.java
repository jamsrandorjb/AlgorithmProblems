package leetcode.tree;

/*
* 404. Sum of Left Leaves
* problem url: https://leetcode.com/problems/sum-of-left-leaves/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SumOfLeftLeavesProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(sumOfLeftLeaves(root));
	}
	
	public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return findSum(root, 0, false);
    }
    
    public static int findSum(TreeNode node, int sum, Boolean isLeft) {
        if(node.left != null)
            return node.right == null ? findSum(node.left, sum, true) : findSum(node.left, sum, true) + findSum(node.right, sum, false);
        if(node.left == null && node.right != null)  return findSum(node.right, sum, false); 
        
        return isLeft ? sum + node.val : sum;
    }
}

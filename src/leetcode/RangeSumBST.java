package leetcode;

/*
* Range Sum BST
* problem url: https://leetcode.com/problems/range-sum-of-bst/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RangeSumBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeSumBST(new TreeNode(5), 5, 10));
	}
	
	public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null) return sum;
        
        if(root.val >= L && root.val <= R)
            sum += root.val;
            
        int leftSum = rangeSumBST(root.left, L, R);
        int rightSum = rangeSumBST(root.right, L, R);
        
        
        return sum + leftSum + rightSum;
    }
}

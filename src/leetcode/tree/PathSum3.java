package leetcode.tree;

/*
* 437. Path Sum III
* problem url: https://leetcode.com/problems/path-sum-iii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class PathSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		System.out.println(pathSum(root, 3));
	}

	static int count = 0;
    static int MOD = 1000000007;
    
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        targetSum %= MOD;
        dfs(root, targetSum); 
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        return count;
    }
    
    private static void dfs(TreeNode root, int sum) {
        if (root == null) return;
        root.val %= MOD;
        sum -= root.val;
        sum %= MOD; 
        
        if (sum == 0) {
            count++;
        }
        
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}

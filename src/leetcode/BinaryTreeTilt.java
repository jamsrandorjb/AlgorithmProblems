package leetcode;

/*
* Binary Tree Tilt
* problem url: https://leetcode.com/problems/binary-tree-tilt/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BinaryTreeTilt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(findTilt(root));
	}
	
	static int tilt = 0;
	
	public static int findTilt(TreeNode root) {
		tiltOfTheNode(root);
        
        return tilt;
    }
    
    private static int tiltOfTheNode(TreeNode node){
    	if(node == null) return 0;
        
        int left = tiltOfTheNode(node.left);
        int right = tiltOfTheNode(node.right);
        tilt += Math.abs(left-right);
        
        return node.val + left + right;
    }
}

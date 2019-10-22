package leetcode.tree;

/*
* 450. Delete Node in a BST
* problem url: https://leetcode.com/problems/delete-node-in-a-bst/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BinarySearchTreeDeleteNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(deleteNode(root, 1));
	}
	
	public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val == key){
            if(root.left == null && root.right == null)
                 return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                TreeNode willbeDeleted = findMin(root.right);
                root.val = willbeDeleted.val;
                root.right = deleteNode(root.right, willbeDeleted.val);
            }
        }
        
        return root;
    }
    
    
    public static TreeNode findMin(TreeNode node){
        if(node==null) return null;
        
        while(node.left!=null) node=node.left;
        
        return node;
    }
}

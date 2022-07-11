package leetcode.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.tree.TreeNode;

/*
* 199. Binary Tree Right Side View
* problem url: https://leetcode.com/problems/binary-tree-right-side-view/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		System.out.println(rightSideView(null));
		System.out.println(rightSideView(new TreeNode(2)));
	}

	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if(i == size - 1)
                    result.add(node.val);
                
                if(node.left != null)
                    queue.offer(node.left);
                
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        
        return result;
    }
}

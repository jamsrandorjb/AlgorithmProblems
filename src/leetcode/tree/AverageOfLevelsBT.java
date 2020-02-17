package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 637. Average of Levels in Binary Tree
* problem url: https://leetcode.com/problems/average-of-levels-in-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AverageOfLevelsBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(averageOfLevels(root));
	}
	
	public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                
                if(current.left != null)
                    queue.offer(current.left);
                
                if(current.right != null)
                    queue.offer(current.right);
                
            }
            
            result.add(sum/size);
        }
        
        return result;
    }
}
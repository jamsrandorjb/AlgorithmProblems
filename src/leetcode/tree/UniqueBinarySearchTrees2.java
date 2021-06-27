package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/*
* 95. Unique Binary Search Trees II
* problem url: https://leetcode.com/problems/unique-binary-search-trees-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {		
		System.out.println(generateTrees(5));
	}
	
	public static List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }
    
    private static List<TreeNode> generateTree(int start, int end){
        List<TreeNode> result = new LinkedList<>();
        if(start > end)
        {
            result.add(null);
            return result;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftSubTrees = generateTree(start, i - 1);
            List<TreeNode> rightSubTrees = generateTree(i + 1, end);
            
            for(TreeNode left : leftSubTrees){
                for(TreeNode right : rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
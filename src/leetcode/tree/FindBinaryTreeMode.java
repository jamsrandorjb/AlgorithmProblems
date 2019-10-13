package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/*
* 501. Find Mode in Binary Search Tree
* problem url: https://leetcode.com/problems/find-mode-in-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FindBinaryTreeMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(findMode(root));
	}
	
	static int maxFrequency = 0;
	
	public static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>(); 
        findDuplicates(root, hMap);
        
        int resultSize = 0;
        for(Integer entryCount : hMap.values()){
            if(entryCount == maxFrequency) resultSize++;    
        }
        
        int[] result = new int[resultSize];
        int j = 0;
        
        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()){
            if(entry.getValue() == maxFrequency){
                result[j] = entry.getKey();
                j++;
            }
        }
        
        return result;
	}
	    
    private static void findDuplicates(TreeNode node, HashMap<Integer, Integer> hMap){
        if(node == null) return;
        
        int frequency = hMap.getOrDefault(node.val, 0) + 1;
        maxFrequency = frequency > maxFrequency ? frequency : maxFrequency;
        
        hMap.put(node.val, frequency);
        findDuplicates(node.left, hMap);
        findDuplicates(node.right, hMap);
    }
}

package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
* 590. N-ary Tree Postorder Traversal
* problem url: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class NAryTreePostOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node();
		root.val = 1;
		
		Node child1 = new Node();
		child1.val = 2;
		child1.children = new ArrayList<Node>();
		
		Node child2 = new Node();
		child2.val = 3;
		child2.children = new ArrayList<Node>();
		
		Node child3 = new Node();
		child3.val = 4;
		child3.children = new ArrayList<Node>();
		
		List<Node> childrenOfTheTree = new ArrayList<Node>();
		childrenOfTheTree.add(child1);
		childrenOfTheTree.add(child2);
		childrenOfTheTree.add(child3);
		root.children = childrenOfTheTree;
		
		System.out.println(postorder(root));
	}
	
	public static List<Integer> postorder(Node root) {
       List<Integer>  result = new ArrayList<Integer>();
       addToTheList(result, root);
        
       return result;
    }
	    
    private static void addToTheList(List<Integer> result, Node root) {
       if(root == null) return;
       for(Node child: root.children)
        addToTheList(result, child);
       result.add(root.val);
    } 
}

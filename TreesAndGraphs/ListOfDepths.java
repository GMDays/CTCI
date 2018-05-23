package TreesAndGraphs;

import java.util.LinkedList;

import TreesAndGraphs.MinimalTree.BSTNode;

public class ListOfDepths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTree bst = new MinimalTree();
		int[] ordered = new int[9];
		ordered[0] = 2;
		ordered[1] = 3;
		ordered[2] = 4;
		ordered[3] = 5;
		ordered[4] = 6;
		ordered[5] = 7;
		ordered[6] = 8;
		ordered[7] = 9;
		ordered[8] = 10;
		BSTNode binary = bst.GetMinimalBST(ordered);
		
		LinkedList<LinkedList<BSTNode>> result = GetListOfDepthsIterative(binary);
		for(LinkedList<BSTNode> list : result) {
			System.out.println("This is a new list: " + list);
			for(BSTNode node : list) {
				System.out.println(" " + node.data);
			}
		}
		
		LinkedList<LinkedList<BSTNode>> result2 = GetListOfDepthsRecursive(binary);
		for(LinkedList<BSTNode> list : result2) {
			System.out.println("This is a new recursive list: " + list);
			for(BSTNode node : list) {
				System.out.println(" " + node.data);
			}
		}		
	}	
	
	public static LinkedList<LinkedList<BSTNode>> GetListOfDepthsRecursive(BSTNode root){
		LinkedList<LinkedList<BSTNode>> nodes = new LinkedList<LinkedList<BSTNode>>();		
		GetListOfDepthsRecursive(root, nodes, 0);
		return nodes;
	}
	
	public static void GetListOfDepthsRecursive(BSTNode root, LinkedList<LinkedList<BSTNode>> nodes, int level){
		if(root==null) {
			return;
		}		
		LinkedList<BSTNode> node = null;
		if(nodes.size() == level) {
			node = new LinkedList<BSTNode>();
			nodes.add(node);
		}
		else {
			node = nodes.get(level);
		}		
		node.add(root);
		GetListOfDepthsRecursive(root.left, nodes, level+1);
		GetListOfDepthsRecursive(root.right, nodes, level+1);
	}
	
	public static LinkedList<LinkedList<BSTNode>>GetListOfDepthsIterative(BSTNode root) {		
		LinkedList<LinkedList<BSTNode>> result = new LinkedList<LinkedList<BSTNode>>();
		LinkedList<BSTNode> nodes = new LinkedList<BSTNode>();
		if(root!=null) {
			nodes.add(root);
		}
		while(nodes.size()>0) {
			result.add(nodes);
			LinkedList<BSTNode> parents = nodes;
			nodes = new LinkedList<BSTNode>();
			for(BSTNode child : parents) {
				if(child.left!=null) {
					nodes.add(child.left);
				}
				if(child.right!=null) {
					nodes.add(child.right);
				}
			}
		}				
		return result;
	}	
}

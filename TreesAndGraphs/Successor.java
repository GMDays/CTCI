package TreesAndGraphs;

import TreesAndGraphs.MinimalTree.BSTNode;

public class Successor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTree bst = new MinimalTree();
		BSTNode bt = bst.new BSTNode(6);
		bt.left = bst.new BSTNode(3);
		bt.left.parent = bt;
		bt.left.left = bst.new BSTNode(2);
		bt.left.left.parent = bt.left;
		bt.right = bst.new BSTNode(7);
		bt.right.parent = bt;
		//BSTNode bt = bst.new BSTNode(6);
		System.out.println(GetSuccessor(bt.left.left).data);
		//System.out.print(GetSuccessor(binary));
	}

	public static BSTNode GetSuccessor(BSTNode node) {
		if(node==null) {
			return null;
		}
		if(node.right!=null) {
			BSTNode leftMost = node.right;
			//search for the left most child on the right subtree			
			while(leftMost.left!=null) {
				leftMost = leftMost.left;
			}
			return leftMost;
		}
		else {
			BSTNode curr = node;
			BSTNode parent = curr.parent;
			//search up the tree, until we have found a node not traversed (when we come from a left child node to a parent)
			//then we return the parent
			while(parent!=null && curr != parent.left) {
				curr = parent;
				parent = parent.parent;				
			}			
			return parent;
		}					
	}
}

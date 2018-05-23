package TreesAndGraphs;

import TreesAndGraphs.MinimalTree.BSTNode;

public class CheckBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTree bst = new MinimalTree();
		int[] ordered = new int[11];				
		ordered[3] = 5;
		ordered[4] = 6;
		ordered[5] = 7;
		ordered[6] = 8;
		ordered[7] = 9;
		ordered[8] = 10;
		ordered[9] = 12;
		ordered[9] = 1;
		ordered[0] = 2;
		ordered[1] = 3;
		ordered[2] = 4;
		BSTNode binary = bst.GetMinimalBST(ordered);
		CheckBalanced check = new CheckBalanced();		
		//System.out.println(check.IsItBalanced(binary));
		//bst.PreOrderTraversalBST(binary);
		
		
		BSTNode bt = bst.new BSTNode(6);
		bt.left = bst.new BSTNode(3);
		bt.left.left = bst.new BSTNode(2);
		bt.left.left.left = bst.new BSTNode(1);
		bt.right = bst.new BSTNode(7);
		System.out.println(check.IsItBalanced(bt));
	}
	
	public boolean IsItBalanced(BSTNode root) {		
		if(root==null) {
			return true;
		}
		
		if(Math.abs(GetHeight(root.left)-GetHeight(root.right)) > 1) {
			return false;
		}
		else {
			return IsItBalanced(root.left) && IsItBalanced(root.right);
		}
	}
	
	public int GetHeight(BSTNode root) {
		if(root==null) {
			return -1;
		}
		
		return Math.max(GetHeight(root.left), GetHeight(root.right)) + 1;
	}
	
	public boolean IsItBalanced(BSTNode root, int leftTree, int rightTree) {
		if(root==null) {
			return true;
		}
		
		if(Math.abs(leftTree-rightTree) > 1) {
			return false;
		}			
		if(root.left!=null) {
			return IsItBalanced(root.left, leftTree+1, rightTree);
		}
		if(root.right!=null) {
			return IsItBalanced(root.right, leftTree, rightTree+1);
		}	
		
//		if(root!=null) {
//			if(Math.abs(leftTree-rightTree) > 1) {
//				return false;
//			}			
//			if(root.left!=null) {
//				IsItBalanced(root.left, leftTree+1, rightTree);
//			}
//			if(root.right!=null) {
//				IsItBalanced(root.right, leftTree, rightTree+1);
//			}	
//		}
//		else {
//			return false;
//		}
		
		return true;
		//return IsItBalanced(root.left, leftTree+1, rightTree) && IsItBalanced(root.right, leftTree, rightTree+1);
	}
}

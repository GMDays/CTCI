package TreesAndGraphs;

//import javax.swing.tree.TreeNode;

import TreesAndGraphs.MinimalTree.BSTNode;
import TreesAndGraphs.TreeNode;

public class FirstCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeNode node = new TreeNode(6);
		
		MinimalTree bst = new MinimalTree();
		BSTNode bt = bst.new BSTNode(6);
		bt.left = bst.new BSTNode(3);
		//bt.left.parent = bt;
		bt.left.right = bst.new BSTNode(4);
		//bt.left.right.parent = bt.left;
		bt.left.left = bst.new BSTNode(2);
		//bt.left.left.parent = bt.left;
		bt.right = bst.new BSTNode(9);
		//bt.right.parent = bt;
		bt.right.left = bst.new BSTNode(8);
		//bt.right.left.parent = bt.right;
		bt.right.right = bst.new BSTNode(11);
		//bt.right.right.parent = bt.right;
		
		TreeNode node = new TreeNode(6);
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		//node3.parent=node;
		node.SetLeftChild(node3);
		node.SetRightChild(node9);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		node3.SetLeftChild(node2);
		//node2.parent = node3;
		node3.SetRightChild(node4);
		//node4.parent = node3;
		//System.out.println(bt.right.right.data);
		System.out.println(GetFCA(node2, node4, node));
	}
	
	public static boolean IsDescendant(TreeNode root, TreeNode target) {
		if(root==null) {
			return false;
		}
		if(root==target) {
			return true;
		}		
		return IsDescendant(root.left, target) || IsDescendant(root.right, target);
	}
	
	public static TreeNode GetFCA(TreeNode source1, TreeNode source2, TreeNode root) {
	
		if(root==null || root == source1 || root == source2) {
			return root;
		}	
		
		boolean source1OnLeft = IsDescendant(root.left,source1);
		boolean source2OnLeft = IsDescendant(root.left,source2);
		if(source1OnLeft!=source2OnLeft) {
			return root;
		}
		TreeNode child = source1OnLeft ? root.left : root.right;
		
		return GetFCA(child, source1, source2);
	}
}

package TreesAndGraphs;

import java.util.LinkedList;

public class CheckSubtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Test Case 1
		TreeNode node15 = new TreeNode(15);
		node15.SetRightChild(new TreeNode(19));
		TreeNode node2 = new TreeNode(9);
		node15.SetLeftChild(node2);
		node2.SetLeftChild(new TreeNode(4));
		node2.SetRightChild(new TreeNode(5));
		
		TreeNode nnode2 = new TreeNode(9);
		nnode2.SetLeftChild(new TreeNode(4));
		nnode2.SetRightChild(new TreeNode(5));
		
		CheckSubtree check = new CheckSubtree();
		System.out.println(check.AreTheSame2(node15, nnode2));
	}

	public boolean AreTheSame(TreeNode root1, TreeNode root2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		GetPreOrderTraversal(root1, sb1);
		GetPreOrderTraversal(root2, sb2);		
		
		if(sb1.indexOf(sb2.toString()) != -1) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public void GetPreOrderTraversal(TreeNode root, StringBuilder sb) {
		if(root==null) {
			sb.append("X");
			return;
		}
		
		sb.append(Integer.toString(root.data));
		GetPreOrderTraversal(root.left, sb);
		GetPreOrderTraversal(root.right, sb);
	}
	
	public boolean AreTheSame2(TreeNode root1, TreeNode root2) {
		if(root2==null) {
			return true; // empty tree is always a subtree
		}
		if(root1==null) {
			return false;
		}
		
		// if root of bigger tree matches root of smaller tree, check if they have identical trees
		if(root1.data == root2.data && matchTree(root1,root2)) {
			return true;
		}
		
		return AreTheSame2(root1.left, root2) || AreTheSame2(root1.right, root2);
	}
	
	public boolean matchTree(TreeNode root1, TreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}
		else if(root1==null || root2==null) {
			return false;
		}
		else if(root1.data!=root2.data) {
			return false;
		}
		else {
			return matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right);
		}		
	}
}

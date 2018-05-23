package Hackerrank;

import TreesAndGraphs.TreeNode;


public class Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static TreeNode lca(TreeNode root, int val1, int val2) {
		if(root.data < val1 && root.data < val2) {
			return lca(root.right, val1, val2);
		}
		else if(root.data > val1 && root.data > val2) {
			return lca(root.left, val1, val2);
		}
		else {
			return root;
		}
	}
	
	static TreeNode InsertRecurse(TreeNode root, int value) {		
		if(root==null) {
			TreeNode temp = new TreeNode(value);
			return temp;
		}
		if(value>root.data) {
			root.right = InsertRecurse(root.right, value);
		}
		else if(value<root.data) {
			root.left = InsertRecurse(root.left, value);
		}
		
		return root;
	}
	
	static TreeNode Insert(TreeNode root, int value) {
	    if(root==null){
	        TreeNode n = new TreeNode(value);
	        n.left = null;
	        n.right = null;
	        n.data = value;
	        return n;
	    }
	    
	    TreeNode temp = root;
	    TreeNode parent = root;
	    while(temp!=null){
	        parent = temp;
	        if(value>temp.data){
	            temp = temp.right;
	        }
	        else if(value<temp.data){
	            temp = temp.left;
	        }
	        else{
	            return root;
	        }
	    }
	    
	    TreeNode n = new TreeNode(value);
	    n.data = value;
	    if(parent.data > value){
	        parent.left = n;
	    }
	    else{
	        parent.right = n;
	    }

	    return root;
	    	
	}
	
	void topView(TreeNode root) {
	      //System.out.print(root.data + " ");
	        if(root.left!=null){
	         checkLeft(root.left);
	     }
	     
	        
	      System.out.print(root.data + " ");
	        
	    if(root.right!=null){
	         checkRight(root.right);
	     }
	    }

	    void checkRight(TreeNode root){
	        System.out.print(root.data + " ");
	        if(root.right!=null){            
	            checkRight(root.right);
	        }
	        
	    }

	    void checkLeft(TreeNode root){
	        
	        if(root.left!=null){            
	            checkLeft(root.left);
	        }
	        System.out.print(root.data + " ");
	    }

}

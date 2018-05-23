package TreesAndGraphs;

public class MinimalTree {

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
		System.out.println("Following is the pre-order-traversal of BST starting from root");
		bst.PreOrderTraversalBST(binary);
		System.out.println("Following is the in-order-traversal of BST starting from root");
		bst.InOrderTraversalBST(binary);
		System.out.println("Following is the post-order-traversal of BST starting from root");
		bst.PostOrderTraversalBST(binary);
	}
	
	public class BSTNode{
		public int data;
		public BSTNode parent;
		public BSTNode left;
		public BSTNode right;
		public boolean marked;
		
		public BSTNode(int data) {
			this.marked = false;
			this.data = data;
			this.parent = null;
			this.left = null;
			this.right = null;
		}		
	}		
	
	public void InOrderTraversalBST(BSTNode root) {
		//System.out.println("in-order-traversal of binary search tree starting from root");
		if(root!=null) {
			InOrderTraversalBST(root.left);
			System.out.println("FOUND THE MOTHERFUCKER");
			InOrderTraversalBST(root.right);
		}
	}
	
	public void PreOrderTraversalBST(BSTNode root) {
		//System.out.println("Following is the pre-order-traversal of BST starting from root");
		if(root!=null) {
			System.out.println(root.data);
			PreOrderTraversalBST(root.left);
			PreOrderTraversalBST(root.right);
		}
	}
	
	public void PostOrderTraversalBST(BSTNode root) {
		//System.out.println("Following is the post-order-traversal of BST starting from root");
		if(root!=null) {			
			PostOrderTraversalBST(root.left);
			PostOrderTraversalBST(root.right);
			System.out.println(root.data);
		}
	}
	
	public BSTNode GetMinimalBSTRecursive(int[] datas, int start, int end) {
		if(end<start) {
			return null;
		}		
		int mid = (start + end) / 2;
		BSTNode node = new BSTNode(datas[mid]);
		//System.out.println(datas[mid]);
		node.left = GetMinimalBSTRecursive(datas, start, mid-1);
		node.right = GetMinimalBSTRecursive(datas, mid+1, end);		
		return node;
	}
	
	public BSTNode GetBSTRecursive(int[] datas, int start, int end) {
		BSTNode node = new BSTNode(datas[0]);
		
		return node;
	}
	
	public BSTNode GetMinimalBST(int[] datas) {
		return GetMinimalBSTRecursive(datas, 0, datas.length-1);
	}

}

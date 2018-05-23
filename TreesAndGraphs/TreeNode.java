package TreesAndGraphs;

public class TreeNode {
	public int data;
	public TreeNode left, right, parent;
	private int size = 0;
	
	public TreeNode(int data) {
		this.data = data;
		size = 1;
	}
	
	public void InsertInOrder(int d) {
		if(d<=data) {
			if(left==null) {
				SetLeftChild(new TreeNode(d));
			}
			else {
				left.InsertInOrder(d);
			}
		}
		else {
			if(right==null) {
				SetRightChild(new TreeNode(d));
			}
			else {
				right.InsertInOrder(d);
			}
		}
		size++;
	}
	
	public int Size() {
		return size;
	}
	
	public TreeNode Find(int d) {
		if(d==data) {
			return this;
		}
		else if(d<=data) {
			if(left!=null) {
				left.Find(d);
			}
			else {
				return null;
			}
		}
		else {
			if(right!=null) {
				right.Find(d);
			}
			else {
				return null;				
			}
		}
		return null;
	}
	
	public void SetLeftChild(TreeNode left) {
		this.left = left;
		if(left!=null) {
			left.parent = this;
		}
	}
	
	public void SetRightChild(TreeNode right) {
		this.right = right;
		if(right!=null) {
			right.parent = this;
		}
	}
}

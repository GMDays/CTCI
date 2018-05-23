package TreesAndGraphs;

import java.util.Random;

public class RandomNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree(5);
		
	}

}

class BinaryTree{
	public BinaryTree left,right,root;
	private int data;
	private int size;
	
	BinaryTree(int data){
		this.data = data;
		size = 1;
	}
	
	public int GetSize() {
		return size;
	}
	
	public BinaryTree GetRandomeNode() {
		int leftSize = left == null ? 0 : left.size;
		//int rightSize = right == null ? 0 : right.size;
		
		Random rand = new Random();
		int randIndex = rand.nextInt(size);
		
		// Recurse on the left side if randIndex lies in left
		if(randIndex < leftSize) {
			return left.GetRandomeNode();
		}
		else if(randIndex == size) {
			return this;
		}
		else {
			return right.GetRandomeNode();
		}
	}
	
	public void Insert(int data) {
		if(left.data<=data) {
			if(left!=null) {
				left.Insert(data);
			}
			else {
				left = new BinaryTree(data);
			}
		}
		else {
			if(right!=null) {
				right.Insert(data);
			}
			else {
				right = new BinaryTree(data);
			}
		}		
		size++;
	}
	
	public BinaryTree Find(int data) {
		if(data == this.data) {
			return this;
		}
		else if(data<=this.data) {
			return left != null ? left.Find(data) : null;
		}
		else if(data>this.data){
			return right != null ? right.Find(data) : null;
		}
		return null;
	}
}

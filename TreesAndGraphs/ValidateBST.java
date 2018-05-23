package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import TreesAndGraphs.MinimalTree.BSTNode;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MinimalTree bst = new MinimalTree();
//		BSTNode bt = bst.new BSTNode(6);
//		bt.left = bst.new BSTNode(3);
//		bt.left.parent = bt;
//		bt.left.left = bst.new BSTNode(2);
//		bt.left.left.parent = bt.left;
//		bt.left.right = bst.new BSTNode(7);
//		bt.left.right.parent = bt.left.left;
//		bt.right = bst.new BSTNode(9);
//		bt.right.parent = bt;
//		System.out.println(IsItABST(bt, -1, -1));
		
		add("hello");
		//add("continue");
		//System.out.println(find("contact"));
	}
	
	 boolean checkBST(TreeNode root) {
	        return checkBST(root, 0, Integer.MAX_VALUE);
	    }

	    boolean checkBST(TreeNode root, int min, int max){
	        if(root!=null){
	            if(root.data <= min || root.data >= max){
	                    return false;
	                }
	            else{
	                return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max); 
	            }                        
	        }
	        else{
	            return true;
	        }
	    }
	
	public static HashMap<String,Integer> mapStore = new HashMap<>();
	static void add(String name) {
		String[] split = name.split("\\s+");
		System.out.println(Arrays.toString(split));
		for(String w : split) {
			for(int i=1; i<w.length()+1; i++) {
				String token = w.substring(0, i);
				//System.out.println(token);
				if(!mapStore.containsKey(token)) {
					mapStore.put(token, 0);
				}
				mapStore.put(token, mapStore.get(token) + 1);
			}
		}
		printMap(mapStore);
	}
	
	static void printMap(HashMap<String,Integer> map) {
		for(String key : map.keySet()) {
			System.out.println("key: " + key + " value: " + map.get(key));
		}
	}
	
	static int find(String partial) {
		if(mapStore.containsKey(partial)) {
			return mapStore.get(partial);
		}
		else {
			return 0;
		}
	}
	
	public static boolean IsItABST(BSTNode root, int min, int max) {
		//System.out.println("Following is the in-order-traversal of BST starting from root");
		
		if(root!=null) {
			if(root.parent!=null) {
				if(min!=-1 && max!=-1) {
					if(min > root.data || max <= root.data) {
						return false;
					}
				}
				if(min!=-1) {
					if(min > root.data) {
						return false;
					}
				}
				if(max!=-1) {
					if(max <= root.data) {
						return false;
					}
				}				
			}
			System.out.println(root.data);			
			return IsItABST(root.left, min, root.data) && IsItABST(root.right, root.data, max);
		}
		else {
			return true;
		}		
	}
	

}

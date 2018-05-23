package TreesAndGraphs;

import java.util.HashMap;

public class PathsWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(2);
		root.right.right = new TreeNode(5);
		
		PathsWithSum path = new PathsWithSum();
		System.out.println(path.GetPathCountOptimized(20, root));
	}
	
	public int GetPathCountOptimized(int target, TreeNode root) {
		return GetPathCountOptimized(target, 0, root, new HashMap<Integer, Integer>());
	}
	
	public int GetPathCountOptimized(int target, int running, TreeNode root, HashMap<Integer, Integer> hash) {		
		// Base case, stop recursion.
		if(root==null) {
			return 0;
		}
		
		running += root.data;
		int sum = running - target;
		
		// Find if sum already exists in HashTable, otherwise use 0.
		int totalPaths = hash.getOrDefault(sum, 0);		
		
		// We have reached the target sum through this path, increase counter by 1.
		if(running==target) {
			totalPaths++;
		}
		
		// Increment value of runningSum inside HashTable
		IncrementHashTable(hash, running, 1);
		totalPaths += GetPathCountOptimized(target, running, root.left, hash);
		totalPaths += GetPathCountOptimized(target, running, root.right, hash);
		// Decrement value of runningSum inside HashTable
		IncrementHashTable(hash, running, -1);
		
		return totalPaths;
	}
	
	public void IncrementHashTable(HashMap<Integer, Integer> hash, int key, int delta) {
		int count = hash.getOrDefault(key, 0) + delta;
		if(count==0) {
			hash.remove(key);
		}
		else {
			hash.put(key, count);
		}
	}
	
	public int GetPathCount(int target, TreeNode root) {
		if(root==null) {
			return 0;
		}
		int rootPaths = GetPathCount(target, root, 0);
		
		int leftPaths = GetPathCount(target, root.left);
		int rightPaths = GetPathCount(target, root.right);
		
		return rootPaths + leftPaths + rightPaths;
	}
	
	public int GetPathCount(int target, TreeNode root, int current) {
		if(root==null) {
			return 0;
		}

		current+=root.data;
		int totalPaths = 0;

		// We found a path, increase counter of total paths.
		if(current==target) {
			totalPaths++;
		}
		
		totalPaths += GetPathCount(target, root.left, current);
		totalPaths += GetPathCount(target, root.right, current);

		return totalPaths;
	}
	
	
}

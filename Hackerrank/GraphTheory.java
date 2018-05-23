package Hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;

import TreesAndGraphs.MinimalTree.BSTNode;

public class GraphTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void bfs(int[][] edges) {
		
	}
	
	static boolean checkBST(BSTNode root){
		return checkBST(root, 0,0);
	}
	

	
	static int[] bfs(int n, int m, int[][] edges, int s) {
        // Complete this function
		int[] result = new int[n];
		for(int i=0; i<result.length; i++)
			result[i] = -1;
		
		result[s] = 0;
		boolean[] marked = new boolean[n];
        
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int curr = queue.removeFirst();
			
			for(int i=0; i<edges.length; i++) {
				if(edges[curr][i]==1 && marked[i] == false) {
					marked[i] = true;
					result[i] = result[curr] + 1;
					queue.add(i);
				}
			}
		}
		
		return result;
    }

}

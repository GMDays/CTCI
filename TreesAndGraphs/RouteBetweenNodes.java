package TreesAndGraphs;

import java.util.LinkedList;
import TreesAndGraphs.GraphAdjacencyList.*;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println(graph.BFS(0, 3, 5));
	}
	
	public static Boolean BFSSearch(Node start, Node dest){
		//Queue<Node> q = new LinkedList<Node>();
		LinkedList<Node> q = new LinkedList<Node>();		
		start.marked = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			Node front = q.removeFirst();
			for(Node n : front.children){
				if(n.marked==false) {
					if(n == dest) {
						return true;
					}
					n.marked = true;
					q.add(n);
				}
			}
			front.marked = true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	static int getHeight(Node root) {
		if(root==null) {
			return -1;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	
	static void levelOrder(Node root) {
	      
	    }
	
	static void printLevelOrder(Node root) {
		int height = getHeight(root);
		for(int i=0; i<height;i++) {
			printGivenLevel(root, i);
		}
	}
	
	static void printGivenLevel(Node root, int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.println(root.data);
		}
		else {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}

}

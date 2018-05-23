package TreesAndGraphs;

import java.util.LinkedList;

public class GraphAdjacencyList {
	
	private int v; //number of vertices in graph
	public LinkedList<Integer> adjList[]; //adjacency list to represent edges
	
	//private String v2; //number of vertices in graph
	//private LinkedList<String> adjList2[]; //adjacency list to represent edges
	public GraphAdjacencyList(int v) {
		this.v = v;
		adjList = new LinkedList[v];
		for(int i =0; i<v; i++) {
			adjList[i] = new LinkedList<Integer>(); //initialize an adj list for each vertex
		}	
	}

	
	public void addEdge(int v, int w) {
		//adds an edge from vertex v to vertex w
		adjList[v].add(w);
	}
	
	public Boolean BFS(int start, int dest, int totalVertices){
		boolean[] check = new boolean[totalVertices];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int front = q.removeFirst();
			System.out.print(front+" ");
			for(int iter : adjList[front]) {
				if(!check[iter]) {
					if(iter==dest) {
						return true;
					}
					check[iter]=true;
					q.add(iter);
				}
			}			
		}
		return false;
	}
	
	public static class Node{
		public String name;
		public Node[] children;
		public Boolean marked;
		public Node left;
		public Node right;
	}
	
	
	public static class Graph{		
		public Node[] nodes;
	}
}

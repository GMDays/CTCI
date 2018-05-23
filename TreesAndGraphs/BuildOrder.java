package TreesAndGraphs;

import java.util.LinkedList;

import TreesAndGraphs.MinimalTree.BSTNode;

public class BuildOrder {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList(5);
		graph.addEdge(0, 3);
		graph.addEdge(5, 1);
		graph.addEdge(1, 3);
		graph.addEdge(5, 0);
		graph.addEdge(3, 2);
		
		String[] projects = new String[6];
		String[][] deps = new String[6][6];
		deps[0][3] = "1";
		
		BuildOrder bo = new BuildOrder(graph);	
		System.out.println(bo.GetBuildOrder(projects, deps));
		
		
		
//		MinimalTree bst = new MinimalTree();
//		BSTNode bt = bst.new BSTNode(0);
//		BSTNode bt3 = bst.new BSTNode(3);
//		BSTNode bt1 = bst.new BSTNode(1);
//		BSTNode bt5 = bst.new BSTNode(5);
//		BSTNode bt2 = bst.new BSTNode(2);
//		bt2.parent = bt3;
//		bt1.parent = bt5;
//		bt3.parent = bt1;
//		bt.parent = bt5;
		
	}
	
	public GraphAdjacencyList graph;
	public BuildOrder(GraphAdjacencyList graph) {
		this.graph = graph;
	}
	
	
	public String[] GetBuildOrder(String[] projects, String[][] dependencies) {
		String[] result = new String[projects.length];
		boolean[] hasDependent = new boolean[projects.length];
		int cols = dependencies[0].length;
		int rows = dependencies.length;
		for(int i=0; i<rows;i++) {
			for(int j=0; j<cols;j++) {
				if(dependencies[i][j].equals("1")) {
					hasDependent[j] = true;
				}
			}
		}
		
		boolean[] check = new boolean[5];
		int start = 0;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int front = q.removeFirst();
			System.out.print(front+" ");
			for(int iter : graph.adjList[front]) {
				if(!check[iter]) {
//					if(iter==dest) {
//						return true;
//					}
					check[iter]=true;
					q.add(iter);
				}
			}			
		}
		return null;
	}
}

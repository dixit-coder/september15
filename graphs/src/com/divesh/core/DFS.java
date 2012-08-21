package com.divesh.core;

import java.util.Stack;

public class DFS {
	private Stack<Integer> DFSstack = new Stack<Integer>();

	/** phi is the char to start search from */
	public void getDFS_Traversal(Graph graph) {
		
		graph.vertexList[0].wasVisited = true;
		graph.displayVertex(0);
		DFSstack.push(0);

		while (!DFSstack.isEmpty()) {
			int v = graph.getAdjUnvisitedVertex(DFSstack.peek());
			if (v == -1) {
				DFSstack.pop();
			} else {
				graph.vertexList[v].wasVisited = true;
				graph.displayVertex(v);
				DFSstack.push(v);

			}

		}
		graph.resetAllVisitedFlags();
		
	}

	public static void main(String args[]) {
		DFS dfs = new DFS();
		Graph theGraph = new Graph();

		theGraph.addVertex('A');
		// 0 (start for dfs)
		theGraph.addVertex('B');
		// 1
		theGraph.addVertex('C');
		// 2
		theGraph.addVertex('D');
		// 3
		theGraph.addVertex('E');
		// 4
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		
		System.out.print("Visits: ");
		dfs.getDFS_Traversal(theGraph);


	}

}

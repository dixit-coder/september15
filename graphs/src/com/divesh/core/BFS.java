package com.divesh.core;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	Queue<Integer> BFSqueue = new LinkedList<Integer>();

	/** phi is the char to start search from */
	public void getBFS_Traversal(Graph graph) {
		graph.vertexList[0].wasVisited = true;
		BFSqueue.add(0);
		graph.displayVertex(0);
		while (!BFSqueue.isEmpty()) {
			int v = graph.getAdjUnvisitedVertex(BFSqueue.peek());
			if (v == -1) {
				BFSqueue.remove();
			} else {
				graph.vertexList[v].wasVisited = true;
				BFSqueue.add(v);
				graph.displayVertex(v);
			}
		}
		graph.resetAllVisitedFlags();
	}
	
	public static void main(String args[]) {
		BFS bfs = new BFS();
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
		theGraph.addEdge(0, 2);
		
		System.out.print("Visits: ");
		bfs.getBFS_Traversal(theGraph);


	}
}

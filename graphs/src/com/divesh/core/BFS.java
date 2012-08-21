package com.divesh.core;

import java.util.LinkedList;
import java.util.Queue;

import com.divesh.util.Vertex;

public class BFS {
	Queue<Vertex> BFSqueue = new LinkedList<Vertex>();
	/** phi is the char to start search from*/
	public void getBFS_Traversal(Graph graph)
	{
		BFSqueue.add(graph.vertexList[0]);
		while(!BFSqueue.isEmpty())
		{
			
		}
	}
}

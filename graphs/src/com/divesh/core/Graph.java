package com.divesh.core;

import com.divesh.util.Vertex;

public class Graph {
	public final int MAX_VERTS = 20;

	public Vertex vertexList[]; // array of vertices
	public int adjMat[][]; // adjacency matrix
	public int nVerts; // current number of vertices



	public Graph() {
		super();
		this.vertexList = new Vertex[MAX_VERTS];
		this.adjMat = new int[MAX_VERTS][MAX_VERTS];
		this.nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++)
			for (int j = 0; j < MAX_VERTS; j++)
				adjMat[i][j] = 0;
	}

	public void addVertex(char lab) {
		// vertexList[nVerts++].label = lab;
		vertexList[nVerts++] = new Vertex(lab);

	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void addEdge(int start, int end, int value) {
		adjMat[start][end] = value;
	}

	public int getAdjUnvisitedVertex(int v) {

		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && (vertexList[j]).wasVisited == false) {
				return j;
			}
		}
		return -1;
	}
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	public void resetAllVisitedFlags()
	{
		for(int j=0; j<nVerts; j++)
			vertexList[j].wasVisited = false;
	}
}

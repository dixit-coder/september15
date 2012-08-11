package com.divesh.core;

public class FloydWarshall {
	/**
	 * Init a square matrix where path[i][j] is the cost of the edge from i to
	 * j,
	 * 
	 * or infinite if none exist.
	 */

	static int[][] path;

	protected void computeAPSP(final int numVertices) {

		// calculate shortest paths from every vertex to every vertex

		for (int k = 0; k < numVertices; k++) {

			for (int i = 0; i < numVertices; i++) {

				for (int j = 0; j < numVertices; j++) {

					path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);

				}

			}

		}

	}

}

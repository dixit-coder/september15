package com.divesh.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DeliveryBoy {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int N = Integer.parseInt(br.readLine());
		int index = 0, numVertices = N;
		StringTokenizer st;
		int[][] path = new int[N][N];

		while (N > 0) {
			N--;
			String s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < numVertices; j++) {
				path[index][j] = Integer.parseInt(st.nextToken());
			}
			index++;
		}
		/*
		 * for (int[] q : path) { for (int r : q) { System.out.print(r + " "); }
		 * System.out.println(); } System.exit(0);
		 */

		int M = Integer.parseInt(br.readLine());
		int[][] scenarios = new int[M][3];
		int S = 0, G = 1, D = 2, sceen = M;
		index = 0;
		while (M > 0) {
			M--;
			String s = br.readLine();
			st = new StringTokenizer(s);
			scenarios[index][S] = Integer.parseInt(st.nextToken());
			scenarios[index][G] = Integer.parseInt(st.nextToken());
			scenarios[index][D] = Integer.parseInt(st.nextToken());
			index++;
		}

		/*
		 * for (int[] q : path) { for (int r : q) { System.out.print(r + " "); }
		 * System.out.println(); } System.exit(0);
		 */

		for (int k = 0; k < numVertices; k++) {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
				}
			}
		}

		/*
		 * for (int[] q : path) { for (int r : q) { System.out.print(r + " "); }
		 * System.out.println(); } System.exit(0);
		 */

		for (int i = 0; i < sceen; i++) {
			int x = path[scenarios[i][S]][scenarios[i][G]]
					+ path[scenarios[i][G]][scenarios[i][D]];
			int y = x - path[scenarios[i][S]][scenarios[i][D]];
			pw.println(x + " " + y);
		}
		pw.flush();
	}
}

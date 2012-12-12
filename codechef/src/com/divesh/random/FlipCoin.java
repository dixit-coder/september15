package com.divesh.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlipCoin {
	/**
	 * http://www.codechef.com/problems/FLIPCOIN
	 * 
	 * */

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		String NQ[] = br.readLine().split(" ");
		int N = Integer.parseInt(NQ[0]);
		int Q = Integer.parseInt(NQ[1]);
		// for dynamic programming 2-D array is initialised
		int[][] dp = new int[N][N];
		int[][] input = new int[Q][3];
		StringTokenizer st;
		int index = 0;
		while (Q > 0) {
			Q--;
			String fAB = br.readLine();
			st = new StringTokenizer(fAB);
			input[index][0] = Integer.parseInt(st.nextToken());
			input[index][1] = Integer.parseInt(st.nextToken());
			input[index][2] = Integer.parseInt(st.nextToken());
			index++;
		}

		// printing the input for Cross Check
		for (int[] x : input) {
			if (x[0] == 1) {
				// print the result from dp
				System.out.println(dp[x[1]][x[2]]);
			} else {
				// do the flip thing from A to B
				for (int i = x[1]; i <= x[2]; i++) {
					if (dp[i][i] > 0)
						dp[i][i] = 0;
					else
						dp[i][i] = 1;
				}
				reconstructDP(dp,N,x[1],x[2]);
				//ArrayUtils.print2DArray(dp);
			}
		}

	}

	private static void reconstructDP(int[][] dp, int N,int A,int B) {
		for(int i =0;i<=Math.min(B,N-1);i++)
        {
      	  for(int j =Math.max(i+1,A);j<N;j++)
      	  {
      		  dp[i][j]=dp[i][j-1]+dp[j][j];
      	  }
        }
	}

}

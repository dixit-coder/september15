package com.divesh.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BillBoardProblem {

	public long getMaxProfit(int arr[], int k) {
		int N = arr.length;
		long[][] profit = new long[N][N];

		for (int i = 0; i < N; i++) {
			profit[i][i] = arr[i];
			for (int j = i + 1; j< N && j < i + k; j++) {
				profit[i][j] = profit[i][j - 1] + arr[j];
			}
		}
		// l is size of window
		for (int l = k; l < N; l++) {

			for (int i = 0; i < N - l; i++) {
				int j = i + l;
				long max = Math.max(profit[i][j - 1], profit[i + 1][j]);

				for (int x = i + 1; x < j; x++) {
					max = Math.max(max, profit[i][x - 1] + profit[x + 1][j]);
				}

				profit[i][j] = max;
			}
		}
		return profit[0][N-1];
	}
	
	public static void main(String args[])throws Exception
	{
		/*int arr[]={1,2,3,1,6,10};
		int k = 5;
		int arr[] = new int[10000];
		for(int i=0;i<10000;i++)
		{
			arr[i]=i+1;
		}
		int k = 100000;// 6;
		BillBoardProblem billBoardProblem = new BillBoardProblem();
		System.out.println(billBoardProblem.getMaxProfit(arr, k));*/
		Solution.main(args);
	}
}
class Solution
{
  public static void main(String args[])throws Exception
  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int k = Integer.parseInt(NK[1]);	
	    int input[] = new int[N];
	    for(int i =0;i<N;i++)
	    {
	    	input[i]=Integer.parseInt(br.readLine());
	    }
	   BillBoardProblem billBoard = new BillBoardProblem(); 
	   System.out.println(billBoard.getMaxProfit(input, k));
  }
}
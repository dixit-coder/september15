package com.divesh.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();

			String[] NK = s.split(" ");
			int N = Integer.parseInt(NK[0]);
			int k = Integer.parseInt(NK[1]);
			int arr[] = new int[N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				arr[i] = Integer.parseInt(str);
			}


			Solution solution = new Solution(N);
//			solution.getMaxProfit(arr, 0, arr.length-1, k);
//			System.out.println(solution.profit[0][arr.length-1]);
			System.out.println(solution.getMaxProfit1(arr, 0, arr.length-1, k));
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public long profit[][];

	public long[][] getProfit() {
		return profit;
	}

	public Solution(int arrayLenght) {
		profit = new long[arrayLenght][arrayLenght];
		for(int i = 0;i<arrayLenght;i++)
		{
			for (int j=0;j<arrayLenght;j++)
			{
				profit[i][j]=-1;
			}
		}
	}
	
	private long getMaxProfit(int[] arr, int start, int end, int k){
	    if(! (start<=end))
	         return 0;
	    
	    int len = end - start + 1;
		if (len <= k) {
			if (profit[start][end] != -1) {
				return profit[start][end];
			} else {
				return profit[start][end] = sum(arr, start, end);
			}
		}
	    long maxVal = 0;
	    
		for (int i = start + 1; i <= end - 1; i++) {
			long v1, v2;
			if (profit[start][i - 1] != -1) {
				v1 = profit[start][i - 1];
			} else {
				v1 = getMaxProfit(arr, start, i - 1, k);
			}

			if (profit[i + 1][end] != -1) {
				v2 = profit[i + 1][end];
			} else {
				v2 = getMaxProfit(arr, i + 1, end, k);
			}

			maxVal = Math.max(maxVal, v1 + v2);
		}
	   return profit[start][end] = maxVal;
	}

	private long getMaxProfit1(int[] arr, int start, int end, int k){
	    
		//profit[arr.length-1][arr.length-1]=arr[end];
		for(int i = arr.length-1;i>=0;i--)
		{
			for (int j=i;j<arr.length;j++)
			{
				if(i==j)
					profit[i][j]=arr[i];
				else if( j-i + 1 <=k)
					 profit[i][j]= sum(arr, i, j);
				 else
				 {   long maxVal=0;
					 for(int x=i;x<=j-1;x++){
						 if(x==0)
						 {
							 maxVal= Math.max(0, profit[x+1][j]);
						 }
						 else
						 maxVal= Math.max(profit[i][x-1], profit[x+1][j]);
					 }
					 profit[i][j]=maxVal;
				 }
			}
		}
	  return profit[0][arr.length-1];
	}
	
	private long sum(int[] a, int start, int end){
	    long retVal = 0;
	    for(int i=start;i<=end;i++)
	        retVal += a[i];
	    return retVal;
	} 
}

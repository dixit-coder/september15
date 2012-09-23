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
			int N =  Integer.parseInt(NK[0]);
			int k = Integer.parseInt(NK[1]);
			int arr[] = new int[N];

			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				arr[i] = Integer.parseInt(str);
			}
			
			// All logic in the BillBoard class
			int profit[];
			BillBoardProblem problem = new BillBoardProblem();
			profit = problem.preProcessArray(arr, k);
			problem.getMxIndexAndUpdateAnswer(profit, 0, profit.length - 1, k);
			
			System.out.println(problem.getAnswer());
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

}
 class BillBoardProblem {

	public int[] preProcessArray(int arr[], int k) {
		int len = arr.length, sum = 0;
		int[] profit = new int[len];
		for (int i = 0; i < k - 1; i++) {
			profit[i] = Integer.MIN_VALUE;
			sum += arr[i];
		}
		profit[k - 1] = sum + arr[k - 1];
		for (int i = k; i < len; i++) {
			profit[i] = profit[i - 1] + (arr[i] - arr[i - k]);
		}
		return profit;
	}

	private int answer = 0;

	public int getAnswer() {
		return answer;
	}

	public void getMxIndexAndUpdateAnswer(int profit[], int left, int right,
			int k) {
		if (left < 0)
			return;
		if (right >= profit.length)
			return;
		if (right - left + 1 < k)
			return;
		int max = Integer.MIN_VALUE;
		int max_index = -1;
		for (int i = left; i <= right; i++) {
			if (max < profit[i]) {
				max = profit[i];
				max_index = i;
			}
		}
		answer += max;
		getMxIndexAndUpdateAnswer(profit, left, max_index - k - 1, k);
		getMxIndexAndUpdateAnswer(profit, max_index + 2, right, k);
	}
}

package com.divesh.amazon;

public class BillBoardProblem1 {

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

	public static void main(String args[]) {
		BillBoardProblem1 problem = new BillBoardProblem1();
		int arr[] =  { 1, 2, 3, 1, 6, 10 }; //{ 6, 8, 9, 10, 11, 1, 3, 9, 4 };
		int profit[];
		int k = 2;
		profit = problem.preProcessArray(arr, k);
		problem.getMxIndexAndUpdateAnswer(profit, 0, profit.length - 1, k);
		System.out.println(problem.getAnswer());
	}
}

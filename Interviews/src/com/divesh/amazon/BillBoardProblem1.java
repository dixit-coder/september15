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

	/** Actual working code == not working in second attempt*/
	public long maxProfitFromBillBords(int arr[], int k) {
		// include array ==> inc[i] = maximum profit we can achieve up till i,by
		// including arr[i] where 0<=i<arr.length
		long inc[] = new long[arr.length];
		// include array ==> exc[i] = maximum profit we can achieve up till i,by
		// excluding arr[i] where 0<=i<arr.length
		long exc[] = new long[arr.length];

		int curr;
		// base condition only one element in arr, i.e arr[0];
		// there for inc[0]=arr[0]; and exc[0]=0;
		inc[0] = arr[0];
		exc[0] = 0;

		// loop till window size is less than k
		for (curr = 1; curr < k; curr++) {
			// include in current element
			inc[curr] = inc[curr - 1] + arr[curr];
			// excluding current element
			exc[curr] = inc[curr - 1];
		}

		// check if curr index is equal to the length of array.
		if (curr >= arr.length)
			return inc[curr - 1];

		// boundary case when curr = k+1
		inc[k] = inc[k - 1] - arr[0] - 0 + arr[k] + exc[0];
		exc[k] = inc[k - 1];

		// loop from k+1 to arr.lenght -1

		for (curr = k + 1; curr < arr.length; curr++) {
			// inc[i] = sum of the window size k, ending at i + maximum profit
			// by excluding i-k th element
			// this will be exc[i-k]
			inc[curr] = inc[curr - 1] - arr[curr - k] - exc[curr - k - 1]
					+ arr[curr] + exc[curr - k];
			//  exc[curr-1]+arr[curr]
			// excluding current element maximum profit will be max. profit
			// including curr-1 element
			exc[curr] = Math.max(inc[curr - 1], exc[curr - 1]);
		}
		// return max profit either including last element or excluding last
		// element, which ever is maximum
		return Math.max(inc[arr.length - 1], exc[arr.length - 1]);
	}

	long getMaxProfit(int[] arr, int start, int end, int k){
	    if(! (start<=end))
	        return 0;
	        
	    int len = end - start + 1;
	    if(len <= k)
	        return sum(arr,start,end);
	        
	    long maxVal = 0;
	    
	    for(int i=start;i<=end;i++){
	        long val1 = getMaxProfit(arr,start,i-1,k);
	        long val2 = getMaxProfit(arr,i+1,end,k);
	        
	        maxVal = Math.max(maxVal,val1+val2);
	    }

	    return maxVal;
	}


	long sum(int[] a, int start, int end){
	    long retVal = 0;
	    for(int i=start;i<=end;i++)
	        retVal += a[i];
	    return retVal;
	} 
	
	public static void main(String args[]) {
		BillBoardProblem1 problem = new BillBoardProblem1();
		int arr[] = { 1, 2, 3, 1, 6,10}; //new int[100000//new int[100000];//{0,  0, 0, 0, 0, 0};//{ 6, 8, 9, 10, 11, 1, 3, 9, 4 }; //{ 1, 2, 3, 1, 6 }; //
//		for(int i=0;i<100000;i++)
//		{
//			arr[i]=2000000000;
//		}
		int profit[];
		int k = 2;// 6;
//		profit = problem.preProcessArray(arr, k);
//		problem.getMxIndexAndUpdateAnswer(profit, 0, profit.length - 1, k);
//		System.out.println("Solution by incorrect aproach: "
//				+ problem.getAnswer());
//		System.out.println("Solution by correct aproach: "
//				+ problem.maxProfitFromBillBords(arr, k));
        System.out.println(problem.getMaxProfit(arr, 0, arr.length-1, k));
	}
}

package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class OneSideNegOtherPostive {
	private int start, end, current;

	public void getOrderedArray(int b[]) {
		start = 0;
		end = b.length - 1;
		while (b[start] < 0)
			start++;
		while (b[end] >= 0)
			end--;
		int n = start, p = end;
		current = n;
	while (current < end) {
			while (b[current] < 0 &&  (current < end)) {
				current++;
				continue;
			}
			ArrayUtils.swap(b, current, end);
			ArrayUtils.printArray(b, " \n b at current " + current + " end "
					+ end + "==>");
			current--;
			end--;
			if (current < 0)
				current = 0;
		}

		ArrayUtils.swapWithIn(b, n, p);
	}

	public static void main(String args[]) {
		OneSideNegOtherPostive oNegOtherPostive = new OneSideNegOtherPostive();
		//int a[] = { -1, 5, 3, -8, 4, -6, 9 };
		int a[] = {1,-1,2};
		ArrayUtils.printArray(a, "Input array ");
		oNegOtherPostive.getOrderedArray(a);
		ArrayUtils.printArray(a, "\nOutput array ");
	}
}

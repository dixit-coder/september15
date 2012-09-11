package com.divesh.core;

import java.util.Stack;

import com.divesh.util.ArrayUtils;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] height) {

		int maxArea = 0, len = height.length;
		for (int j = len; j > 0; j--) {

			for (int i = 0; i + j <= len; i++) {
				int area = getMin(height, i, j + i) * j;
				if (maxArea < area)
					maxArea = area;
			}
		}
		return maxArea;
	}

	private int getMin(int[] height, int i, int j) {
		int min = Integer.MAX_VALUE;
		for (int var = i; var < j; var++) {
			if (min > height[var])
				min = height[var];
		}
		return min;
	}

	/** order of n solution using stacks */
	public int largestRectangleArea1(int[] height) {
		Stack<StackNode> stack = new Stack<StackNode>();
		// initialising the left array and right array having count of bars of
		// height more than h(i) in left and right respectively.
		int left[] = new int[height.length];

		int right[] = new int[height.length];
		// left L
		stack.push(new StackNode(height[0], 0));
		left[0] = 0;

		for (int var = 1; var < height.length; var++) {

			int count = 0;

			while (!stack.isEmpty()) {
				if (stack.peek().curr <= height[var]) {
					stack.push(new StackNode(height[var], count));
					left[var] = count;
					break;
				} else {
					count = count + stack.peek().countLR + 1;
					stack.pop();
					left[var] = count;

				}

			}
		}

		stack.removeAllElements();
		//ArrayUtils.printArray(left, "\nLeft==>");
		// right R
		stack.push(new StackNode(height[height.length - 1], 0));
		right[height.length - 1] = 0;
		for (int var = height.length - 2; var >= 0; var--) {

			int count = 0;

			while (!stack.isEmpty()) {
				if (stack.peek().curr <= height[var]) {
					stack.push(new StackNode(height[var], count));
					right[var] = count;
					break;
				} else {
					count = count + stack.peek().countLR + 1;
					stack.pop();
					right[var] = count;

				}

			}
		}

		//ArrayUtils.printArray(right, "\nright==>");

		int maxArea = 0;
		for (int k = 0; k < height.length; k++) {
			int area = (1 + left[k] + right[k]) * height[k];
			if (area > maxArea)
				maxArea = area;

		}

		return maxArea;
	}

	public static void main(String args[]) {
		LargestRectangleInHistogram inHistogram = new LargestRectangleInHistogram();
		int[] height =new int[20000];  //{ 3, 6, 5, 7, 4, 8, 1 };
		 for (int i = 0; i <= 19999; i++)
		 height[i] = i;
		System.out.println(inHistogram.largestRectangleArea1(height));
	}
}

class StackNode {
	int curr;
	int countLR;

	public StackNode(int curr, int countLR) {
		this.curr = curr;
		this.countLR = countLR;
	}

	@Override
	public String toString() {
		return "{" + curr + "," + countLR + "}";
	}
}

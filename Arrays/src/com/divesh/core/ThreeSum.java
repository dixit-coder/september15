package com.divesh.core;

import java.util.ArrayList;

import java.util.HashSet;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		int x, p, q;
		java.util.Arrays.sort(num);

		HashSet<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();
		for (int k = 0; k < num.length; k++) {
			x = num[k];
			p = k + 1;
			q = num.length - 1;
			while (p < q) {
				if ((x + num[p] + num[q]) == 0) {
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(x);
					solution.add(num[p]);
					solution.add(num[q]);
					p++;
					q--;
					resultSet.add(solution);
					//System.out.println(solution);
				} else {
					if (x + num[p] + num[q] > 0)
						q--;
					else
						p++;
				}
			}

		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(
				resultSet);
		return result;
	}

	public static void main(String args[]) {
		//int[] num = { -1, 0, 1, 2, -1, -4 };
		int[] num = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		ThreeSum sum = new ThreeSum();
		for (ArrayList<Integer> list : sum.threeSum(num)) {
			System.out.println(list);
		}
	}
}

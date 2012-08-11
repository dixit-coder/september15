package com.divesh.core;

public class UnsortedMajorityElement {

	public int getMajorityElement(int arr[]) {
		int count = 1, candidate = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == candidate)
				count++;
			else
				count--;

			if (count == 0) {
				count = 1;
				candidate = arr[++i];
			}
		}
		if (count > 0) {
			int num = 0;
			for (int x : arr) {
				if (x == candidate)
					num++;
			}
			if (num >(arr.length / 2))
				return candidate;
		}
		return -1;
	}

	public static void main(String args[]) {
		int a[] = { 3, 3, 4, 2, 4, 4, 2, 4};
		UnsortedMajorityElement majorityElement = new UnsortedMajorityElement();
		System.out.println(majorityElement.getMajorityElement(a));
	}

}

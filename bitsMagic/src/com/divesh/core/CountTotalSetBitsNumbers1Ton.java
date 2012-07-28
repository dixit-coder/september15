package com.divesh.core;

import com.divesh.util.BitsUtil;

/**
 * Given a positive integer n, count the total number of set bits in binary
 * representation of all numbers from 1 to n.
 * 
 * Examples:
 * 
 * Input: n = 3 Output: 4
 * 
 * Input: n = 6 Output: 9
 * 
 * Input: n = 7 Output: 12
 * 
 * Input: n = 8 Output: 13
 */
public class CountTotalSetBitsNumbers1Ton {
	public int countSetBits(int n) {
		int sum = 0, num = n, i = 1;
		// varible i is for power
		while (num > 0) {

			double x = 0;
			if (((n+1) % (int)(Math.pow(2, i)) >= ((int)(Math.pow(2, i-1))))) {
				x = ((n+1) % (int)(Math.pow(2, i)) - ((int)(Math.pow(2, i-1))));
				//System.out.println("i= "+i + " x=" +x);
			}
			sum += ((n+1) / (int)(Math.pow(2, i))) * ((int)Math.pow(2, i-1)) + x;
			i++;
			num >>= 1;
		}

		return sum;
	}

	public static void main(String args[]) {
		CountTotalSetBitsNumbers1Ton totalSetBitsNumbers1Ton = new CountTotalSetBitsNumbers1Ton();
		System.out.println(totalSetBitsNumbers1Ton.countSetBits(17));
	}
}

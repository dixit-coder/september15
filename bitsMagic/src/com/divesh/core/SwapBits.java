package com.divesh.core;

import com.divesh.util.BitsUtil;

/**
 * Given a number x and two positions (from right side) in binary representation
 * of x, write a function that swaps n bits at given two positions and returns
 * the result. It is also given that the two sets of bits do not overlap.
 * 
 * Examples:
 * 
 * Let p1 and p2 be the two given positions.
 * 
 * Example 1 Input: x = 47 (00101111) p1 = 1 (Start from second bit from right
 * side) p2 = 5 (Start from 6th bit from right side) n = 3 (No of bits to be
 * swapped) Output: 227 (11100011) The 3 bits starting from the second bit (from
 * right side) are swapped with 3 bits starting from 6th position (from right
 * side)
 */
public class SwapBits {
	public static int swapBits(int number, int p1, int p2, int n) {
		int xor = ((number >> p1) & ((1 << n) - 1))
				^ ((number >> p2) & ((1 << n) - 1));
		/*BitsUtil.getBitsPrint("xor ", xor);
		BitsUtil.getBitsPrint("xor << p1 ", (xor << p1));
		BitsUtil.getBitsPrint("xor << p2 ", (xor << p2));*/
		xor = (xor << p1) | (xor << p2);
		/*BitsUtil.getBitsPrint("xor ", xor);
		BitsUtil.getBitsPrint("num ", number);
		BitsUtil.getBitsPrint("ans ", number ^ xor);*/

		return number ^ xor;
	}

	public static void main(String args[]) {

		int res = swapBits(47, 1, 5, 3);
		System.out.println("\nResult =" + res);

	}
}

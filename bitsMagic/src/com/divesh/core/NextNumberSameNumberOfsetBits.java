package com.divesh.core;

import com.divesh.util.BitsUtil;

/**
 * Given a number x, find next number with same number of 1 bits in it’s binary
 * representation.
 * 
 * For example, consider x = 12, whose binary representation is 1100 (excluding
 * leading zeros on 32 bit machine). It contains two logic 1 bits. The next
 * higher number with two logic 1 bits is 17 (100012)
 */
public class NextNumberSameNumberOfsetBits {
	public int nextHigherNumber(int n) {
		// BitsUtil.printBits("", n);
		int count = 0, right = 0;
		while (n > 0 && !((n & 1) == 1 && (((n >> 1) & 1) == 0))) {
			if ((n & 1) == 1)
				count++;
			right++;
			n >>= 1;
		}
		n = (n >> 1) | 1;
		n <<= 1;
		if (count == 0) {
			while (right > 0)
				n <<= 1;
		} else {
			int x = 1;
			while (right != count) {
				n <<= 1;
				right--;
			}
			while (count > 1) {
				x = x | (x << 1);
				count--;

			}
			while (right > 0) {
				n <<= 1;
				right--;
			}
			n |= x;
		}
		return n;
	}

	public int nextSmallerNumber(int n) {
		int count = 0, right = 0, num = n;
		while (n > 0 && !((n & 1) == 0 && (((n >> 1) & 1) == 1))) {
			right++;
			if ((n & 1) == 1)
				count++;
			n >>= 1;

		}
		if (n != 0) {
			n >>= 2;
			n <<= 1;
			n = n << 1 | 1;
		}
		else {
			n =num;right =0;count=0;
		}
		while (count > 0) {
			n = n << 1 | 1;
			count--;
			right--;
		}
		while (right > 0) {
			right--;
			n <<= 1;
		}
		return n;
	}

	public static void main(String args[]) {
		NextNumberSameNumberOfsetBits nextOfsetBits = new NextNumberSameNumberOfsetBits();
		//System.out.println(nextOfsetBits.nextHigherNumber(7));
		System.out.println(nextOfsetBits.nextSmallerNumber(10));
	}
}

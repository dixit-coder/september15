package com.divesh.util;

public class BitsUtil {

	public static void printBits(String msg, int x) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < 4 * 8; i++) {
			str.append(x & 1);
			x >>= 1;

		}

		System.out.println(msg + str.reverse());
		System.out.println();
	}

	/**
	 * IP 5 OP 8
	 * 
	 * IP 17 OP 32
	 */
	public static int nextPowerOf2(int n) {
		if ((n & (n - 1)) == 0) {
			return n;
		} else {
			int p = 1;
			while (p < n) {
				p <<= 1;
			}
			return p;
		}
	}

	public static int reverseBitsOfNumber(int num) {
		int count = 4 * 8;
		int rev = num;
		while (num > 0) {
			rev <<= 1;
			rev = rev | (num & 1);
			num >>= 1;
			count--;

		}
		rev <<= count;
		return rev;
	}

	public static void main(String args[]) {
		// getBitsPrint("msg", 128);
		// System.out.println(nextPowerOf2(17));
		BitsUtil.printBits("", 14);
		BitsUtil.printBits("", reverseBitsOfNumber(14));

	}

}

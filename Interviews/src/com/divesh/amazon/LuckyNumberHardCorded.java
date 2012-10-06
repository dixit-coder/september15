package com.divesh.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LuckyNumberHardCorded {
	public int[] primeNoSet;

	public LuckyNumberHardCorded() {
		super();
		int arr[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
				53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
				113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,
				251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
				317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389,
				397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461,
				463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547,
				557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617,
				619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
				701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773,
				787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859,
				863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
				953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021,
				1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091,
				1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163,
				1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231,
				1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301,
				1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399,
				1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453 };
		primeNoSet = new int[730 * 2 + 1];
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			primeNoSet[arr[i]] = 1;
		}
	}

	public int getCountOfLuckyNumber(long A, long B) {
   
		// answer, count of number are lucky in between A and B inclusive
		int count;
		long i=-1;
		int digiSum=0,sqDigiSum=0;
		try {
			count = 0;

			for ( i = A; i <= B; i++) {
				 digiSum = 0;sqDigiSum = 0;
				long n = i;
				while (n > 0) {
					byte lastDigit = (byte) (n % 10);

					digiSum += lastDigit;
					sqDigiSum = sqDigiSum + (lastDigit * lastDigit);

					n /= 10;
				}
				if (primeNoSet[digiSum] == 1 && primeNoSet[sqDigiSum] == 1) {
					count++;
				}
			}
			return count;
		} catch (Exception e) {
			System.out.println("i="+ i);
			System.out.println("digi="+ digiSum);
			System.out.println("sqDigi="+ sqDigiSum);
			e.printStackTrace();
			return -1;
		}
		
	}

}

class Solution23 {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();

			int N = Integer.parseInt(s);

			long arr[][] = new long[N][2];

			for (int i = 0; i < N; i++) {
				String str[] = br.readLine().split(" ");
				arr[i][0] = Long.parseLong(str[0]);
				arr[i][1] = Long.parseLong(str[1]);

			}
			LuckyNumberHardCorded luckycount = new LuckyNumberHardCorded();
			for (int i = 0; i < N; i++) {
				System.out.println(luckycount.getCountOfLuckyNumber(arr[i][0],
						arr[i][1]));
			}

			// All logic in the maxProfitFromBillBords function

		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

}

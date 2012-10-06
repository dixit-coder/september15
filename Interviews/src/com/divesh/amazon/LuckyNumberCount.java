package com.divesh.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class LuckyNumberCount {

	/**
	 * primeNoSet={2}; for(int i=3;i<=9*9*9;i++) // find all the prime in the
	 * given range if(i%2==0) continue; for(int j = 2;j< root(i);j++) if(i%j==0)
	 * //out of the loop, not a prime number // is a prime number
	 * primeNoSet.add(i);
	 * 
	 * 
	 * count=0 // answer, count of number are lucky in between A and B inclusive
	 * for N from A to B while(N>0)
	 * 
	 * digiSum+= N%10; sqDigiSum+= math.Sq(N%10); N/=10;
	 * 
	 * return count
	 */
	private Set<Integer> primeSet;

	public LuckyNumberCount() {
		super();
		this.primeSet = new TreeSet<Integer>();
		primeSet.add(2);
		this.setAllPrimeNumberInRange(9 * 9 * 9);
	}

	private void setAllPrimeNumberInRange(int range) {
		for (int i = 3; i <= range; i+=2) {
			// find all the prime in the given range
			if (i % 2 == 0)
				continue;
			boolean isPrime = true;
			for (int j = 3; j*j <=i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			// out of the loop, not a prime number
			if (isPrime) {
				// is a prime number
				primeSet.add(i);
			}
		}

	}

	public int getCountOfLuckyNumber(long A, long B) {

		// answer, count of number are lucky in between A and B inclusive
		int count = 0;

		for (long i = A; i <= B; i++) {
			int digiSum = 0, sqDigiSum = 0;
			long n = i;
			while (n > 0) {
				int lastDigit = (int) n % 10;
				
				digiSum += lastDigit;
				sqDigiSum = sqDigiSum + (lastDigit * lastDigit);
				
				n /= 10;
			}
			if (primeSet.contains(digiSum) && primeSet.contains(sqDigiSum)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String args[]) {
		LuckyNumberCount luckycount = new LuckyNumberCount();
		luckycount.setAllPrimeNumberInRange(9*9*9*2);
		System.out.println(luckycount.primeSet);
	}
}

class Solution22 {
	public static void main1(String args[]) {
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
			LuckyNumberCount luckycount = new LuckyNumberCount();
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

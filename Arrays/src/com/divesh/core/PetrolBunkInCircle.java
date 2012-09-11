package com.divesh.core;

public class PetrolBunkInCircle {
	public static int findStartingNode(int[] D, int[] P) {
		int Dlen = D.length;
		int Plen = P.length;
		int petrol, start, end, tmp;
		for (int i = 0; i < Plen; i++) {
			petrol = 0;
			start = i;
			end = (i == Plen ? 0 : i + 1);
			boolean curcuit = true;
			tmp = i;
			while (end != i) {
				petrol += P[tmp];
				if (D[tmp] <= petrol) {
					petrol -= D[tmp];
					start = end;
					end = (end + 1 == Plen ? 0 : end + 1);
					tmp = (tmp + 1 == Plen ? 0 : tmp + 1);
				} else {
					curcuit = false;
					break;
				}
			}
			if (curcuit)
				return i;

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] D = { 1, 3, 2, 1, 3, 5 };
		int[] P = { 1, 2, 4, 3, 3, 2 };

		// int [] D = {4, 8, 5, 4, 1, 6, 2, 2};
		// int [] P = {3, 8, 7, 3, 5, 3, 2, 2};

		// int[] D = { 4, 7, 4, 8, 4, 1 };
		// int[] P = { 3, 5, 3, 8, 3, 6 };

		System.out.println("Start index: " + findStartingNode(D, P));
	}
}

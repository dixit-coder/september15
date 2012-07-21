package com.divesh.core;

import java.util.HashMap;

public class SmallestSubString {
	private HashMap<Character, Integer> Tmap = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> TmapOrignal;
	private int min_length = Integer.MAX_VALUE;

	public int getSmallestSubString(char[] S, char[] T) {

		// making two hash map tmap , tmapOriginal for T
		for (int i = 0; i < T.length; i++) {
			if (Tmap.get(T[i]) != null) {
				Tmap.put(T[i], (Tmap.get(T[i])) + 1);

			} else
				Tmap.put(T[i], 1);
		}
		TmapOrignal = new HashMap<Character, Integer>(Tmap);

		//

		int start = 0, toBeFindlen = T.length;
		boolean startflag = true;
		for (int i = 0; i < S.length; i++) {

			while (TmapOrignal.get(S[start]) == null && start < S.length)
				start++;
			if (startflag) {
				Tmap.put(S[start], Tmap.get(S[start]) - 1);
				toBeFindlen--;
				while (toBeFindlen > 0 && i < S.length) {
					i++;
					if (Tmap.get(S[i]) != null) {
						toBeFindlen--;
						if (Tmap.get(S[i]) > 0)
							Tmap.put(S[i], Tmap.get(S[i]) - 1);
					}

				}

				if (toBeFindlen == 0) {
					if (min_length > i - start)
						min_length = i - start + 1;
					System.out.println("start:" + start + " end:" + i);

					Tmap.put(S[start], Tmap.get(S[start]) + 1);
					start++;
					toBeFindlen = 1;

				}
				startflag = false;
				continue;

			}

			while ((i < S.length && Tmap.get(S[i]) == null)
					|| (Tmap.get(S[i]) != null && (Tmap.get(S[i]) == 0))) {
				i++;
			}

			if (toBeFindlen > 0 && i < S.length) {
				if (Tmap.get(S[i]) != null) {
					toBeFindlen--;
					if (Tmap.get(S[i]) > 0)
						Tmap.put(S[i], Tmap.get(S[i]) - 1);
				}
			}
			// at this point Tmap should have all value for all keys as zero.
			if (toBeFindlen == 0) {
				if (min_length > i - start)
					min_length = i - start + 1;
				System.out.println("start:" + start + " end:" + i);

				Tmap.put(S[start], Tmap.get(S[start]) + 1);
				start++;
				toBeFindlen = 1;

			}

		}
		return min_length;
	}

	public boolean minWindow(char[] S, char[] T, int minWindowBegin,
			int minWindowEnd) {
		int sLen = S.length;
		int tLen = T.length;
		int[] needToFind = new int[256];

		for (int i = 0; i < tLen; i++)
			needToFind[T[i]]++;
		int hasFound[] = new int[256];
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[S[end]] == 0)
				continue;
			hasFound[S[end]]++;

			if (hasFound[S[end]] <= needToFind[S[end]])
				count++;
			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind[S[begin]] == 0
						|| hasFound[S[begin]] > needToFind[S[begin]]) {
					if (hasFound[S[begin]] > needToFind[S[begin]])
						hasFound[S[begin]]--;
					begin++;
				}
				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
					System.out.println("minWindowLen==>"+minWindowLen);
				}
			}
		}

		return (count == tLen) ? true : false;
	}

	public static void main(String args[]) {
		SmallestSubString subString = new SmallestSubString();
		char[] S = "ADOBECODEBANC".toCharArray();
		char[] T = "ABC".toCharArray();
		//System.out.println(subString.getSmallestSubString(S, T));
		System.out.println(subString.minWindow(S, T, 0, S.length));
	}
}

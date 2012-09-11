package com.divesh.amazon;

import java.util.HashSet;
import java.util.Set;

public class LinkedListVovels {

	public CharNode getSepratedVovelAndConsonants(CharNode Head) {
		char volwel[] = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I',
				'O', 'U' };
		Set<Character> set = new HashSet<Character>();
		for (Character character : volwel) {
			set.add(character);
		}
		CharNode curr = Head, vol = null, volLast = null, cons = null, consLast = null;

		while (curr != null) {
			CharNode tmp = curr;
			curr = curr.nxt;
			if (set.contains(tmp.data)) {
				if (vol == null) {
					vol = volLast = tmp;
					tmp.nxt = null;
				} else {
					volLast.nxt = tmp;
					tmp.nxt = null;
					volLast = tmp;
				}
			} else {
				if (cons == null) {
					cons = consLast = tmp;
					tmp.nxt = null;
				} else {
					consLast.nxt = tmp;
					tmp.nxt = null;
					consLast = tmp;
				}
			}
		}
		if (volLast != null) {
			volLast.nxt = cons;
			return vol;
		} else {
			return cons;
		}
	}

	public static void main(String args[]) {
		LinkedListVovels listVovels = new LinkedListVovels();
		//CharNode HEAD = Utils.getCharLinkedList("AMAZON".toCharArray());
		CharNode HEAD = Utils.getCharLinkedList("KPYTRWQ".toCharArray());
		Utils.printCharLinkedList(HEAD);
		Utils.printCharLinkedList(listVovels
				.getSepratedVovelAndConsonants(HEAD));
		listVovels.getSepratedVovelAndConsonants(HEAD);

	}

}

class Utils {
	public static CharNode getCharLinkedList(char[] arr) {
		CharNode head = null, last = null;
		for (char c : arr) {
			if (head == null) {
				head = new CharNode(c);
				last = head;

			} else {
				last.nxt = new CharNode(c);
				last = last.nxt;
			}
		}
		return head;
	}

	public static void printCharLinkedList(CharNode Head) {
		CharNode curr = Head;
		System.out.println();
		while (curr != null) {
			System.out.print(" " + curr.data);
			curr = curr.nxt;
		}
	}
}

class CharNode {
	CharNode nxt;
	char data;

	CharNode(char data) {
		nxt = null;
		this.data = data;
	}
}

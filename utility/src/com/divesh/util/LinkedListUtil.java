package com.divesh.util;

public class LinkedListUtil {
	public static Node getLinkedList(int arr[]) {
		Node HEAD = null, tmp = null;
		if (arr != null && arr.length > 0) {
			tmp = HEAD = new Node(arr[0]);
		}
		for (int i = 1; i < arr.length; i++) {
			tmp.nxt = new Node(arr[i]);
			tmp = tmp.nxt;

		}
		return HEAD;
	}

	public static void printLinkedList(Node head) {
		/*
		 * if (head == null) return; System.out.print(" " + head.data);
		 * printLinkedList(head.nxt);
		 */

		while (head != null) {
			System.out.print(" " + head.data);
			head = head.nxt;

		}
		System.out.println();
	}

	public static Node reverseLinkedList(Node head, Node newHead) {

		if (head == null)
			return newHead;
		Node tmp = head;
		head = head.nxt;
		tmp.nxt = newHead;
		newHead = tmp;
		return reverseLinkedList(head, newHead);
	}

	/** iterative implementation */
	public static boolean isListPalindrom(Node head) {
		Node slow = head, fast = head;
		while (fast.nxt != null && fast.nxt.nxt != null) {
			slow = slow.nxt;
			fast = fast.nxt.nxt;
		}
		printLinkedList(head);
		slow.nxt = reverseLinkedList(slow.nxt, null);
		printLinkedList(head);
		Node start = head;
		slow = slow.nxt;
		while (slow != null) {
			if (slow.data != start.data)
				return false;
			slow = slow.nxt;
			start = start.nxt;
		}
		return true;
	}

	/** recursive implementation */
	public static boolean isListPalindrom1(Node head) {
		if (head == null)
			return true;
		Node rest = head.nxt;
		return false;
	}

	public static Node getMidOfLinkedList(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.nxt != null) {
			slow = slow.nxt;
			fast = fast.nxt.nxt;
		}
		return slow;

	}

	/** reversing linked list alternatively on consecutive intervals of k */
	public static Node reverseLinkedListK(Node HEAD, int k) {

		int count;
		Node current = HEAD;
		Node node = HEAD;
		HEAD = null;
		Node pev = null;
		// liner traverse loop
		while (current != null) {
			node = current;
			count = k;
			while (current != null && count > 0) {
				current = current.nxt;
				count--;
			}
			// reverse linkedList from node to current-1 and assign its value in

			Node tmp = reverseLinkedList(node, current, current);
			if (pev == null)
				HEAD = tmp;
			else
				pev.nxt = tmp;
			// simply liner skip of next k elements
			count = k;
			while (current != null && count > 0) {
				pev = current;
				current = current.nxt;
				count--;
			}
		}
		return HEAD;

	}

	/**reversing the linked list  with some end pointer not null5*/
	public static Node reverseLinkedList(Node node, Node pCurrent, Node current) {
		if (node == current) {
			return pCurrent;
		}
		Node tmp = node;
		node = node.nxt;
		tmp.nxt = pCurrent;
		pCurrent = tmp;
		return reverseLinkedList(node, pCurrent, current);
	}
	

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		Node HEAD = getLinkedList(arr);
		/*
		 * printLinkedList(HEAD); System.out.println(); Node revHEAD =
		 * reverseLinkedList(HEAD, null); printLinkedList(revHEAD);
		 */
		// System.out.println(isListPalindrom(HEAD));
		//printLinkedList(HEAD);
		//printLinkedList(reverseLinkedListK(HEAD, 10));
		
		

	}
}

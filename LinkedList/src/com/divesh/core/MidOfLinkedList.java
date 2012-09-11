package com.divesh.core;

import com.divesh.util.LinkedListUtil;
import com.divesh.util.Node;

public class MidOfLinkedList {
	/** Get the middle element of the linked list */
	public int getMidOfLinkedList(Node HEAD) {
		Node slow = HEAD, fast = HEAD;
		while (fast != null && fast.nxt != null) {
			slow = slow.nxt;
			fast = fast.nxt.nxt;

		}
		return slow.data;
	}

	public static void main(String args[]) {
		MidOfLinkedList list = new MidOfLinkedList();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Node Head = LinkedListUtil.getLinkedList(arr);
		System.out.println(list.getMidOfLinkedList(Head));
	}
}

package com.divesh.core;

public class IsNumberLucky {
	Node current;

	boolean isLucky(int x) {
		Node head = getLinkedList(x);
		trimLinkedList(head, x);

		current = head;
		while (current != null) {
			if (current.data == x)
				return true;
			current = current.nxt;
		}
		return false;
	}

	private void trimLinkedList(Node head, int x) {
		int i = 0, jump = i + 1;
		Node tmp, current;
		while (jump < sizeOf(head)) {
			current = head;
			while (current != null && current.nxt != null) {
				tmp = current;
				while (jump > 0) {
					tmp = tmp.nxt;
					if (tmp == null)
						break;
					jump--;
				}
				while (current.nxt != tmp)
					current = current.nxt;
				if (current != null && tmp != null) {
					current.nxt = tmp.nxt;
					current = current.nxt;
				}
				jump = i + 1;
			}
			Node printTmp = head;
			System.out.print("after jump=" + jump + "::");
			while (printTmp != null) {
				System.out.print(" " + printTmp.data);
				printTmp = printTmp.nxt;
			}
			System.out.println();
			i++;
			jump = i + 1;

		}

	}

	private int sizeOf(Node head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.nxt;

		}
		return size;
	}

	private Node getLinkedList(int x) {
		Node head = null, tmp = null;
		int count = 1;
		while (count <= x) {
			count++;
			if (head == null) {
				head = new Node(count - 1);
				tmp = head;
				continue;
			}
			tmp.nxt = new Node(count - 1);
			tmp = tmp.nxt;

		}
		return head;
	}

	public static void main(String args[]) {
		IsNumberLucky numberLucky = new IsNumberLucky();
		//System.out.println(numberLucky.isLucky(Integer.parseInt(args[0])));
		for(int i=1;i<200;i++)
		{
			if(numberLucky._isLucky(i))
				System.out.print(" "+i);
		}
	}
	
	public boolean _isLucky(int x) {
		int count = 2, pos = x;
		while (count <=pos) {
			if (pos % count == 0)
				return false;
			pos = pos - pos / count;
			count++;
		}
		return true;
	}
}

class Node {
	public int data;
	public Node nxt;

	public Node(int data) {
		this.data = data;
		this.nxt = null;
	}

	public void getNodedata(Node node) {
		System.out.println("data==>" + data);
	}

}

package com.divesh.util;

public class Node {
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

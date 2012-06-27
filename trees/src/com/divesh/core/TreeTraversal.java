package com.divesh.core;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
	public static void inOrderTraversal(Node node) {
		if (node == null)
			return;
		inOrderTraversal(node.lchild);
		System.out.print(" " + node.data);
		inOrderTraversal(node.rchild);
	}

	public static void preOrderTraversal(Node node) {
		if (node == null)
			return;
		System.out.print(" " + node.data);
		preOrderTraversal(node.lchild);
		preOrderTraversal(node.rchild);
	}

	public static void postOrderTraversal(Node node) {
		if (node == null)
			return;
		postOrderTraversal(node.lchild);
		postOrderTraversal(node.rchild);
		System.out.print(" " + node.data);
	}

	public static void levelOrderTraversal(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		Node temp_node = node;
		while (temp_node != null) {
			System.out.print(" " + temp_node.data);
			queue.add(temp_node.lchild);
			queue.add(temp_node.rchild);
			temp_node = queue.remove();

		}

	}

}

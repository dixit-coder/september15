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
		queue.add(temp_node);
		/*while (temp_node != null) {
			System.out.print(" " + temp_node.data);
			queue.add(temp_node.lchild);
			queue.add(temp_node.rchild);
			temp_node = queue.remove();

		}*/
		while (queue.size()>0) {
			if(queue.peek()!=null){
			System.out.print(" " + queue.peek().data);
			queue.add(queue.peek().lchild);
			queue.add(queue.peek().rchild);
			temp_node = queue.remove();
			}
			else
			  queue.remove();
		}

	}

	public static void levelOrderTraversal2(Node node) {
		int height = TreeSize.getTreeHeight(node);
		for (int i = 1; i <= height; i++) {
          printLevel(node, i);
		}
	}

	private static void printLevel(Node node, int k) {
		if (node == null)
			return;
		if (k == 1)
			{System.out.print(" " + node.data);
			 return;
			}
        printLevel(node.lchild, k-1);
        printLevel(node.rchild, k-1);
	}

}

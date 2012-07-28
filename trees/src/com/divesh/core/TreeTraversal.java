package com.divesh.core;

import java.util.LinkedList;
import java.util.Queue;

import com.divesh.util.Tnode;

public class TreeTraversal {
	public static void inOrderTraversal(Tnode node) {
		if (node == null)
			return;
		inOrderTraversal(node.lchild);
		System.out.print(" " + node.data);
		inOrderTraversal(node.rchild);
	}

	public static void preOrderTraversal(Tnode node) {
		if (node == null)
			return;
		System.out.print(" " + node.data);
		preOrderTraversal(node.lchild);
		preOrderTraversal(node.rchild);
	}

	public static void postOrderTraversal(Tnode node) {
		if (node == null)
			return;
		postOrderTraversal(node.lchild);
		postOrderTraversal(node.rchild);
		System.out.print(" " + node.data);
	}

	public static void levelOrderTraversal(Tnode node) {
		Queue<Tnode> queue = new LinkedList<Tnode>();
		Tnode temp_node = node;
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

	public static void levelOrderTraversal2(Tnode node) {
		int height = TreeSize.getTreeHeight(node);
		for (int i = 1; i <= height; i++) {
          printLevel(node, i);
		}
	}

	private static void printLevel(Tnode node, int k) {
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

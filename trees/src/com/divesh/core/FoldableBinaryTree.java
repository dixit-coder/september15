package com.divesh.core;

public class FoldableBinaryTree {
	private static Node temp = null;

	public static boolean isFoldable(Node node) {
		if (node == null)
			return true;
		Mirror(node.lchild);

		boolean b = isStructureSame(node.lchild, node.rchild);
		Mirror(node.rchild);
		return b;
	}

	public static boolean isStructureSame(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
			return false;
		}
		return isStructureSame(n1.lchild, n2.lchild)
				&& isStructureSame(n1.rchild, n2.rchild);
	}

	public static void Mirror(Node node) {
		if (node == null)
			return;
		Mirror(node.lchild);
		Mirror(node.rchild);
		temp = node.lchild;
		node.lchild = node.rchild;
		node.rchild = temp;

	}

	// main function to test the above function.
	public static void main(String args[]) {
		System.out.println("Isfoldable==>"
				+ FoldableBinaryTree.isFoldable(getBinaryTree()));
	}

	// Utility functions to draw the tree which is foldable
	public static Node getBinaryTree() {
		Node root = new Node(1);
		root.lchild = new Node(2);
		root.rchild = new Node(3);
		root.rchild.rchild = new Node(4);
		root.lchild.rchild = new Node(5);
		/*
		 * 1 2 3 5 4
		 */
		return root;
	}

}

package com.divesh.core;

import com.divesh.util.Tnode;

public class FoldableBinaryTree {
	private static Tnode temp = null;

	public static boolean isFoldable(Tnode node) {
		if (node == null)
			return true;
		Mirror(node.lchild);

		boolean b = isStructureSame(node.lchild, node.rchild);
		Mirror(node.rchild);
		return b;
	}

	public static boolean isStructureSame(Tnode n1, Tnode n2) {
		if (n1 == null && n2 == null)
			return true;
		if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
			return false;
		}
		return isStructureSame(n1.lchild, n2.lchild)
				&& isStructureSame(n1.rchild, n2.rchild);
	}

	public static void Mirror(Tnode node) {
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
	public static Tnode getBinaryTree() {
		Tnode root = new Tnode(1);
		root.lchild = new Tnode(2);
		root.rchild = new Tnode(3);
		root.rchild.rchild = new Tnode(4);
		root.lchild.rchild = new Tnode(5);
		/*
		 * 1 2 3 5 4
		 */
		return root;
	}

}

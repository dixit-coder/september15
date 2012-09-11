package com.divesh.util;

import java.util.ArrayList;
import java.util.List;

/** important revision quetion */
public class TreeFormation {
	public static Tnode getBinaryTree() {
		Tnode root = new Tnode(1);
		root.lchild = new Tnode(2);
		root.rchild = new Tnode(3);
		root.lchild.lchild = new Tnode(4);
		root.rchild.rchild = new Tnode(5);

		return root;
	}

	public static Tnode getBinaryTree2() {
		Tnode root = new Tnode(1);
		root.lchild = new Tnode(2);
		root.rchild = new Tnode(3);
		root.rchild.lchild = new Tnode(4);
		root.rchild.rchild = new Tnode(5);
		/*
		 * 1 2 3 4 5
		 */
		return root;
	}

	public static Tnode getBinaryTree3() {
		Tnode root = new Tnode(1);
		root.lchild = new Tnode(2);
		root.rchild = new Tnode(3);
		root.lchild.lchild = new Tnode(4);
		root.lchild.rchild = new Tnode(5);
		root.rchild.lchild = new Tnode(6);
		root.rchild.rchild = new Tnode(7);

		return root;
	}

	public Tnode getBinarySerchTree(List<Integer> list) {
		Tnode root = null;
		for (int num : list) {
			root = insertInBinaryTree(root, num);
		}
		return root;
	}

	/**
	 * Give a binary search tree and a number, inserts a new node with the given
	 * number in the correct place in the tree. Returns the new root pointer
	 * which the caller should then use (the standard trick to avoid using
	 * reference parameters).
	 */
	private Tnode insertInBinaryTree(Tnode node, int value) {
		/*
		 * 1. If the tree is empty, return a new, single node
		 */
		if (node == null) {
			node = new Tnode(value);
			return node;
		} else {
			/* 2. Otherwise, recur down the tree */
			if (node.data >= value) {
				node.lchild = insertInBinaryTree(node.lchild, value);
			} else {
				/* return the (unchanged) node pointer */
				node.rchild = insertInBinaryTree(node.rchild, value);
			}
			return node;
		}
	}

	public static Tnode getBinarySerchTree() {
		/**
		 * 4 2 6 1 3 5 9
		 * */
		TreeFormation formation = new TreeFormation();
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(9);

		return formation.getBinarySerchTree(list);

	}

	public static void main(String args[]) {
		TreeFormation formation = new TreeFormation();
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(9);
		//TreeTraversal.preOrderTraversal(formation.getBinarySerchTree(list));
	}

}

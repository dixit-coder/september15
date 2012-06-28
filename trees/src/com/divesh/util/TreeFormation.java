package com.divesh.util;

import java.util.ArrayList;
import java.util.List;

import com.divesh.core.Node;
import com.divesh.core.TreeTraversal;

/** important revision quetion */
public class TreeFormation {
	public static Node getBinaryTree() {
		Node root = new Node(1);
		root.lchild = new Node(2);
		root.rchild = new Node(3);
		root.lchild.lchild = new Node(4);
		root.lchild.rchild = new Node(5);

		return root;
	}

	public static Node getBinaryTree2() {
		Node root = new Node(1);
		root.lchild = new Node(2);
		root.rchild = new Node(3);
		root.rchild.lchild = new Node(4);
		root.rchild.rchild = new Node(5);
      /*    1
       *  2   3
       *     4  5
       *  */
		return root;
	}

	public static Node getBinaryTree3() {
		Node root = new Node(1);
		root.lchild = new Node(2);
		root.rchild = new Node(3);
		root.lchild.lchild = new Node(4);
		root.lchild.rchild = new Node(5);
		root.rchild.lchild = new Node(6);
		root.rchild.rchild = new Node(7);

		return root;
	}

	public Node getBinarySerchTree(List<Integer> list) {
		Node root = null;
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
	private Node insertInBinaryTree(Node node, int value) {
		/*
		 * 1. If the tree is empty, return a new, single node
		 */
		if (node == null) {
			node = new Node(value);
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
    public static Node getBinarySerchTree()
    {
    	/**     4
    	 *   2    6
    	 * 1  3  5  9
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
		TreeTraversal.preOrderTraversal(formation.getBinarySerchTree(list));
	}

}

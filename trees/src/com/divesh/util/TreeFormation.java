package com.divesh.util;

import java.util.List;

import com.divesh.core.Node;

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

		return root;
	}

	public static Node getBinarySerchTree(List<Integer> list) {
		Node root = null;
		for (int num : list) {
			Node node = new Node(num);
			if (root == null) {
				root = node;
			} else {
				Node current = root;
				Node parent = null;
				while (current != null) {
					parent = current;
					if (current.data >= num) {
						current = current.lchild;
					} else
						current = current.rchild;

				}
				if (parent.data > num)
					parent.lchild = node;
				else
					parent.rchild = node;
			}
		}
		return root;
	}
}

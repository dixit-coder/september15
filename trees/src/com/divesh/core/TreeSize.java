package com.divesh.core;

public class TreeSize {
	public static int getTreeSize(Node root) {
		if (root == null)
			return 0;
		else
			return (getTreeSize(root.lchild) + 1 + getTreeSize(root.rchild));
	}

	public static int getTreeHeight(Node node) {
		if (node == null) {
			return 0;
		} else
			return (1 + Math.max(getTreeHeight(node.lchild),
					getTreeHeight(node.rchild)));
	}
}

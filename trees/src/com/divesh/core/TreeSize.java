package com.divesh.core;

import com.divesh.util.Tnode;

public class TreeSize {
	public static int getTreeSize(Tnode root) {
		if (root == null)
			return 0;
		else
			return (getTreeSize(root.lchild) + 1 + getTreeSize(root.rchild));
	}

	public static int getTreeHeight(Tnode node) {
		if (node == null) {
			return 0;
		} else
			return (1 + Math.max(getTreeHeight(node.lchild),
					getTreeHeight(node.rchild)));
	}
}

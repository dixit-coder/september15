package com.divesh.core;

public class TreesIdentical {
	public static boolean sameTree(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		else if (node1 != null && node2 != null) {
			return (node1.data == node2.data)
					&& sameTree(node1.lchild, node2.lchild)
					&& sameTree(node1.rchild, node2.rchild);
		} else
			return false;
	}
}

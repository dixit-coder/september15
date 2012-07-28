package com.divesh.core;

import com.divesh.util.Tnode;

public class TreesIdentical {
	public static boolean sameTree(Tnode node1, Tnode node2) {
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

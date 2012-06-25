package com.divesh.core;

public class TreeTraversal {
	public void inOrderTraversal(Node node) {
        if(node==null)
        	return;
        inOrderTraversal(node.lchild);
        System.out.print(" "+node.data);
        inOrderTraversal(node.rchild);
	}
	

	public void preOrderTraversal(Node node) {
		if(node==null)
        	return;
		System.out.print(" "+node.data);
		preOrderTraversal(node.lchild);
        preOrderTraversal(node.rchild);
	};

	public void postOrderTraversal(Node node) {
		if(node==null)
        	return;
		postOrderTraversal(node.lchild);
        postOrderTraversal(node.rchild);
        System.out.print(" "+node.data);
	};
}

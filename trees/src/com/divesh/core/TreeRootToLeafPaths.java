package com.divesh.core;

import java.util.Stack;

import com.divesh.util.TreeFormation;

public class TreeRootToLeafPaths {
private static Stack<Integer> stack = new Stack<Integer>();
public void printAllpath(Node node)
{ 
	if(node == null)
	{
		return;
	}
	if(node.lchild==null && node.rchild==null)
	{
		stack.push(node.data);
		System.out.println("path:"+stack.toString());
		stack.pop();
		return;
	}
	    stack.push(node.data);
	    printAllpath(node.lchild);
	    printAllpath(node.rchild);
	    stack.pop();
}
public static void main(String args[])
{ TreeRootToLeafPaths rtToLf= new TreeRootToLeafPaths();
  rtToLf.printAllpath(TreeFormation.getBinaryTree3());
}
}

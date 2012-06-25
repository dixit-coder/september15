package com.divesh.core;

public class Node {
 public Node lchild;
 public Node rchild;
 public int data;
 public Node(int data)
 {
	 lchild = null;
	 rchild= null;
	 this.data = data;
 }
 public void getNodedata(Node node)
 {
	 System.out.println("data==>"+data);
 }
}

package com.divesh.util;

public class Tnode {
 public Tnode lchild;
 public Tnode rchild;
 public int data;
 public Tnode(int data)
 {
	 lchild = null;
	 rchild= null;
	 this.data = data;
 }
 public void getNodedata(Tnode node)
 {
	 System.out.println("data==>"+data);
 }
}

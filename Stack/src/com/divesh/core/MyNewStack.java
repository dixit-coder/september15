package com.divesh.core;

import java.util.Stack;

@SuppressWarnings("serial")
public class MyNewStack extends Stack<StackNode> {

	public int push(int data) {
		StackNode item = new StackNode(data);
		if (!this.isEmpty()) {
			if (item.data < this.peek().max)
				item.max = this.peek().max;
		}
		this.push(item);
		return data;
	}

	public int getMaxOfStack() {
		return this.peek().max;
	}

	public int popMyNewStack() {
		return this.pop().data;
	}

	public static void main(String args[]) {
		MyNewStack stack = new MyNewStack();
		stack.push(3);
		stack.push(9);
		stack.push(5);
		stack.push(1);
		stack.push(12);
		System.out.println(stack);
		System.out.println(stack.getMaxOfStack());
		stack.popMyNewStack();
		System.out.println(stack);
		System.out.println(stack.getMaxOfStack());

	}
}

class StackNode {
	int data;
	int max;
	StackNode nxt;

	public StackNode(int data) {
		this.data = data;
		this.max = data;
		nxt = null;
	}

	@Override
	public String toString() {

		return "[" + data + "," + max + "]";
	}
}
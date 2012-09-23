package com.divesh.enumPractise;

import java.util.ArrayDeque;
import java.util.Deque;

public class Evaluate {

	// Store the parenthesis
	final Deque<Character> parenthesisArray = new ArrayDeque<Character>();

	// function for business logic...
	public boolean isBalanced(String str) {
		// linear traver the input str...
		for (char c : str.toCharArray()) {
			if (c == PARENTESIS.LB.getSymbol()
					|| c == PARENTESIS.LP.getSymbol()
					|| c == PARENTESIS.LSB.getSymbol()) {
				parenthesisArray.push(c);
			}
			// checking condition for is c in set ), } , ]
			// if yes then pop the stack and compare it with ( , { , [ return
			// false if they don't match
			else if (c == PARENTESIS.RB.getSymbol()) {
				if (parenthesisArray.isEmpty()
						|| PARENTESIS.LB.getSymbol() != parenthesisArray.pop())
					return false;
			} else if (c == PARENTESIS.RP.getSymbol()) {
				if (parenthesisArray.isEmpty()
						|| PARENTESIS.LP.getSymbol() != parenthesisArray.pop())
					return false;
			} else if (c == PARENTESIS.RSB.getSymbol()) {
				if (parenthesisArray.isEmpty()
						|| PARENTESIS.LSB.getSymbol() != parenthesisArray.pop())
					return false;
			}
		}

		return parenthesisArray.isEmpty();
		// if stack is empty then all match, otherwise not matched
	}
}

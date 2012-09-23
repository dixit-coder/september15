package com.divesh.enumPractise;

public enum PARENTESIS {

	LP('('), LB('{'), LSB('['), RP(')'), RB('}'), RSB(']'), ;
	char symbol;

	PARENTESIS(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}
   
}

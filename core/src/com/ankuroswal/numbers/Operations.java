package com.ankuroswal.numbers;

public enum Operations {
	
	ADD("+"), 
	SUBTRACT("-"), 
	MULTIPLY("*"), 
	DIVIDE("/"), 
	ADD2("++"), 
	SUBTRACT2("--");
	
	public String renderString;
	Operations(String value){
		this.renderString = value;
	}
	public static Operations getRandom() {
		return values()[(int) (Math.random() * values().length)];
	}

}
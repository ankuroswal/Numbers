package com.ankuroswal.numbers.Operations;

public class SubtractDoubleOperation extends Operations{

	SubtractDoubleOperation() {
		super(4);
	}
	
	@Override
	public double compute(float value, double score) {
		return score - (value*2);
	}

	@Override
	public String toString() {
		return "--";
	}
	
}

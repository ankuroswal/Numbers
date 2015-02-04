package com.ankuroswal.numbers.Operations;

public class SubtractOperation extends Operations{
	SubtractOperation() {
		super(3);
	}
	
	@Override
	public double compute(float value, double score) {
		return score - value;
	}

	@Override
	public String toString() {
		return "-";
	}

}

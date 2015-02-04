package com.ankuroswal.numbers.Operations;

public class MultiplyOperation extends Operations{

	MultiplyOperation() {
		super(5);
	}

	@Override
	public double compute(float value, double score) {
		return value * score;
	}

	@Override
	public String toString() {
		return "x";
	}

}

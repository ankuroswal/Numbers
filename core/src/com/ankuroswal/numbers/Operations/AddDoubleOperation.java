package com.ankuroswal.numbers.Operations;

public class AddDoubleOperation extends Operations{

	AddDoubleOperation() {
		super(2);
	}

	@Override
	public double compute(float value, double score) {
		return value * 2 + score;
	}

	@Override
	public String toString() {
		return "++";
	}

}

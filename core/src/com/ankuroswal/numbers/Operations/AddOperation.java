package com.ankuroswal.numbers.Operations;

public class AddOperation extends Operations{

	AddOperation() {
		super(1);
	}

	@Override
	public double compute(float value, double score) {
		return value + score;
	}

	@Override
	public String toString() {
		return "+";
	}
}

package com.ankuroswal.numbers.Operations;

public class DivideOperation extends Operations{

	DivideOperation() {
		super(6);
	}

	@Override
	public double compute(float value, double score) {
		if (score == 0 || value == 0)
			return 0;
		return score / value;
	}

	@Override
	public String toString() {
		return "/";
	}

}

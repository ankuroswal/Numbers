package com.ankuroswal.numbers.Operations;

public abstract class Operations
{
	private int id;
	
	Operations(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return id;
	}
	
	public abstract double compute(float value, double score);
	public abstract String toString();
}
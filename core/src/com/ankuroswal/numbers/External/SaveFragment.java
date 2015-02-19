package com.ankuroswal.numbers.External;

public class SaveFragment {
	private int id;
	private double score;
	private boolean open;
	
	@SuppressWarnings("unused")
	private SaveFragment(){};
	
	public SaveFragment(int id, double score, boolean open)
	{
		this.id = id;
		this.score = score;
		this.open = open;
	}
	
	public int getId() {
		return id;
	}

	public double getScore() {
		return score;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
}

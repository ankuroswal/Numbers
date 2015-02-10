package com.ankuroswal.numbers.Operations;

import java.util.LinkedList;

public class OpQueue {
	private LinkedList<Operations> queue;
	private double score;
	private boolean update;
	private String queueOutput;
	
	public OpQueue() {
		this.queue = new LinkedList<Operations>();
		this.setScore(0);
		this.update = true;
		startQ(4);
	}

	public void startQ(int size) {
		queue.clear();
		for (int i = 0; i < size; i++) {
			queue.add(getRandomOperation());
		}
	}

	public void useQ(Integer value) {
		if (value != null) {
			Operations q = queue.removeFirst();
			queue.add(getRandomOperation());
			score = q.compute(value, score);
		}
	}
	

	private Operations getRandomOperation()
	{
		update = true;
		return OperationFactory.getOperation((int) (Math.random() * (OperationFactory.AMOUNT - 1) + 1));
	}
	public LinkedList<Operations> getQ() {
		return queue;
	}

	public double getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public String toString()
	{
		if (update == true)
		{
			String newOutput = "";
			for (Operations o : queue)
			{
				newOutput += o.toString() + " ";
			}
			queueOutput = newOutput;
			update = false;
		}
		return queueOutput;
	}

}

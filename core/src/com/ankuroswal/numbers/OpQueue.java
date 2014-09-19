package com.ankuroswal.numbers;

import java.util.LinkedList;

public class OpQueue {
	private LinkedList<Operations> queue;
	private float score;

	public OpQueue() {
		this.queue = new LinkedList<Operations>();
		this.setScore(0);
		startQ(4);
	}

	public void startQ(int size) {
		Operations q;
		queue.clear();
		for (int i = 0; i < size; i++) {
			q = Operations.getRandom();
			queue.add(q);
		}
	}

	public void useQ(Integer value) {
		if (value != null) {
			Operations q = Operations.getRandom();
			queue.add(q);
			doQ(queue.removeFirst(), value);
		}
	}

	private void doQ(Operations q, int value) {
		switch (q) {
		case ADD:
			setScore(getScore() + value);
			break;
		case SUBTRACT:
			setScore(getScore() - value);
			break;
		case ADD2:
			setScore(getScore() + value * 2);
			break;
		case SUBTRACT2:
			setScore(getScore() - value * 2);
			break;
		case MULTIPLY:
			setScore(getScore() * value);
			break;
		case DIVIDE:
			if (score == 0 || value == 0) {
				setScore(0);
			} else {
				setScore(getScore() / value);
			}
			break;
		default:
			break;
		}
	}

	public LinkedList<Operations> getQ() {
		return queue;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}

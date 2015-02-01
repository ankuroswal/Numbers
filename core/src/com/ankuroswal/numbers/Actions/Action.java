package com.ankuroswal.numbers.Actions;

import com.ankuroswal.numbers.Node.Node;

public interface Action {
	
	// activates the action
	public void activate(Node n);
	
	// sets the priority of the action
	public int getPriority();
	
}

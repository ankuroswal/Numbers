package com.ankuroswal.numbers.Node;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class Node {

	private int value;
	public Color color;
	public NodeDefinitions type;

	public Node(NodeDefinitions node) {
		this.value = getValue(node);
		this.type = node;
		this.color = node.color;
	}

	public Node transform() {
		return new Node(type.transform);
	}

	private Integer getValue(NodeDefinitions node) {
		Random random = new Random();
		return random.nextInt((node.max - node.min) + 1) + node.min;
	}

	public Integer getValue() {
		return value;
	}

}

package com.test;

public class BinaryTree {
	
	public Node rootNode;

	public void addNode(Node node) {
		if (rootNode == null) {
			rootNode = node;
		} else {
			if (node.value.latitude < rootNode.value.latitude) {
				rootNode.leftNodePointer = node;
			} else {
				rootNode.rightNodePointer = node;
			}
		}
		
	}
}

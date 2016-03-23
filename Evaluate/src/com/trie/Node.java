package com.trie;

import java.util.HashMap;

public class Node {

	char value;
	public Node[] nodes = new Node[26];
	
	public int index(char c) {
		int asciiIndex = (int) c;
		return asciiIndex - 97;
	}
	
	public Node addOrGetChar(char c) {
		int index = index(c);
		if (nodes[index] == null) {
			nodes[index] = new Node();
			nodes[index].value = c;
		} else {
			nodes[index].value = c;
		}
		return nodes[index];
	}
	
	public Node getChar(char c) {
		int index = index(c);
		return nodes[index];
		
	}
}

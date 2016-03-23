package com.trie;

public class Trie {
	
	
	
	public void add (char[] arr, Node node, int index) {
		
		if (index < arr.length) {
			Node nextNode = node.addOrGetChar(arr[index]);
			int newIndex = index + 1;
			if (newIndex < arr.length) {
				add(arr, nextNode, newIndex);
			}
		}
	}
	
	public boolean search(char[] arr, Node node, int index) {
		if (index < arr.length) {
			Node nextNode = node.getChar(arr[index]);
			if (nextNode != null) {
				return search(arr, nextNode, index + 1);
			} else {
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "hates";
		Node rootNode = new Node();
		Trie trie = new Trie();
		trie.add(str.toCharArray(), rootNode, 0);
		String find = "hated";
		boolean caught = trie.search(find.toCharArray(), rootNode, 0);
		System.out.println("Is " + caught);
	}

}

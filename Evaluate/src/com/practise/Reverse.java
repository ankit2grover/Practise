package com.practise;

import java.util.Stack;

public class Reverse {

	ListNode reverse(ListNode curr, ListNode prev, int index) {
		++index;
		if (index > 3) {
			prev.nextQuarter = curr;
			return prev;
		} else {
			ListNode newPrev = null;
			if (prev == null) {
				newPrev = curr;
			} else {
				newPrev = prev.next;
			}
			ListNode lastNode = reverse(curr.next, newPrev, index);
			//ListNode nextNode = curr.next;
			curr.next = prev;
			System.out.println(curr.value);
			return lastNode;
//			if (index == 3) {
//				return nextNode;
//			} else {
//				return lastNode;
//			}
		}
	}
	
	public void calculate(ListNode start) {
		ListNode lastNode = start;
		while (lastNode.nextQuarter != null) {
			if (lastNode == start) {
				lastNode = reverse(lastNode, null, 0);
			} else {
				lastNode = reverse(lastNode.nextQuarter, null, 0);
			}
		}
		
	}
	
	public void calculateAlternate(ListNode start) {
		ListNode lastNode = start;
		boolean alterNateRev = true;
		while (lastNode.nextQuarter != null) {
			if (lastNode == start) {
				lastNode = reverse(lastNode, null, 0);
			} else {
				if (alterNateRev) {
					lastNode = reverse(lastNode.nextQuarter, null, 0);
				} else {
					int item = 3;
					lastNode = lastNode.nextQuarter;
					while (item > 0) {
						--item;
						System.out.println(lastNode.value);
						if (item > 0) {
							lastNode = lastNode.next;
						}
					}
				}
			}
			alterNateRev = !alterNateRev;
		}
		
	}
	
	public static void main (String[] args) {
		ListNode node = new ListNode();
		node.value = 2;
		
		ListNode nextNode1 = new ListNode();
		nextNode1.value = 20;
		node.next = nextNode1;
		node.nextQuarter = nextNode1;
		
		ListNode nextNode2 = new ListNode();
		nextNode2.value = 25;
		nextNode1.next = nextNode2;
		nextNode1.nextQuarter = nextNode2;
		
		ListNode nextNode3 = new ListNode();
		nextNode3.value = 11;
		nextNode2.next = nextNode3;
		nextNode2.nextQuarter = nextNode3;
		
		ListNode nextNode4 = new ListNode();
		nextNode4.value = 14;
		nextNode3.next = nextNode4;
		nextNode3.nextQuarter = nextNode4;
		
		ListNode nextNode5 = new ListNode();
		nextNode5.value = 5;
		nextNode4.next = nextNode5;
		nextNode4.nextQuarter = nextNode5;
		
		ListNode nextNode6 = new ListNode();
		nextNode6.value = 6;
		nextNode5.next = nextNode6;
		nextNode5.nextQuarter = nextNode6;
		
		ListNode nextNode7 = new ListNode();
		nextNode7.value = 7;
		nextNode6.next = nextNode7;
		nextNode6.nextQuarter = nextNode7;
		
		ListNode nextNode8 = new ListNode();
		nextNode8.value = 8;
		nextNode7.next = nextNode8;
		nextNode7.nextQuarter = nextNode8;
		
		nextNode8.next = null;
		nextNode8.nextQuarter = null;
		
		
		
		
		Reverse reverse = new Reverse();
		reverse.calculateAlternate(node);
		
		ListNode testNode = node;
		int index = 0;
		
		// Testing code
//		while (testNode != null) {
//			++index;
//			if (index% 3 == 0) {
//				int item = 3;
//				ListNode rawNode = testNode;
//				while (item > 0) {
//					--item;
//					System.out.println(rawNode.value);
//					rawNode = rawNode.next;
//				}
//			}
//			testNode = testNode.nextQuarter;
//			
//		}
	}
}

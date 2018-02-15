package com.ankit.practice.revision.datstructure;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList linkedList  = new LinkedList();
		
/*		linkedList.insertAtBegining(new ListNode(5));
		linkedList.insertAtBegining(new ListNode(4));
		linkedList.insertAtBegining(new ListNode(3));
		linkedList.insertAtBegining(new ListNode(2));
		linkedList.insertAtBegining(new ListNode(1));*/
		
		System.out.println(linkedList.removeFromEnd());
		linkedList.insertAtEnd(new ListNode(1));
		System.out.println(linkedList.removeFromEnd().getData());
		linkedList.insertAtEnd(new ListNode(2));
		linkedList.insertAtEnd(new ListNode(3));
		linkedList.insertAtEnd(new ListNode(4));
		linkedList.insertAtEnd(new ListNode(5));
		System.out.println(linkedList.removeFromEnd().getData());
		
	}

}

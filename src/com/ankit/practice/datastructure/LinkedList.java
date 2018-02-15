package com.ankit.practice.datastructure;

public class LinkedList {

	private int length = 0;
	private LinkedListNode head = null;

	public LinkedList() {
		this.length = 0;
	}

	public LinkedListNode getFirst() {
		return this.head;
	}

	public void insertAtBegin(LinkedListNode node) {
		node.setNext(head);
		this.head = node;
		length++;
	}

	public void insertAtLast(LinkedListNode node) {

		if (head == null)
			head = node;
		LinkedListNode current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
		this.length++;
	}

	public void insertAtMiddle(int index, LinkedListNode node) {

		if (index < 0) {
			index = 0;
		} else if(index > length) index = length;

		if(index == 0){
			node.setNext(head);
			head = node;
			length++;
		} else {
			LinkedListNode current = head;

			for(int i = 1; current.getNext() == null || i== index; i++, current = current.getNext()){
				node.setNext(current.getNext());
				current.setNext(node);
			}
			
			
		}
	}

}

package com.ankit.practice.revision.datstructure;

public class LinkedList {

	private ListNode head;
	private int length = 0;

	public LinkedList() {
	}

	public ListNode getHead() {
		return head;
	}

	public void insertAtBegining(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public void insertAtEnd(ListNode node) {

		// 1 --> 2 --> null
		if (head == null) {
			head = node;
			length++;
		} else {
			ListNode currentNode = head;

			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
			length++;
		}
	}

	//head --> 1 --> 2 --> 3  -->  4 --> 5 --> null
	//						 |    |
	//						 ->6->
	 public void insert(int data, int position) { 

		 if(position < 0  ) position = 0;
		 if(length < position) position = length;
		 if(this.head == null) head = new ListNode(data);
		 else if(position ==0) {
			 ListNode node = new ListNode(data);
			 node.setNext(head);
			 head = node;
		 } else {
			 ListNode currentNode = head;
			 for(int i = 1 ; i < position; i++ ){
				 currentNode = currentNode.getNext();
			 }
			 ListNode newNode = new ListNode(data);
			 newNode.setNext(currentNode.getNext());
			 currentNode.setNext(newNode);
		 }
		 this.length++;
	 }

		//head --> 1 --> 2 --> 3  -->  4 --> 5 --> null
	 public ListNode removeFromBegining() {
		 
		 ListNode node = head;
		 if(head != null){
			 head = node.getNext();
			 node.setNext(null);
			 length --;
		 }
		 return node;
	 }
	//head --> 1 --> 2 --> 3  -->  4 --> 5 --> null	
	// head --> null
	 // head --> 1 --> null
	 public ListNode removeFromEnd() { 
		 ListNode node = head;
		 ListNode prev = head;
		 if(head == null) return null;
		 if(head.getNext() == null){
			 head = null;
			 return node;
		 }
		 while(node.getNext() != null){
			 prev = node;
			 node = node.getNext();
		 }
		 prev.setNext(null);
		 length --;
		 
		 return node;
		 
	 }
	 /* 
	 * public ListNode remove(int position) { }
	 * 
	 * public ListNode removeMatched(ListNode node) { }
	 * 
	 * public int getPosition(int data) { }
	 */
}

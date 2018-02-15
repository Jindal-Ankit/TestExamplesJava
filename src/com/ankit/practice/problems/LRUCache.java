package com.ankit.practice.problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

	int capacity = 0;
	DLinkedList linkedList = null;

	Map<Integer, DLinkedList.Node> refrenceContainer = null;

	public LRUCache(int capacity) {
		linkedList = new DLinkedList(capacity);
		refrenceContainer = new HashMap<Integer, DLinkedList.Node>();
		this.capacity = capacity;
	}

	public int get(int key) {
		int value = -1;
		if (refrenceContainer.containsKey(key)) {
			DLinkedList.Node node = refrenceContainer.get(key);
			linkedList.promoteFirst(node);
			value = node.value;
		}
		return value;
	}

	public void put(int key, int value) {
		if (linkedList.size == capacity) {
			if(refrenceContainer.containsKey(key)){
				DLinkedList.Node node = refrenceContainer.remove(key);
                linkedList.removeNode(node);
                
			} else {
				DLinkedList.Node removed = linkedList.removeLast();
				refrenceContainer.remove(removed.key);
			}
		}
		DLinkedList.Node newNode = linkedList.addNode(key, value);
		refrenceContainer.put(key, newNode);
	}

	class DLinkedList {

		Node head = null;
		Node tail = null;
		int capacity = 0;
		int size = 0;

		class Node {
			int key;
			int value;
			Node next;
			Node prev;

			Node(int key, int value) {
				this.key = key;
				this.value = value;
				this.next = null;
				this.prev = null;
			}

		}

		public DLinkedList(int capacity) {
			this.capacity = capacity;
		}

		public Node addNode(Node newNode) {
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				Node temp = this.head;

				newNode.next = temp;
				temp.prev = newNode;
				this.head = newNode;
			}
			size++;
			return newNode;
		}

		public Node addNode(int key, int value) {
			Node newNode = new Node(key, value);
			return addNode(newNode);
		}

		public Node removeNode(Node tobeRemoved) {

			Node nextNode = tobeRemoved.next;
			Node prevNode = tobeRemoved.prev;

			if (nextNode != null && prevNode != null) {
				nextNode.prev = prevNode;
				prevNode.next = nextNode;
			}  else if (tobeRemoved.next == null && tobeRemoved.prev == null){
				this.head = null;
				this.tail = null;
			}  else if (tobeRemoved.next == null) {
				prevNode.next = tobeRemoved.next;
				this.tail = prevNode;
			}

			tobeRemoved.next = null;
			tobeRemoved.prev = null;
			size--;
			return tobeRemoved;
		}

		public Node removeLast() {
			Node last = this.tail;
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail = last.prev;
				this.tail.next = null;

				last.prev = null;
			}
			size--;
			return last;
		}

		public Node promoteFirst(Node tobePromoted) {
			Node toBePromoted = this.removeNode(tobePromoted);

			return this.addNode(tobePromoted);
		}
	}
}
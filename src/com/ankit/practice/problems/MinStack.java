package com.ankit.practice.problems;

import java.util.Stack;
import java.util.TreeSet;

import com.ankit.java.threds.MainThread;

/*Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), 
 * isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. 
 * All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard 
 * Stack data structure and no other data structure like arrays, list, .. etc.

Example:

Consider the following SpecialStack
16  --> TOP
15
29
19
18

When getMin() is called it should return 15, which is the minimum 
element in the current stack. 

If we do pop two times on stack, the stack becomes
29  --> TOP
19
18

When getMin() is called, it should return 18 which is the minimum 
in the current stack.*/
public class MinStack<E extends Comparable<E>> extends Stack<E>{
	
	
	private Stack<E> minStack = new Stack<E>();
	
	
	public E push(E elem){
		if(elem != null){
			super.push(elem);
			if(minStack.isEmpty()){
				minStack.push(elem);
			} else {
				E minElem = minStack.peek();
				if(minElem.compareTo(elem) >= 0 ){
					minStack.push(elem);
				}
			}
		}
		
		return elem;
	}
	
	public E pop(){
		E elem = super.pop();
		if(!minStack.isEmpty() && elem.equals(minStack.peek())){
			minStack.pop();
		}
		
		return elem;
	}
	
	
	public E min(){
		return minStack.peek();
	}

	
	
	public static void main(String[] args) {
		MinStack s = new MinStack();
		
		
		s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.min());
        s.push(5);
        System.out.println(s.min());
		s.push(2);
        s.push(200);
        s.push(30);
        
        
        System.out.println(s.min());
        
        s.pop();
        s.pop();
        s.pop();
        
        System.out.println(s.min());
	}
}

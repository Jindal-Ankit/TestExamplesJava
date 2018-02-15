package com.ankit.practice.datastructure;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {

	Node root = null;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(int data) {
		this.root = new Node(data);
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);

		tree.root.left.left.left.right = new Node(10);

		// Height of the tree
		int height = heightOfTree(tree.root);
		System.out.println("HEIGHT : " + height);

		System.out.println( "** BFS With Level****" + "\n");
		BFS(tree.root);
		System.out.println( "** BFS With Queue****" +"\n");
		BFSWithQueue(tree.root);
		
		System.out.println("In Order travdersal" +"\n");
		inOrderTraversal(tree.root);
		System.out.println("Pre Order travdersal" +"\n");
		preOrderTraversal(tree.root);
		System.out.println("Post Order travdersal" +"\n");
		postOrderTraversal(tree.root);
	}

	/**
	 * Return the heght/level of tree. Where heght, level starts from 1.
	 * 
	 * @param root
	 * @return
	 */
	private static int heightOfTree(Node root) {
		if (root == null)
			return 0;

		int lHeight = heightOfTree(root.left);
		int rHeight = heightOfTree(root.right);

		if (lHeight < rHeight)
			return rHeight + 1;
		else
			return lHeight + 1;
	}

	/**
	 * This method prints the tree elements in Level Order Traversal. i.e will
	 * print all the elements for each level at one shot starting from level 1.
	 * 
	 * @param root
	 *            Starting node of the binary tree. Complexity is O(n^2)
	 */
	private static void BFS(Node root) {
		if (root == null)
			System.out.println("Tree is null");
		int height = heightOfTree(root);
		for (int i = 1; i <= height; i++) {
			levelOrderTraversal(root, i);
			System.out.println();
		}
	}

	private static void levelOrderTraversal(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		levelOrderTraversal(root.left, level - 1);
		levelOrderTraversal(root.right, level - 1);
	}

	static Queue<Node> queue = new LinkedList<>();

	private static void BFSWithQueue(Node root) {
		if (root == null)
			return;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node != null) {
				System.out.print(node.data + " ");
				Node leftChild = node.left;
				if (leftChild != null)
					queue.add(leftChild);
				Node rightChild = node.right;
				if (rightChild != null)
					queue.add(rightChild);
			}
		}

	}
	
	
	private static void inOrderTraversal(Node root){
		if(root == null) return;
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}
	
	private static void preOrderTraversal(Node root){
		if(root == null) return;
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	private static void postOrderTraversal(Node root){
		if(root == null) return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}
}

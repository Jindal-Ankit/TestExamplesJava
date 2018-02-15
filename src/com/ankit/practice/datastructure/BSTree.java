package com.ankit.practice.datastructure;

public class BSTree {
	Node root = null;
	class Node {
		Node left;
		Node right;
		int data;
		
		Node(int data){
			this.left = null;
			this.right = null;
			this.data = data;
	}
	}	
	public static void main(String[] args) {
		BSTree tree = new BSTree();
		tree.root = tree.new Node(10);
		tree.root.left = tree.new Node(4);
		tree.root.right = tree.new Node(15);
		
		tree.root.left.left = tree.new Node(3);
		tree.root.left.right = tree.new Node(6);
		
		tree.root.right.left = tree.new Node(13);
		tree.root.right.right = tree.new Node(16);
		
		tree.root.left.left.left = tree.new Node(2);
		tree.root.left.right.right = tree.new Node(7);
		
		System.out.println(isBST(tree.root));
	}
	
	private static boolean isBST(Node root){
		if(root == null) return true;
		boolean isLeftTrue = isLeftBST(root, root.data);
		boolean isRightTreu = isRightBST(root, root.data);
		return isLeftTrue && isRightTreu;
	}
	
	
	private static boolean isLeftBST(Node node, int rootVal){
		if(node == null) return  true;
		if(node.left != null){
			if (node.left.data < node.data && node.left.data < rootVal) {
				return isLeftBST(node.left, rootVal);
			} else return false;
		} else return true;
	}

	private static boolean isRightBST(Node node, int rootVal){
		if(node == null) return  true;
		if(node.left != null){
			if (node.right.data > node.data && node.right.data > rootVal) {
				return isRightBST(node.right, rootVal);
			} else return false;
		} else return true;
	}
}

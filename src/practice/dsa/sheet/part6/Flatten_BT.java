package practice.dsa.sheet.part6;

import java.util.Stack;

import practice.dsa.sheet.part6.utility.Node;

public class Flatten_BT {
	
	private static Stack<Node> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(5);
		
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		
		root.right.right = new Node(6);
		
		flatten(root);
		
		PrintRightSkewedBinary(root);
	}
	
	/*
	 * T = O(n)
	 * S = O(n) + O(n) [stack + system-stack]
	 * => S = O(n)
	 */
	public static void flatten(Node root) {
		
		if(root != null) {
			if(root.right != null) {
				stack.push(root.right);
				root.right = null;
			}
			Node nodeToBeAdded  = null;
			if(root.left == null) {
				if(stack.isEmpty()) {
					return;
				}
				nodeToBeAdded = stack.pop();
				if(nodeToBeAdded.right != null) {
					stack.push(nodeToBeAdded.right);
					nodeToBeAdded.right = null;
				}
			} else {
				nodeToBeAdded = root.left;
			}
			
			root.right = nodeToBeAdded;
			root.left = null;
			flatten(root.right);
		}
	}
	
	private static void PrintRightSkewedBinary(Node root) {
		
		Node t = root;
		
		while(t != null) {
			System.out.println(t.data);
			t = t.right;
		}
	}
}

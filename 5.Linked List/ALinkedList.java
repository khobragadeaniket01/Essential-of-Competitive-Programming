/*
Add two numbers represented by Linked List
Given two numbers represented by two lists, write a function that 
returns the sum in the form of a linked list.

Example:
Input: 
List1: 5->6->3 // represents number 563 
List2: 8->4->2 // represents number 842 
Output: 
Resultant list: 1->4->0->5 // represents number 1405 
Explanation: 563 + 842 = 1405

Traverse both lists to the end and add preceding zeros in the list with 
lesser digits. Then call a recursive function on the start nodes of both 
lists which calls itself for the next nodes of both lists till it gets to 
the end. This function creates a node for the sum of the current digits 
and returns the carry. 

Follow the steps below to solve the problem:
Traverse the two linked lists in order to add preceding zeros in case a list 
is having lesser digits than the other one.
Start from the head node of both lists and call a recursive function for the next 
nodes.
Continue it till the end of the lists.
Creates a node for current digits sum and returns the carry.
*/
// Java program to add two numbers represented by linked list

class ALinkedList {

	static Node head1, head2;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Adds contents of two linked lists and prints it */
	void addTwoLists(Node first, Node second) {
		Node start1 = new Node(0);
		start1.next = first;
		Node start2 = new Node(0);
		start2.next = second;

		addPrecedingZeros(start1, start2);
		Node result = new Node(0);
		if (sumTwoNodes(start1.next, start2.next, result) == 1) {
			Node node = new Node(1);
			node.next = result.next;
			result.next = node;
		}
		printList(result.next);
	}

	/* Adds lists and returns the carry */
	private int sumTwoNodes(Node first, Node second, Node result) {
		if (first == null) {
			return 0;
		}
		int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
		Node node = new Node(number % 10);
		node.next = result.next;
		result.next = node;
		return number / 10;
	}

	/* Appends preceding zeros in case a list is having lesser nodes than the other one*/
	private void addPrecedingZeros(Node start1, Node start2) {
		Node next1 = start1.next;
		Node next2 = start2.next;
		while (next1 != null && next2 != null) {
			next1 = next1.next;
			next2 = next2.next;
		}
		if (next1 == null && next2 != null) {
			while (next2 != null) {
				Node node = new Node(0);
				node.next = start1.next;
				start1.next = node;
				next2 = next2.next;
			}
		} else if (next2 == null && next1 != null) {
			while (next1 != null) {
				Node node = new Node(0);
				node.next = start2.next;
				start2.next = node;
				next1 = next1.next;
			}
		}
	}

	/* Utility function to print a linked list */
	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		ALinkedList list = new ALinkedList();

		// creating first list
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("First list is ");
		list.printList(head1);

		// creating second list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second list is ");
		list.printList(head2);

		System.out.print("Resultant list is ");
		// add the two lists and see the result
		list.addTwoLists(head1, head2);
	}

}

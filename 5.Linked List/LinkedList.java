/*
Delete Nth node from the end of the given linked list
Given a linked list and an integer N, the task is to delete the Nth node from the end 
of the given linked list.
 
Examples:  

Input: 2 -> 3 -> 1 -> 7 -> NULL, N = 1 
Output: 
The created linked list is: 
2 3 1 7 
The linked list after deletion is: 
2 3 1

Input: 1 -> 2 -> 3 -> 4 -> NULL, N = 4 
Output: 
The created linked list is: 
1 2 3 4 
The linked list after deletion is: 
2 3 4 

*/

// Java implementation of the approach
class LinkedList {

	// Head of list
	Node head;

	// Linked list Node
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	// Function to delete the nth node from the end of the given linked list
	void deleteNode(int key)
	{

		// First pointer will point to the head of the linked list
		Node first = head;

		// Second pointer will point to the Nth node from the beginning
		Node second = head;
		for (int i = 0; i < key; i++) {

			// If count of nodes in the given linked list is <= N
			if (second.next == null) {

				// If count = N i.e. delete the head node
				if (i == key - 1)
					head = head.next;
				return;
			}
			second = second.next;
		}

		// Increment both the pointers by one until second pointer reaches the end
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}

		/* First must be pointing to the Nth node from the end by now. 
		So, delete the node first is pointing to*/
		first.next = first.next.next;
	}

	// Function to insert a new Node at front of the list
	public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	// Function to print the linked list
	public void printList()
	{
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	public static void main(String[] args)
	{
		LinkedList llist = new LinkedList();

		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);

		System.out.println("\nCreated Linked list is:");
		llist.printList();

		int N = 1;
		llist.deleteNode(N);

		System.out.println("\nLinked List after Deletion is:");
		llist.printList();
	}
}

/*
Write a function to get the intersection point of two Linked Lists
There are two singly linked lists in a system. By some programming error, 
the end node of one of the linked lists got linked to the second list, 
forming an inverted Y-shaped list. Write a program to get the point 
where two linked lists merge.
Method:
Use 2 nested for loops. The outer loop will be for each node of the 1st list 
and the inner loop will be for the 2nd list. In the inner loop, 
check if any of the nodes of the 2nd list is the same as the current node of 
the first linked list. The time complexity of this method will be O(M * N) where 
m and n are the numbers of nodes in two lists.

*/
// Java Program to get intersection point of two linked lists.
import java.util.*;
import java.io.*;


class Intersection {

	static class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/* function to get the intersection point of two linked
	lists head1 and head2 */
	public Node getIntersectionNode(Node head1, Node head2)
	{
		while (head2 != null) {
			Node temp = head1;
			while (temp != null) {
				// if both Nodes are same
				if (temp == head2) {
					return head2;
				}
				temp = temp.next;
			}
			head2 = head2.next;
		}
		// If intersection is not present between the lists,
		// return NULL.
		return null;
	}

	public static void main(String[] args)
	{
		Intersection list = new Intersection();

		Node head1, head2;

		/*
				Create two linked lists

				1st 3->6->9->15->30
				2nd 10->15->30

				15 is the intersection point
		*/

		head1 = new Node(10);
		head2 = new Node(3);

		Node newNode = new Node(6);
		head2.next = newNode;

		newNode = new Node(9);
		head2.next.next = newNode;

		newNode = new Node(15);
		head1.next = newNode;
		head2.next.next.next = newNode;

		newNode = new Node(30);
		head1.next.next = newNode;

		head1.next.next.next = null;

		Node intersectionPoint
			= list.getIntersectionNode(head1, head2);

		if (intersectionPoint == null) {
			System.out.print(" No Intersection Point \n");
		}
		else {
			System.out.print("Intersection Point: "
							+ intersectionPoint.data);
		}
	}
}

// Importing input output classes
import java.io.*;
// Importing Scanner class from java.util package
import java.util.*;


class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}



// Solution Class
class solution {
	public static Node insertAtHead(Node head, int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
		return head;
	}
	public static void printLL(Node head) {
		if (head == null) {
			System.out.println("Empty LL");
		} else {
			while (head != null) {
				System.out.print(head.data + " ---> ");
				head = head.next;
			}
		}
	}
	public static void main(String[] args) {

		Node head = null;
		head = insertAtHead(head, 1);
		head = insertAtHead(head, 2);
		head = insertAtHead(head, 3);
		head = insertAtHead(head, 4);
		printLL(head);
	}
}

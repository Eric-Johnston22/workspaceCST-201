package app;
import app.SinglyLinkedList.Node;

public class Main 
{

	public static void main(String[] args) 
	{
		SinglyLinkedList myList = new SinglyLinkedList();
		
		
		myList.head = new Node(3);
		Node second = new Node(5);
		Node third = new Node(7);
		myList.tail = myList.getLast();
		
		myList.head.next = second;
		second.next = third;
		
		System.out.println("Linked List: ");
		myList.printList(myList.head);
		
		System.out.println("\n\nLinked list size: " + myList.size());
	
		System.out.println("\nFirst element is: " + myList.getFirst().data);
		System.out.println("Last element is: " + myList.getLast().data);
		System.out.println("\nInserting new node at element 2: ");
		myList.insert(second, 6);
		myList.tail = myList.getLast();
		myList.printList(myList.head);
		System.out.println("\nLinked list size: " + myList.size());
		
		
		System.out.println("\n\nDeleting first node");
		myList.popFront();
		myList.printList(myList.head);
		System.out.println("\nDeleting last node");
		myList.popBack();
		myList.tail = myList.getLast();
		myList.printList(myList.head);
		
		System.out.println("\n\nDetermine if linked list is empty: " + myList.empty());
		
		System.out.println("\nLinked list size: " + myList.size());
		
		Node head2 = new Node(9);
		head2.next = new Node(12);
		head2.next.next = new Node(14);
		
		System.out.println("\n\nMerging two lists");
		Node mergedHead = myList.merge(myList.head, head2);
		myList.tail = myList.getLast();
		myList.printList(mergedHead);
		
		System.out.println("\nReversing list");
		myList.head = myList.reverse();
		myList.tail = myList.getLast();
		myList.printList(myList.head);
		
	}

}

package app;

public class SinglyLinkedList {
	Node head;
	Node tail;

	// Default Constructor
	public SinglyLinkedList() 
	{

	}
	
	// Copy Constructor
	public SinglyLinkedList(SinglyLinkedList a)
	{
		head = a.head;
		tail = a.tail;
	}

	static class Node 
	{
		int data;
		Node next;

		// Constructor that creates new node
		Node(int d) 
		{
			this.data = d;
			next = null;
		}
	}

	// O(1) constant
	public Node getFirst() 
	{
		return head;
	}

	// O(n) linear
	public Node getLast() 
	{
		Node current = head;
		Node next = current.next;

		while (next != null) 
		{
			current = next;
			next = current.next;
		}

		return current;
	}

	// O(1) constant
	public void insert(Node previous, int data) 
	{
		if (previous == null) 
		{
			return;
		}

		Node newNode = new Node(data);

		newNode.next = previous.next;
		previous.next = newNode;
	}

	// O(1) constant
	public Node popFront() 
	{
		if (head == null) 
		{
			return null;
		}

		head = head.next;
		return head;
	}

	// O(n) linear
	public Node popBack() 
	{
		if (head == null) 
		{
			return null;
		}

		if (head.next == null) 
		{
			return null;
		}

		Node secondLast = head;

		while (secondLast.next.next != null) 
		{
			secondLast = secondLast.next;
		}

		secondLast.next = null;
		return head;
	}

	// O(1) constant
	public boolean empty() 
	{
		if (head == null) 
		{
			return true;
		}

		return false;
	}

	// O(n) linear
	public int size() 
	{
		int count = 0;
		Node n = head;

		while (n != null) 
		{
			count++;
			n = n.next;
		}
		return count;
	}

	// O(n) linear
	public Node reverse() 
	{
		Node previous = null;
		Node current = head;
		Node next = null;

		while (current != null) 
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}

	// O(nlogn) - super linear
	public Node merge(Node a, Node b) 
	{
		Node res = null;
		
		if (a == null)
		{
			return b;
		}
		if (b == null)
		{
			return a;
		}
		
		if (a.data <= b.data)
		{
			res = a;
			res.next = merge(a.next, b);
		}
		
		else
		{
			res = b;
			res.next = merge(a, b.next);
		}
		
		return res;
	}


	// O(n) linear
	public void printList(Node n) 
	{
		while (n != null) 
		{
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}

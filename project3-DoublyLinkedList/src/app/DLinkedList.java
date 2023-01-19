package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * provided file for DLinkedList Assignment
 *
 * @author lkfritz
 * @
 */
public class DLinkedList<T extends Comparable<T>>
{

	public static void main(String[] args) throws FileNotFoundException
	{

		DLinkedList<String> lst1 = new DLinkedList<>();
		DLinkedList<String> lst2 = new DLinkedList<>();
		

		Scanner fin = new Scanner(new File("text1.in"));
		String str;

		while (fin.hasNext())
		{
			str = fin.next();
			str = cleanUp(str);
			lst1.insertOrderUnique(str);
		}
		fin.close();

		fin = new Scanner(new File("text2.in"));
		while (fin.hasNext())
		{
			str = fin.next();
			str = cleanUp(str);
			lst2.insertOrderUnique(str);
		}

		System.out.println("List 1:  " + lst1);
		System.out.println("List 2:  " + lst2);

		DLinkedList combined = lst1.merge(lst2);

		System.out.println("\nAFTER MERGE");
		System.out.println("List 1:  " + lst1);
		System.out.println("List 2:  " + lst2);
		System.out.println("\n" + combined);
	}

	/**
	 * ASSIGNED
	 * 
	 * @param str
	 * @return str in all lower case with LEADING and TRAILING non-alpha chars
	 *         removed
	 */
	public static String cleanUp(String str)
	{
		// Regex to remove non-alpha chars
		return str.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
	}

	// inner DNode class: PROVIDED
	private class DNode
	{

		private DNode next, prev;
		private T data;

		private DNode(T val)
		{
			this.data = val;
			next = prev = this;
		}
	}

	// DLinkedList fields: PROVIDED
	private DNode header;

	// create an empty list: PROVIDED
	public DLinkedList()
	{
		header = new DNode(null);
	}

	/**
	 * PROVIDED add
	 *
	 * @param item return ref to newly inserted node
	 */
	public DNode add(T item)
	{
		// make a new node
		DNode newNode = new DNode(item);
		// update newNode
		newNode.prev = header;
		newNode.next = header.next;
		// update surrounding nodes
		header.next.prev = newNode;
		header.next = newNode;
		return newNode;
	}

	// PROVIDED
	public String toString()
	{
		String str = "[";
		DNode curr = header.next;
		while (curr != header)
		{
			str += curr.data + " ";
			curr = curr.next;
		}
		str = str.substring(0, str.length() - 1);
		return str + "]";
	}

	/**
	 * ASSIGNED remove val from the list
	 * O(n)
	 * @param val
	 * @return true if successful, false otherwise
	 */
	public boolean remove(T val)
	{
		DNode current = header.next;
		
		while (current != header && current.data.compareTo(val) != 0)
		{
			current = current.next;
		}
		
		if (current == header)
		{
			return false;
		}
		
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = current;
		current.prev = current;
		
		return true;
	}

	/**
	 * ASSIGNED
	 * O(n)
	 * @param item
	 */
	public void insertOrder(T item)
	{
		DNode newNode = new DNode(item);
		DNode current = header.next;
		
		while (current != header && current.data.compareTo(item) < 0)
		{
			current = current.next;
		}
		
		newNode.prev = current.prev;
		newNode.next = current;
		current.prev.next = newNode;
		current.prev = newNode;
		
	}

	/**
	 * ASSIGNED
	 * O(n)
	 * @param item
	 */
	public boolean insertOrderUnique(T item)
	{
		DNode newNode = new DNode(item);
		DNode current = header.next;
		
		// Check if current node is before item alphabetically
		while (current != header && current.data.compareTo(item) < 0)
		{
			current = current.next;
		}
		
		if (current!= header && current.data.compareTo(item) == 0)
		{
			return false;
		}
		
		// Insert new node alphabetically
		newNode.prev = current.prev;
		// 
		newNode.next = current;
		current.prev.next = newNode;
		current.prev = newNode;
		
		return true;
	}

	/**
	 * ASSIGNED PRE: this and rhs are sorted lists
	 * O(n)
	 * @param rhs
	 * @return list that contains this and rhs merged into a sorted list POST:
	 *         returned list will not contain duplicates
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DLinkedList merge(DLinkedList rhs)
	{
		DLinkedList result = new DLinkedList();
		DNode current = this.header.prev;
		
		while (current != this.header)
		{
			result.add(current.data);
			current = current.prev;
		}
		
		current = rhs.header.next;
		
		while (current != rhs.header)
		{
			result.insertOrderUnique(current.data);
			current = current.next;
		}
		
		return result;
	}
	

}

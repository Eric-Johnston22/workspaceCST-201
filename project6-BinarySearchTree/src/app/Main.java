package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		BinaryTree myTree = new BinaryTree();
		ArrayList<String> myList = new ArrayList<String>();
		Scanner fileIn = new Scanner(new File("input.txt"));
		Scanner userIn = new Scanner(System.in);
		String input = "";
		
		// Add contents of file to myList
		while (fileIn.hasNext())
		{
			myList.add(fileIn.next());
		}
		// Close input
		fileIn.close();
		
		// Insert data into tree
		for (String i : myList)
		{
			myTree.insert(new BinaryTree.Node(i));
		}
		
		
		myTree.display();
		
		// User input for string search
		while (true) 
		{
			System.out.println("\nEnter a string, or enter 0 to quit: ");
			input = userIn.nextLine();
			
			if (input.equals("0"))
			{
				break;
			}
			
			System.out.println(myTree.search(input) ? "'" + input +"'" + " located": "'" + input +"'" + " not in tree");
			System.out.println("Inspected " + myTree.counter + " elements");
			
		}
		
		// User input for string removal
		while (true)
		{
			System.out.println("\nEneter a string to remove, or enter 0 to quit: ");
			
			input = userIn.nextLine();
			
			if (input.equals("0"))
			{
				break;
			}
			
			if (myTree.search(input))
			{
				System.out.println("Removing " + input);
				myTree.remove(input);
			}
			else
			{
				System.out.println(input + " Not found");
			}
			
			myTree.display();
		}

	}

}

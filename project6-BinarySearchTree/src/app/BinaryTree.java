package app;

/*
 * Non-Balanced binary tree
 * 
 * 	Time-Complexity:
 * 		Best-case: O(log n)
 *		Worse-case: O(n)
 */
public class BinaryTree
{
	Node root;
	int counter; // this will count # of inspected elements AND # of elements in tree

	public static class Node
	{
		String data;
		Node left, right;
		
		public Node(String data)
		{
			this.data = data;
		}
	}
	
	public void insert(Node node)
	{
		root = insertHelper(root, node);
	}
	private Node insertHelper(Node root, Node node)
	{
		String data = node.data;
		
		// Check if root node has been assigned, examines root node of subtree
		if(root == null)
		{
			// If null, assign root node
			root = node;
			return root;
		}
		
		/*
		 * If data is less than data of root node, go left
		 * Recursively move down tree to the right
		 */
		else if ((data.compareTo(root.data) < 0))
		{
			root.left = insertHelper(root.left, node);
		}
		/*
		 *  If data is greater than data of root node, go right
		 *  Recursively move down tree to the right
		 */
		else
		{
			root.right = insertHelper(root.right, node);
		}
		
		return root;
	}
	
	public void display()
	{
		counter = 1;
		displayHelper(root);
	}
	private void displayHelper(Node root)
	{
		if(root != null)
		{
			displayHelper(root.left);
			System.out.println(counter + ". " + root.data);
			counter++;
			displayHelper(root.right);
		}
	}
	
	public boolean search(String data)
	{
		counter = 0;
		return searchHelper(root, data);
	}
	private boolean searchHelper(Node root, String data)
	{
		// Check if root is null
		if(root == null)
		{
			return false;
		}
		
		// Check if data to search is EQUAL to root.data
		else if(root.data.equals(data))
		{
			counter++;
			return true;
		}
		
		/*
		 *  Check if data is alphabetically LESS than root.data
		 *  Recursively call method to move left down the tree
		 */
		else if (root.data.compareTo(data) > 0)
		{
			counter++;
			return searchHelper(root.left, data);
		}
		
		/*
		 * Else data is alphabetically MORE than root.data
		 * Recursively call method to move right down the tree
		 */
		else
		{
			counter++;
			return searchHelper(root.right, data);
		}
	}
	
	public void remove(String data)
	{
		// Make sure node with data exists
		if(search(data))
		{
			removeHelper(root, data);
		}
		else
		{
			System.out.println(data + " could not be found.");
		}
	}
	public Node removeHelper(Node root, String data)
	{
		// Check if root is null
		if (root == null)
		{
			return root;
		}
		
		/*
		 * Check if data is less than root.data
		 * If so, recursively call method and move left down the tree
		 */
		else if (data.compareTo(root.data) < 0)
		{
			root.left = removeHelper(root.left, data);
		}
		/*
		 * Check if data is greater than root.data
		 * If so, recursively call method and move right down the tree
		 */
		else if (data.compareTo(root.data) > 0)
		{
			root.right = removeHelper(root.right, data);
		}
		
		// Node was found
		else
		{
			// Check if node is a leaf node
			if (root.left == null && root.right == null)
			{
				root = null;
			}
			/*
			 * If the node has a right child, find a successor to replace this node
			 * Set the successor and recursively call removeHelper to move right down tree
			 */
			else if (root.right != null)
			{
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			/*
			 * If the node has a left child, find a predecessor to replace this node
			 * Set the predecessor and recursively call removeHelper to move right down tree
			 */
			else
			{
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
		}
		
		return root;
	}
	
	// Find the least value below right child of this root node
	private String successor(Node root)
	{
		// Go right
		root = root.right;
		
		// Go as far left as possible
		while(root.left != null)
		{
			root = root.left;
		}
		return root.data;
	}
	
	// Find the greatest value below right child of this root node
	private String predecessor(Node root)
	{
		// Go left
		root = root.left;
		
		// Go as far right as possible
		while(root.right != null)
		{
			root = root.right;
		}
		return root.data;
	}
}




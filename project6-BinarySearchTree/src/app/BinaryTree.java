package app;

public class BinaryTree
{
	Node root;
	int counter;

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
		
		if(root == null)
		{
			root = node;
			return root;
		}
		else if ((data.compareTo(root.data) < 0))
		{
			root.left = insertHelper(root.left, node);
		}
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
		if(root == null)
		{
			return false;
		}
		else if(root.data.equals(data))
		{
			counter++;
			return true;
		}
		else if (root.data.compareTo(data) > 0)
		{
			counter++;
			return searchHelper(root.left, data);
		}
		else
		{
			counter++;
			return searchHelper(root.right, data);
		}
	}
	
	public void remove(String data)
	{
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
		if (root == null)
		{
			return root;
		}
		else if (data.compareTo(root.data) < 0)
		{
			root.left = removeHelper(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			root.right = removeHelper(root.right, data);
		}
		else
		{
			if (root.left == null && root.right == null)
			{
				root = null;
			}
			else if (root.right != null)
			{
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			else
			{
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
		}
		
		return root;
	}
	
	// find the least value below right child of this root node
	private String successor(Node root)
	{
		root = root.right;
		
		while(root.left != null)
		{
			root = root.left;
		}
		return root.data;
	}
	private String predecessor(Node root)
	{
		root = root.left;
		
		while(root.right != null)
		{
			root = root.right;
		}
		return root.data;
	}
	
	
}




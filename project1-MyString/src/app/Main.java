package app;

public class Main 
{

	public static void main(String[] args) 
	{
		MyString s1 = new MyString("orange");
		MyString s2 = new MyString("triage");
		
		
		System.out.println("Size of s1: " + s1.length());
		
		// Concat
		MyString s3 = s1.concat(s2);
		System.out.println("\nConcatination: ");
		s3.printArr();
		 
		// CompareTo
		System.out.println("\nComparing objects: " + s1.compareTo(s2));
		
		// getIndex
		System.out.println("\nGet index: " + s1.getIndex(1));
		
		// toUpper
		s1.toUpper(s1);
		System.out.println("\nTo Uppercase: ");
		s1.printArr();
		
		// toLower
		s1.toLower(s1);
		System.out.println("\nTo Lowercase: ");
		s1.printArr();
		
		// subString
		char[] sString = s1.subString(4);
		for (int i = 0; i < sString.length; i++)
		{
			System.out.println("\nSubstring from index 4: " + sString[i]);			
		}
		
		// subString overload
		char[] sStringOverload = s1.subString(1, 4);
		for (int i = 0; i < sStringOverload.length; i++)
		{
			System.out.println("\nSubstring from index 1 to 4: " + sStringOverload[i]);			
		}
		
		// indexOf
		System.out.println("\nIndex of: " + s1.indexOf(s2));
		
		// lastIndexOf
		System.out.println("\nLast Index of: " + s1.lastIndexOf(s2));
	}

}

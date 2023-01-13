package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) throws IOException 
	{
		List<String> stringList = new ArrayList<String>();
		
		Scanner sc = new Scanner(new FileReader("file.txt")).useDelimiter("\s");
		BufferedReader br = new BufferedReader(new FileReader("file.txt"));
		String str;
		
		while(sc.hasNext())
		{
			str = sc.next();
			stringList.add(str);
		}
		
		System.out.println("Before sort:\n");
		
		String[] arr = stringList.toArray(new String[0]);
		
		for (String s : arr)
		{
			System.out.println(s);
		}
		
		System.out.println("\nAfter sort:\n");
		
		// Sort method
		sortArr(arr);
		
		for (String s : arr)
		{
			System.out.println(s);
		}
		
		Scanner isc = new Scanner(System.in);
		System.out.println("\nEnter a word to search for or press 0 to quit.");
		String userInput = isc.nextLine();
		
		System.out.println("Running search...");
		int result = binarySearch(arr, userInput);
		
		if (result == -1)
		{
			System.out.println("That word is not in the array.");
			
		}
		else
		{
			System.out.println("Word found at index " + result);
		}
		
	}

	public static void sortArr(String[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				String temp = "";
				if (arr[i].compareTo(arr[j]) > 0)
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static int binarySearch(String[] arr, String target)
	{
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right)
		{
			int middle = left + (right - left) / 2;
			int res = target.compareTo(arr[middle]);
			
			// if target is equal to middle element, return middle 
			if (res == 0)
			{
				return middle;
			}
			// if value of array at middle index is less than the target, update left pointer
			if (res > 0)
			{
				left = middle + 1;
			}
			// if value of array at middle index is more than target, update right pointer
			else
			{
				right = middle - 1;
			}
		}
		return -1;
	}

}

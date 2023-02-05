package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	/*
	 * Slip is a character string with the following properties:
	 * • Its first character is either a 'D' or an 'E'
	 * • The first character is followed by a string of one or more 'F's
	 * • The string of one or more 'F's is followed by either a Slip or a 'G'
	 * • The Slip or 'G' that follows the F's ends the Slip. For example, 
	 * 	 DFFEFFFG is a Slip since it has a 'D' for its first character, followed by a string of two F's, and ended by the Slip 'EFFFG'
	 * • Nothing else is a Slip
	 * 
	 * 	TIME COMPLEXITY: O(n^2)
	 */
	static boolean isSlip(String str)
	{
		if (str.charAt(0) == 'D' || str.charAt(0) == 'E')
		{
			for (int i = 1; str.charAt(i) == 'F'; i++)
			{
				if (str.charAt(i + 1) == 'D' || str.charAt(i + 1) == 'E')
				{
					return isSlip(str = str.substring(i + 1, str.length()));
				}
				
				else if (str.charAt(i + 1) == 'G')
				{
					str = str.substring(i + 2, str.length());
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/*
	 * Slap is a character string that has the following properties:
	 * Its first character is an 'A'
	 * If it is a two-character Slap then its second and last character is an 'H'
	 * If it is not a two-character Slap, then it is in one of these two forms:
	 * 	'A' followed by 'B' followed by a Slap, followed by a 'C'
	 * 	'A' followed by a Slip (see above) followed by a ‘C’
	 * Nothing else is a Slap
	 * 
	 * 	TIME COMPLEXITY: O(1)
	 */
	static boolean isSlap(String str)
	{
		if(str.charAt(0) == 'A')
		{
			if (str.charAt(1) == 'H')
			{
				str = str.substring(2, str.length());
				return true;
			}
			
			else if (str.charAt(1) == 'B')
			{
				if (isSlap(str = str.substring(2, str.length())))
				{
					if (str.charAt(0) == 'C')
					{
						str = str.substring(1, str.length());
						return true;
					}
				}
			}
			
			else if (isSlip(str = str.substring(1, str.length())))
			{
				if (str.charAt(0) == 'C')
				{
					str = str.substring(1, str.length());
					return true;
				}
			}
		}
		
		return false;
	}
	
	static boolean isSlop(String str)
	{
		String slapStr = str.substring(0, 2);
		String slipStr = str.substring(2, str.length());
		
		return isSlap(slapStr) && isSlip(slipStr);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner fin = new Scanner(new File("input.txt"));
		List<String> collection = new ArrayList<String>();
		
		while (fin.hasNextLine())
		{
			collection.add(fin.nextLine());
		}
		fin.close();
		
		
		System.out.println("SLOPS OUTPUT");
		
		System.out.println(isSlop(collection.get(1)) ? "YES" : "NO");
		System.out.println(isSlop(collection.get(2)) ? "YES" : "NO");
		
		System.out.println("END OF OUTPUT");
	}

}

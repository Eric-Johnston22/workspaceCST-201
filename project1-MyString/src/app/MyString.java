package app;


public class MyString implements Comparable<MyString>
{
	private int curr_length;
	private char[] charArr;
	
	public int getCurr_length() 
	{
		return curr_length;
	}
	public void setCurr_length(int curr_length) 
	{
		this.curr_length = curr_length;
	}
	public char[] getCharArr() 
	{
		return charArr;
	}
	public void setCharArr(char[] charArr) 
	{
		this.charArr = charArr;
	}
	
	public MyString()
	{
		this.curr_length = 0;
		this.charArr = null;
	}
	
	public MyString(String a)
	{
		//this.str = a;
		this.curr_length = a.length();
		this.charArr = new char[curr_length];
		for (int i = 0; i < curr_length; i++)
		{
			this.charArr[i] = a.charAt(i);
		};
	}
	
	public MyString(MyString obj)
	{
		MyString newObj = new MyString(obj);
	}
	
	public MyString(char[] ch, int len)
	{
		//this.str = str;
		this.curr_length = len;
		this.charArr = ch;
	}
	
	// O(1)
	public int length()
	{
		return curr_length;
	}
	
	// O(1)
	public String toString()
	{
		String str = new String(charArr);
		return "MyString String = " + str + " curr_length = " + curr_length + " charArr = " + charArr;
	}
	
	// O(n^2)
	public MyString concat(MyString obj)
	{
		//String newStr = this.str + obj.getStr();
		int newLength = this.curr_length + obj.getCurr_length();
		
		char[] tempArr = new char[newLength];
		
		System.arraycopy(this.charArr, 0, tempArr, 0, this.charArr.length);
		System.arraycopy(obj.charArr, 0, tempArr, this.charArr.length, obj.charArr.length);
		
		return new MyString(tempArr, newLength);
	}
	
	// O(n^2)
	@Override
	public int compareTo(MyString obj)
	{
		int count = 0;
		int alphaOne = 0;
		int alphaTwo = 0;
		
		if (this.curr_length < obj.curr_length)
		{
			count = this.curr_length;
		}
		else
		{
			count = obj.curr_length;
		}
		
		
		if (this.charArr == obj.charArr)
		{
			return 0;
		}
		
		// Increment counters depending upon which character is alphabetically higher or lower.
		for (int i = 0; i < count; i++)
		{
			if (this.charArr[i] < obj.charArr[i])
			{
				alphaOne++;
			}
			else if (this.charArr[i] > obj.charArr[i])
			{
				alphaTwo++;
			}
		}
		
		if (alphaOne > alphaTwo)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	// O(1)
	public char getIndex(int x)
	{
		if (x > this.curr_length)
		{
			System.out.println("Please enter a number within range");
		}
		else
		{			
			return this.charArr[x];
		}
		
		return '@';
	}
	
	// O(n)
	public void printArr()
	{
		for (int i = 0; i < this.curr_length; i++)
		{
			System.out.println(this.charArr[i]);
		}
	}
	
	// O(n)
	public MyString toUpper(MyString obj)
	{
		for (int i = 0; i < obj.curr_length; i++)
		{
			obj.charArr[i] = Character.toUpperCase(obj.charArr[i]);
		}
		
		return obj;
	}
	
	// O(n)
	public MyString toLower(MyString obj)
	{
		for (int i = 0; i < obj.curr_length; i++)
		{
			obj.charArr[i] = Character.toLowerCase(obj.charArr[i]);
		}
		
		return obj;
	}
	
	// O(n)
	public char[] subString(int a)
	{
		int newLength = this.curr_length - a;
		char[] ch = new char[newLength];
		
		for (int i = 0; i < newLength; i++)
		{
			ch[i] = this.charArr[i + a];
		}
		
		return ch;
	}
	
	// O(n)
	public char[] subString(int a, int b)
	{
		int newLength = b;
		char[] ch = new char[newLength];
		
		for (int i = 0; i < newLength; i++)
		{
			ch[i] = this.charArr[i + a];
		}
		
		return ch;
	}
	
	// O(n)
	public int indexOf(MyString obj)
	{
		for (int i = 0; i < obj.curr_length; i++)
		{
			if (obj.charArr[i] == this.charArr[i])
			{
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public int lastIndexOf(MyString obj)
	{
		for (int i = obj.curr_length - 1; i >= 0; i--)
		{
			if (obj.charArr[i] == this.charArr[i])
			{
				return i;
			}
		}
		return -1;
	}
}





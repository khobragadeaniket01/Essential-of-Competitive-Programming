/*
Palindromic Strings

A string is said to be a palindrome if it is the same if we start reading it 
from left to right or right to left. So let us consider a string “str”, 
now the task is just to find out with its reverse string is the same as it is.

Example:
Input : str = "abba" 
Output: Yes

Input : str = "geeks"
Output: No  
*/

import java.io.*;

class PString {
	public static boolean isPalindrome(String str)
	{
		// Initializing an empty string to store the reverse of the original str
		String rev = "";

		// Initializing a new boolean variable for the answer
		boolean ans = false;

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		// Checking if both the strings are equal
		if (str.equals(rev)) {
			ans = true;
		}
		return ans;
	}
	public static void main(String[] args)
	{
		// Input string
		String str = "geeks";

		// Convert the string to lowercase
		str = str.toLowerCase();
		boolean A = isPalindrome(str);
		System.out.println(A);
	}
}


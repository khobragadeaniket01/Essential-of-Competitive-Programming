/*
Reverse a string in Java
There are many ways to reverse String in Java. We can reverse String using 
StringBuffer, StringBuilder, iteration etc. Let's see the ways to reverse String in Java.

Following are some interesting facts about String and StringBuilder classes:

1. Objects of String are immutable.
2. String class in Java does not have reverse() method, however, the StringBuilder 
   class has built-in reverse() method
3. StringBuilder class do not have toCharArray() method, while String class does have 
   toCharArray() method.

*/

import java.io.*;
import java.util.Scanner;

class RString {
	public static void main (String[] args) {
		String str= "Geeks", nstr="";
		char ch;
	System.out.print("Original word: ");
	System.out.println("Geeks"); //Example word
		
	for (int i=0; i<str.length(); i++)
	{
		ch= str.charAt(i); //extracts each character
		nstr= ch+nstr; //adds each character in front of the existing string
	}
	System.out.println("Reversed word: "+ nstr);
	}
}

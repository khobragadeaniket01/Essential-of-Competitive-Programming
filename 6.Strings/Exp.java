/*

Reverse word in given String
Let’s see an approach to reverse words of a given String in Java without 
using any of the String library function Examples:

Input : "I love Java Programming"
Output :"Programming Java love I"
*/

import java.util.regex.Pattern;
public class Exp {

	// Method to reverse words of a String
	static String reverseWords(String str)
	{

		// Specifying the pattern to be searched
		Pattern pattern = Pattern.compile("\\s");

		// splitting String str with a pattern
		// (i.e )splitting the string whenever their is whitespace and store in temp array.
		String[] temp = pattern.split(str);
		String result = "";

		// Iterate over the temp array and store the string in reverse order.
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length - 1)
				result = temp[i] + result;
			else
				result = " " + temp[i] + result;
		}
		return result;
	}

	public static void main(String[] args)
	{
		String s1 = "I love Java Programming";
		System.out.println(reverseWords(s1));
	}
}

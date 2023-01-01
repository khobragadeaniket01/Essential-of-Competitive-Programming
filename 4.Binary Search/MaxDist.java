/*
Given an array with repeated elements, the task is to find the maximum distance 
between two occurrences of an element.

Examples:  
Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Output: 10
// maximum distance for 2 is 11-1 = 10 
// maximum distance for 1 is 4-2 = 2 
// maximum distance for 4 is 10-5 = 5  

A simple solution for this problem is to, one by one, pick each element from 
the array and find its first and last occurrence in the array and take the difference 
between the first and last occurrence for maximum distance. The time complexity 
for this approach is O(n2).

An efficient solution to this problem is to use hashing. The idea is to traverse the 
input array and store the index of the first occurrence in a hash map. For every other 
occurrence, find the difference between the index and the first index stored in the 
hash map. If the difference is more than the result so far, then update the result.
*/
// Java program to find maximum distance between two same occurrences of a number.
import java.io.*;
import java.util.*;

class MaxDist
{

	// Function to find maximum distance between equal elements
	static int maxDistance(int[] arr, int n)
	{
		// Used to store element to first index mapping
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// Traverse elements and find maximum distance between same occurrences with the help of map.
		int max_dist = 0;

		for (int i = 0; i < n; i++)
		{
			// If this is first occurrence of element, insert its index in map
			if (!map.containsKey(arr[i]))
				map.put(arr[i], i);

			// Else update max distance
			else
				max_dist = Math.max(max_dist, i - map.get(arr[i]));
		}

		return max_dist;
}
public static void main(String args[])
{
	int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
	int n = arr.length;
	System.out.println(maxDistance(arr, n));
}
}

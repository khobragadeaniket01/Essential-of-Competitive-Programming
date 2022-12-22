/*
Given an array which may contain duplicates, print all elements and their frequencies.
Input :  arr[] = {10, 20, 20, 10, 10, 20, 5, 20}
Output : 10 3
         20 4
         5  1

Input : arr[] = {10, 20, 20}
Output : 10 1
         20 2 

A simple solution is to run two loops. For every item count number of times, it occurs. 
To avoid duplicate printing, keep track of processed items. 

*/         

// Java program to count frequencies of array items
import java.util.Arrays;

class FrequencyArray
{
public static void countFreq(int arr[], int n)
{
	boolean visited[] = new boolean[n];
	
	Arrays.fill(visited, false);

	// Traverse through array elements and
	// count frequencies
	for (int i = 0; i < n; i++) {

		// Skip this element if already processed
		if (visited[i] == true)
			continue;

		// Count frequency
		int count = 1;
		for (int j = i + 1; j < n; j++) {
			if (arr[i] == arr[j]) {
				visited[j] = true;
				count++;
			}
		}
		System.out.println(arr[i] + " " + count);
	}
}

// Driver code
public static void main(String []args)
{
	int arr[] = new int[]{ 10, 20, 20, 10, 10, 20, 5, 20 };
	int n = arr.length;
	countFreq(arr, n);
}
}


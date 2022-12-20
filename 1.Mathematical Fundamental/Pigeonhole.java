/*
Pigeonhole Sorting is a sorting algorithm that is suitable for sorting lists of elements 
where the number of elements and the number of possible key values are approximately the same.
It requires O(n + Range) time where n is number of elements in input array and ‘Range’ is number
of possible values in array.

Working of Algorithm :

Find minimum and maximum values in array. Let the minimum and maximum values be ‘min’ and ‘max’ respectively. 
Also find range as ‘max-min-1’.
Set up an array of initially empty “pigeonholes” the same size as of the range.
Visit each element of the array and then put each element in its pigeonhole. 
An element arr[i] is put in hole at index arr[i] – min.
Start the loop all over the pigeonhole array in order and put the elements from non- empty holes back into 
the original array.
*/

// Java program to implement Pigeonhole Sort

import java.lang.*;
import java.util.*;

public class Pigeonhole {
	public static void pigeonhole_sort(int arr[],
									int n)
	{
		int min = arr[0];
		int max = arr[0];
		int range, i, j, index;

		for (int a = 0; a < n; a++) {
			if (arr[a] > max)
				max = arr[a];
			if (arr[a] < min)
				min = arr[a];
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for (i = 0; i < n; i++)
			phole[arr[i] - min]++;

		index = 0;

		for (j = 0; j < range; j++)
			while (phole[j]-- > 0)
				arr[index++] = j + min;
	}

	public static void main(String[] args)
	{
		GFG sort = new GFG();
		int[] arr = { 8, 3, 2, 7, 4, 6, 8 };

		System.out.print("Sorted order is : ");

		sort.pigeonhole_sort(arr, arr.length);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}


/*
Given two arrays, box[] and truck[], where box[i] represents the weight of the ith 
box and truck[i] represents the maximum load that the ith truck can carry. 
Now each truck takes 1 hour to transport a box from source to destination and 
another one hour to come back. Now, given that all the boxes are kept at the source, 
the task is to find the minimum time required to transport all the boxes from the source 
to the destination. 

Note that there will always be some time in which the boxes can be transported and only 
a single box can be carried by truck at any instance of time.

Examples:  

Input: box[] = {7, 6, 5, 4, 3}, truck[] = {10, 3} 
Output: 7 
1st hour: truck[0] carries box[0] and truck[1] carries box[4] 
2nd hour: Both trucks are back at the source location. 
Now, truck[1] cannot carry anymore boxes as all the remaining boxes 
have weights more than the capacity of a truck[1]. 
So, truck[0] will carry box[1] and box[2] 
in a total of four hours. (source-destination and then destination-source) 
And finally, box[3] will take another hour to reach the destination. 
So, total time taken = 2 + 4 + 1 = 7

Approach: 
The idea is to use binary search and sort the two arrays. 
Here the lower bound will be 0 and the upper bound will be 2 * size of box[] 
because in the worst case, the amount of time required to transport all the boxes will 
be 2 * size of box array. Now compute the mid-value, and for each mid-value check 
if all the boxes can be transported by the loaders in time = mid. If yes, then update 
the upper bound as mid – 1 and if not, then update the lower bound as mid + 1.
*/
// Java implementation of Minimum Capacity Transportation


import java.util.Arrays;

class MinCapacity
{

// Function that returns true if it is possible to transport all the boxes in the given amount of time
static boolean isPossible(int box[], int truck[],
				int n, int m, int min_time)
{
	int temp = 0;
	int count = 0;

	while (count < m)
	{
		for (int j = 0; j < min_time
						&& temp < n
						&& truck[count] >= box[temp];
			j += 2)
			temp++;

		count++;
	}

	// If all the boxes can be transported in the given time
	if (temp == n)
		return true;

	// If all the boxes can't be transported in the given time
	return false;
}

// Function to return the minimum time required
static int minTime(int box[], int truck[], int n, int m)
{

	// Sort the two arrays
	Arrays.sort(box);
	Arrays.sort(truck);

	int l = 0;
	int h = 2 * n;

	// Stores minimum time in which all the boxes can be transported
	int min_time = 0;

	// Check for the minimum time in which all the boxes can be transported
	while (l <= h) {
		int mid = (l + h) / 2;

		// If it is possible to transport all the boxes in mid amount of time
		if (isPossible(box, truck, n, m, mid))
		{
			min_time = mid;
			h = mid - 1;
		}
		else
			l = mid + 1;
	}

	return min_time;
}

public static void main(String[] args)
{
	int box[] = { 10, 2, 16, 19 };
	int truck[] = { 29, 25 };

	int n = box.length;
	int m = truck.length;

	System.out.printf("%d", minTime(box, truck, n, m));
}
}


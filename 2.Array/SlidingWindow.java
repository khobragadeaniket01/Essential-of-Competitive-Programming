/*
Window Sliding Technique is a computational technique which aims to reduce the use of nested loop 
and replace it with a single loop, thereby reducing the time complexity.
What is Sliding Window?
Consider a long chain connected together. Suppose you want to apply oil in the complete chain with 
your hands, without pouring the oil from above.
One way to do so is to: 
pick some oil, 
apply onto a section of chain, 
then again pick some oil
then apply it to the next section where oil is not applied yet
and so on till the complete chain is oiled.
Another way to do so, is to use a cloth, dip it in oil, and then hold onto one end of the chain with this cloth. 
Then instead of re-dipping it again and again, just slide the cloth with hand onto the next section, and next, 
and so on till the other end.
The second way is known as the Sliding window technique and the portion which is slided from one end to end, 
is known as Sliding Window.
*/

// Java code O(n*k) solution for finding maximum sum of a subarray of size k
class SlidingWindow {
	// Returns maximum sum in
	// a subarray of size k.
	static int maxSum(int arr[], int n, int k)
	{
		// Initialize result
		int max_sum = Integer.MIN_VALUE;

		// Consider all blocks starting with i.
		for (int i = 0; i < n - k + 1; i++) {
			int current_sum = 0;
			for (int j = 0; j < k; j++)
				current_sum = current_sum + arr[i + j];

			// Update result if required.
			max_sum = Math.max(current_sum, max_sum);
		}

		return max_sum;
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		int n = arr.length;
		System.out.println(maxSum(arr, n, k));
	}
}


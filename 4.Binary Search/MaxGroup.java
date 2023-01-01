/*
Given n instance of item A and m instance of item B. 
Find the maximum number of groups of size 3 that can be formed using these 
items such that all groups contain items of both types, i.e., a group should not 
have either all items of type A or all items of type B. 
Total number of items of type A in the formed groups must be less than or equal to n. 
Total number of items of type B in the formed groups must be less than or equal to m.
Example:
Input : n = 2 and m = 6.
Output : 2
In group 1, one item of type A and two items of
type B. Similarly, in the group 2, one item of 
type A and two items of type B.
We have used 2 (<= n) items of type A and 4 (<= m)
items of type B.
Observation: 
1. There will be n groups possible if m >= 2n. Or there will be m groups possible, 
if n >= 2m. 
2. Suppose n = 3 and m = 3, so one instance of item A will make a group with the 
two instance of item B and one instance of item B will make a group with the two 
instance of item A. So, maximum two groups are possible. So find the total number 
of such conditions with given n and m by dividing m and m by 3. After this, 
there can be 0, 1, 2 instances of each type can be left. For finding the number of 
groups for the left instances: 
     a) If n = 0 or m = 0, 0 group is possible. 
     b) If n + m >= 3, only 1 group is possible.

Algorithm for solving this problem: 
1. If n >= 2m, maximum number of groups = n. 
2. Else if m >= 2n, maximum number of groups = m. 
3. Else If (m + n) % 3 == 0, maximum number of group = (m + n)/3; 
4. Else maximum number of group = (n + m)/3. And set n = n%3 and m = m%3. 
     a) If n != 0 && m != 0 && (n + m) >= 3, add one to maximum number of groups.
*/

// Java program to calculate maximum number of groups

import java.io.*;

public class MaxGroup{
static int maxGroup(int n, int m)
{
	if (n >= 2 * m)
		return n;
	if (m >= 2 * n)
		return m;
	if ((m + n) % 3 == 0)
		return (m + n) / 3;

	int ans = (m + n) / 3;
	m %= 3;
	n %= 3;

	if (m > 0 && n > 0 && (m + n) >= 3)
		ans++;

	return ans;
}

	static public void main (String[] args)
	{
			int n = 4, m = 5;
	System.out.println(maxGroup(n, m));
	}
}


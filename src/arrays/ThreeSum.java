package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
 * output and the order of the triplets does not matter.
 * 
 * https://leetcode.com/problems/3sum/description/
 */

public class ThreeSum {
	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };

		List<List<Integer>> threeSum = threeSum(nums);
		System.out.println(threeSum);

	}

	/**
	 * 🔹 Complexity Analysis
	 * 
	 * Sorting: O(n log n)
	 * 
	 * Outer loop (i): runs n times
	 * 
	 * Two-pointer inner loop: runs O(n) in worst case
	 * 
	 * Total: O(n^2)
	 * 
	 * 👉 Time Complexity: O(n^2) 👉 Space Complexity: O(1) (ignoring output list,
	 * since we store results only)
	 */
	static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		int n = arr.length;
		if (n == 0)
			return result;

		Arrays.sort(arr);

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;

			if (i > 0 && arr[i] == arr[i - 1])
				continue;

			while (left < right) {

				int sum = arr[i] + arr[left] + arr[right];

				if (sum == 0) {
					result.add(List.of(arr[i], arr[left], arr[right]));

					while (left < right && arr[left] == arr[left + 1])
						left++;
					while (left < right && arr[right] == arr[right - 1])
						right--;

					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}

			}
		}
		return result;
	}

	/**
	 * 🔹 Dry Run Example
	 * 
	 * Input:
	 * 
	 * int[] arr = {-1, 0, 1, 2, -1, -4};
	 * 
	 * Step 1: Sort array
	 * 
	 * arr = {-4, -1, -1, 0, 1, 2}
	 * 
	 * Step 2: Iteration i = 0 → arr[i] = -4
	 * 
	 * left = 1 (-1), right = 5 (2)
	 * 
	 * sum = -4 + (-1) + 2 = -3 → sum < 0 → move left → left = 2
	 * 
	 * left = 2 (-1), right = 5 (2)
	 * 
	 * sum = -4 + (-1) + 2 = -3 → still < 0 → left = 3
	 * 
	 * left = 3 (0), right = 5 (2)
	 * 
	 * sum = -4 + 0 + 2 = -2 → left++ → left = 4
	 * 
	 * left = 4 (1), right = 5 (2)
	 * 
	 * sum = -4 + 1 + 2 = -1 → left++ → left = 5 → stops
	 * 
	 * No triplets found for i=0.
	 * 
	 * i = 1 → arr[i] = -1
	 * 
	 * left = 2 (-1), right = 5 (2)
	 * 
	 * sum = -1 + (-1) + 2 = 0 ✅ → triplet = [-1, -1, 2]
	 * 
	 * skip duplicates for left/right
	 * 
	 * left=3, right=4
	 * 
	 * left = 3 (0), right = 4 (1)
	 * 
	 * sum = -1 + 0 + 1 = 0 ✅ → triplet = [-1, 0, 1]
	 * 
	 * left=4, right=3 → stops
	 * 
	 * i = 2 → arr[i] = -1 (duplicate of arr[1])
	 * 
	 * Skip because arr[i] == arr[i-1].
	 * 
	 * i = 3 → arr[i] = 0
	 * 
	 * left = 4 (1), right = 5 (2)
	 * 
	 * sum = 0 + 1 + 2 = 3 → sum > 0 → right--
	 * 
	 * Now left=4, right=4 → stops
	 * 
	 * ✅ Final Result: [[-1, -1, 2], [-1, 0, 1]]
	 */

}

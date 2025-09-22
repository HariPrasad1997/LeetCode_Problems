package arrays;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray
 * [4,-1,2,1] has the largest sum 6. Example 2:
 * 
 * Input: nums = [1] Output: 1 Explanation: The subarray [1] has the largest sum
 * 1. Example 3:
 * 
 * Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray [5,4,-1,7,8]
 * has the largest sum 23.
 * 
 * https://leetcode.com/problems/maximum-subarray/description/
 */

public class MaximumSubarray {
	public static void main(String[] args) {

		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maximumSum = findMaxSumOfSubArray(nums);
		System.out.println(maximumSum);

	}

	/**
	 * Explanation: Kadane’s algorithm tracks the maximum sum ending at each posi-
	 * tion, choosing to start anew or extend the subarray. Handles negative numbers
	 * and single-element arrays.
	 * 
	 * TC: O(n) - Single pass through the array. SC: O(1) - Only two variables used.
	 */
	static int findMaxSumOfSubArray(int[] nums) {
		int currentSum = nums[0];
		int maxSum = nums[0];
		int n = nums.length;

		for (int i = 1; i < n; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

	/**
	 * 🔹 Dry Run Example Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
	 * 
	 * Initialization: currentSum = nums[0] = -2 maxSum = -2
	 * 
	 * Loop Iteration i = 1 → nums[1] = 1 currentSum = max(1, -2 + 1) = max(1, -1) =
	 * 1 maxSum = max(-2, 1) = 1
	 * 
	 * i = 2 → nums[2] = -3 currentSum = max(-3, 1 + (-3)) = max(-3, -2) = -2 maxSum
	 * = max(1, -2) = 1
	 * 
	 * i = 3 → nums[3] = 4 currentSum = max(4, -2 + 4) = max(4, 2) = 4 maxSum =
	 * max(1, 4) = 4
	 * 
	 * i = 4 → nums[4] = -1 currentSum = max(-1, 4 + (-1)) = max(-1, 3) = 3 maxSum =
	 * max(4, 3) = 4
	 * 
	 * i = 5 → nums[5] = 2 currentSum = max(2, 3 + 2) = max(2, 5) = 5 maxSum =
	 * max(4, 5) = 5
	 * 
	 * i = 6 → nums[6] = 1 currentSum = max(1, 5 + 1) = max(1, 6) = 6 maxSum =
	 * max(5, 6) = 6
	 * 
	 * i = 7 → nums[7] = -5 currentSum = max(-5, 6 + (-5)) = max(-5, 1) = 1 maxSum =
	 * max(6, 1) = 6
	 * 
	 * i = 8 → nums[8] = 4 currentSum = max(4, 1 + 4) = max(4, 5) = 5 maxSum =
	 * max(6, 5) = 6
	 * 
	 * ✅ Final Answer: maxSum = 6
	 * 
	 * 
	 * And the subarray is [4, -1, 2, 1].
	 * 
	 * 🔹 Time and Space Complexity
	 * 
	 * Time Complexity: O(n) (single pass)
	 * 
	 * Space Complexity: O(1) (just two variables used)
	 */

}

package arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: [0]
 * 
 * https://leetcode.com/problems/move-zeroes/description/
 */

public class MoveZerosAtEndOfArray {
	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 3, 12 };

		int[] result = moveZeros(arr);
		System.out.println(Arrays.toString(result));

	}

	/*
	 * 🔹 Time Complexity (TC)
	 * 
	 * First loop (for (int num : arr))
	 * 
	 * Iterates over all n elements once. → O(n)
	 * 
	 * Second loop (while (inserPosition < arr.length))
	 * 
	 * At worst, runs for remaining positions (when many non-zeros are there, fewer
	 * iterations).
	 * 
	 * Still, at most n iterations. → O(n)
	 * 
	 * So total = O(n) + O(n) = O(n)
	 * 
	 * ✅ TC = O(n)
	 * 
	 * Space Complexity: O(1)
	 */
	static int[] moveZeros(int[] arr) {
		int inserPosition = 0;

		for (int num : arr) {
			if (num != 0) {
				arr[inserPosition++] = num;
			}
		}
		while (inserPosition < arr.length) {
			arr[inserPosition++] = 0;
		}

		return arr;
	}
}

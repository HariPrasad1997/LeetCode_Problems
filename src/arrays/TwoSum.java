package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 */

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 11 };
		int target = 9;

		int[] result = twoSum(arr, target);
		// Check if result is empty or not before printing
		if (result.length == 0) {
			System.out.println("No solution found");
		} else {
			// Print the result
			System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
		}
	}

	/*
	 * Time Complexity (TC): O(n) - Single pass through the array with O(1) hash map
	 * operations. Space Complexity (SC): O(n) - Hash map stores up to n elements.
	 */
	private static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int compliment = target - num;
			if (map.containsKey(compliment)) {
				return new int[] { map.get(compliment), i };
			}

			map.put(num, i);
		}

		return new int[0];

	}

}

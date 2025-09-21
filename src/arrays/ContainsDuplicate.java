package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		boolean containsDuplicates = isContainsDuplicates(nums); // Output: Array contains duplicates: true
		if (containsDuplicates) {
			System.out.println("Array contains duplicates: " + containsDuplicates);

		} else {
			System.out.println("No duplicates present in array" + containsDuplicates);
		}

	}

	/**
	 * Explanation: Use a hash set to track seen numbers, returning true if a number
	 * is already present. Optimizes from O(n²) or O(n log n) with sorting. Handles
	 * empty arrays.
	 * 
	 * TC: O(n) - Single pass with O(1) hash set operations. SC: O(n) - Hash set
	 * stores up to n elements.
	 */
	static boolean isContainsDuplicates(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			}
			set.add(num);
		}
		return false;
	}

}

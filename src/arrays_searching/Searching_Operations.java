package arrays_searching;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not
 * exist in nums so return -1
 * 
 * https://leetcode.com/problems/binary-search/description/
 */

public class Searching_Operations {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 7, 8, 3, 6 };
		int target = 7;
		System.out.println(target + " element is present at index :" + linearSearch(arr, target));
		System.out.println("Linear Search with Recursion: " + linearSearchWithRecursion(arr, 0, target));
		System.out.println("Binary Search: " + binarySearch(arr, target));
	}

	/**
	 * Time Complexity (TC): O(n)
	 * 
	 * Space Complexity (SC): O(1) (just a loop variable)
	 */
	static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Time Complexity (TC): O(n) (same as iterative).
	 * 
	 * Space Complexity (SC): O(n) because of recursive function calls (call stack
	 * grows with each call).
	 */
	static int linearSearchWithRecursion(int[] arr, int index, int target) {
		int n = arr.length;
		if (index >= n) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		}

		return linearSearchWithRecursion(arr, index + 1, target);
	}

	/**
	 * 🔎 Time Complexity (TC)
	 * 
	 * Each iteration halves the search range:
	 * 
	 * 1st step → n elements
	 * 
	 * 2nd step → n/2 elements
	 * 
	 * 3rd step → n/4 elements
	 * 
	 * … until 1 element remains
	 * 
	 * That gives:
	 * 
	 * 𝑇 ( 𝑛 ) = 𝑂 ( log ⁡ 𝑛 ) T(n)=O(logn)
	 * 
	 * ✅ Best case: O(1) (if target found at the first mid check) ✅ Worst case:
	 * O(log n) (keep halving until element not found or last index checked)
	 */
	static int binarySearch(int[] arr, int target) {
		int n = arr.length;

		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}

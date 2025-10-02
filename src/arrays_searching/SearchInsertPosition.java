package arrays_searching;

/**
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5 Output: 2
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2 Output: 1
 * 
 * 
 * Example 3:
 * 
 * Input: nums = [1,3,5,6], target = 7 Output: 4
 * 
 * https://leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 6 };
		int target = 7;
		System.out.println("Using linear search Element inserted at index: " + linearSearchInsert(arr, target));
		System.out.println("Using binary search Element inserted at index: " + binarySearchInsert(arr, target));

	}

	/**
	 * Time Complexity (TC):
	 * 
	 * Worst case → traverse all n elements → O(n)
	 * 
	 * Best case → target at index 0 → O(1)
	 * 
	 * Average case → about half the array → O(n)
	 * 
	 * Space Complexity (SC):
	 * 
	 * Uses only a few variables (i, n) → O(1)
	 */
	static int linearSearchInsert(int[] arr, int target) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] >= target) {
				return i;
			}
		}
		return n;
	}

	/**
	 * Time Complexity (TC):
	 * 
	 * Each step halves the search range → O(log n)
	 * 
	 * Best case → found in first check → O(1)
	 * 
	 * Worst case → keep halving until 1 element left → O(log n)
	 * 
	 * Space Complexity (SC):
	 * 
	 * Iterative version → only a few variables (left, right, mid) → O(1)
	 * 
	 * Recursive version → due to call stack → O(log n)
	 */
	static int binarySearchInsert(int[] arr, int target) {
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
		return left;
	}

}

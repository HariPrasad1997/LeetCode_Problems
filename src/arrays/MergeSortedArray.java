package arrays;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 * 
 * https://leetcode.com/problems/merge-sorted-array/description/
 */

/**
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output:
 * [1,2,2,3,5,6] Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * 
 * Example 2:
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1] Explanation: The
 * arrays we are merging are [1] and []. The result of the merge is [1].
 * 
 * Example 3:
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1 Output: [1] Explanation: The
 * arrays we are merging are [] and [1]. The result of the merge is [1]. Note
 * that because m = 0, there are no elements in nums1. The 0 is only there to
 * ensure the merge result can fit in nums1.
 */

public class MergeSortedArray {
	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] arr2 = { 2, 5, 6 };
		int n = 3;

		mergeSortedArray(arr1, m, arr2, n);

		System.out.println("Merged array: " + Arrays.toString(arr1)); // Output: Merged array: [1, 2, 2, 3, 5, 6]

	}

	/**
	 * Explanation: Merge from the end to avoid overwriting elements in nums1, com-
	 * paring the largest elements and placing them at the end. Handles cases where
	 * one array is empty.
	 * 
	 * TC: O(m + n) - Process each element once. SC: O(1) - In-place merging.
	 */
	static void mergeSortedArray(int[] arr1, int m, int[] arr2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (arr1[i] > arr2[j]) {
				arr1[k--] = arr1[i--];
			} else {
				arr1[k--] = arr2[j--];
			}

		}

		while (j >= 0) {
			arr1[k--] = arr2[j--];
		}
	}

}

package arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. Then return the
 * number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you
 * need to do the following things:
 * 
 * Change the array nums such that the first k elements of nums contain the
 * unique elements in the order they were present in nums initially. The
 * remaining elements of nums are not important as well as the size of nums.
 * Return k. Custom Judge:
 * 
 * The judge will test your solution with the following code:
 * 
 * int[] nums = [...]; // Input array int[] expectedNums = [...]; // The
 * expected answer with correct length
 * 
 * int k = removeDuplicates(nums); // Calls your implementation
 * 
 * assert k == expectedNums.length; for (int i = 0; i < k; i++) { assert nums[i]
 * == expectedNums[i]; } If all assertions pass, then your solution will be
 * accepted.
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2 };

		System.out.println(removeDuplicates(arr));
	}

	
	/*
	 * ✅ Time Complexity (TC)
	 * 
	 * The loop runs once through the array (j = 1 → n-1).
	 * 
	 * Each comparison and assignment takes O(1).
	 * 
	 * 𝑇 𝐶 = 𝑂 ( 𝑛 ) TC=O(n) ✅ Space Complexity (SC)
	 * 
	 * No extra array or data structure used.
	 * 
	 * Just two pointers (i, j).
	 * 
	 * 𝑆 𝐶 = 𝑂 ( 1 ) SC=O(1)
	 */
	static int removeDuplicates(int[] arr) {
		int i = 0;

		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}

		return i + 1;
	}

}

package arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */

/**
 * Complexity
 * 
 * Time: O(n) — two linear passes over the array (left-products +
 * right-products).
 * 
 * Space: O(1) extra (excluding the output array result). We reuse result to
 * store left-products, and only one scalar rightProduct is used extra. If you
 * count the output, space is O(n).
 */

public class ProductOfArrayExceptItself {
	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		int[] result = productOfArrayExceptItself(nums);
		System.out.println(Arrays.toString(result)); // Output: [24, 12, 8, 6]

	}

	static int[] productOfArrayExceptItself(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];

		if (n == 0)
			return new int[0];
		// Build left-products: result[i] will hold product of all elements to the left
		// of i
		result[0] = 1;
		for (int i = 1; i < n; i++) {
			result[i] = result[i - 1] * nums[i - 1]; // [1, 1, 2, 6]
		}

		// rightProduct holds product of all elements to the right of current index
		int rightProduct = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] = result[i] * rightProduct; // combine left-product (in result) with right-product
			rightProduct = rightProduct * nums[i]; // include nums[i] into rightProduct for next iteration (moving left)

		}
		return result;
	}

	/**
	 * Dry run 1 — example nums = [1, 2, 3, 4]
	 * 
	 * Initial:
	 * 
	 * n = 4
	 * 
	 * result = [0,0,0,0]
	 * 
	 * First loop (left-products):
	 * 
	 * result[0] = 1 → result = [1,0,0,0]
	 * 
	 * i=1: result[1] = result[0] * nums[0] = 1 * 1 = 1 → result = [1,1,0,0]
	 * 
	 * i=2: result[2] = result[1] * nums[1] = 1 * 2 = 2 → result = [1,1,2,0]
	 * 
	 * i=3: result[3] = result[2] * nums[2] = 2 * 3 = 6 → result = [1,1,2,6]
	 * 
	 * Second loop (right-products):
	 * 
	 * rightProduct = 1
	 * 
	 * i=3: result[3] = 6 * 1 = 6; then rightProduct = 1 * nums[3] = 1 * 4 = 4 →
	 * result = [1,1,2,6]
	 * 
	 * i=2: result[2] = 2 * 4 = 8; then rightProduct = 4 * nums[2] = 4 * 3 = 12 →
	 * result = [1,1,8,6]
	 * 
	 * i=1: result[1] = 1 * 12 = 12; then rightProduct = 12 * nums[1] = 12 * 2 = 24
	 * → result = [1,12,8,6]
	 * 
	 * i=0: result[0] = 1 * 24 = 24; then rightProduct = 24 * nums[0] = 24 * 1 = 24
	 * → result = [24,12,8,6]
	 * 
	 * Final output: [24, 12, 8, 6] — correct.
	 */

}

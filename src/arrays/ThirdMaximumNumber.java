package arrays;

/**
 * Given an integer array nums, return the third distinct maximum number in this
 * array. If the third maximum does not exist, return the maximum number.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,1] Output: 1 Explanation: The first distinct maximum is 3.
 * The second distinct maximum is 2. The third distinct maximum is 1.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2] Output: 2 Explanation: The first distinct maximum is 2.
 * The second distinct maximum is 1. The third distinct maximum does not exist,
 * so the maximum (2) is returned instead.
 * 
 * 
 * Example 3:
 * 
 * Input: nums = [2,2,3,1] Output: 1 Explanation: The first distinct maximum is
 * 3. The second distinct maximum is 2 (both 2's are counted together since they
 * have the same value). The third distinct maximum is 1.
 */

public class ThirdMaximumNumber {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3 };

		System.out.println("Third Maximum number is: " + findThirdMaximumNumber(nums));
	}

	/**
	 * Time Complexity: Θ(n) (worst-case O(n), best-case Ω(n)) — linear in the
	 * number of elements.
	 * 
	 * Space Complexity: Θ(1) (O(1)) — constant extra space.
	 */
	static int findThirdMaximumNumber(int[] nums) {
		long max = Long.MIN_VALUE;
		long secondMax = Long.MIN_VALUE;
		long thirdMax = Long.MIN_VALUE;

		for (int num : nums) {
			if (num == max || num == secondMax || num == thirdMax) {
				continue;
			}

			if (num > max) {
				thirdMax = secondMax;
				secondMax = max;
				max = num;
			} else if (num > secondMax) {
				thirdMax = secondMax;
				secondMax = num;
			} else if (num > thirdMax) {
				thirdMax = num;
			}
		}

		return thirdMax == Long.MIN_VALUE ? (int) max : (int) thirdMax;
	}
	
//	DRY RUN 
//	
//	| Input     | max | secondMax | thirdMax | Returned |
//	| --------- | --- | --------- | -------- | -------- |
//	| [3,2,1]   | 3   | 2         | 1        | 1 ✅      |
//	| [1,2]     | 2   | 1         | -∞       | 2 ✅      |
//	| [2,2,3,1] | 3   | 2         | 1        | 1 ✅      |
//	| [1,2,2,3] | 3   | 2         | 1        | 1 ✅      |


}

package arrays;

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
 * Input: nums = [1,3,5,6], target = 5 Output: 2 Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2 Output: 1 Example 3:
 * 
 * Input: nums = [1,3,5,6], target = 7 Output: 4
 */

public class SearchInsertPosition {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5, 6 };
		int target = 5;

		int result = searchInsert(nums, target);
		System.out.println("Index postion for inserting: " + target + " is " + result);

	}

	/**
	 * Time Complexity (TC)
	 * 
	 * Each iteration of the while (left <= right) loop halves the search space.
	 * 
	 * That means the number of iterations is log₂(n) where n = nums.length.
	 * 
	 * ✅ TC = O(log n)
	 * 
	 * 🔹 Space Complexity (SC)
	 * 
	 * You’re using only a few integer variables: left, right, mid.
	 * 
	 * No extra arrays or data structures created.
	 * 
	 * ✅ SC = O(1)
	 */
	static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}

package arrays_sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] nums = { 5, 4, 3, 2, 1 };

		System.out.println("Before sorting: " + Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println("After sorting: " + Arrays.toString(nums));
	}

	static void bubbleSort(int[] nums) {
		int n = nums.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			for (int j = 0; j < n - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	/**
	 * Pass 0
	 * 
	 * Compare (5,4) → swap → 4, 5, 3, 2, 1
	 * 
	 * Compare (5,3) → swap → 4, 3, 5, 2, 1
	 * 
	 * Compare (5,2) → swap → 4, 3, 2, 5, 1
	 * 
	 * Compare (5,1) → swap → 4, 3, 2, 1, 5 ✅ (largest bubbled to last)
	 * 
	 * Result after Pass 0: 4, 3, 2, 1, 5
	 * 
	 * Pass 1
	 * 
	 * Compare (4,3) → swap → 3, 4, 2, 1, 5
	 * 
	 * Compare (4,2) → swap → 3, 2, 4, 1, 5
	 * 
	 * Compare (4,1) → swap → 3, 2, 1, 4, 5 ✅ (second largest bubbled to 2nd last)
	 * 
	 * Result after Pass 1: 3, 2, 1, 4, 5
	 * 
	 * Pass 2
	 * 
	 * Compare (3,2) → swap → 2, 3, 1, 4, 5
	 * 
	 * Compare (3,1) → swap → 2, 1, 3, 4, 5
	 * 
	 * Compare (3,4) → no swap → 2, 1, 3, 4, 5
	 * 
	 * Result after Pass 2: 2, 1, 3, 4, 5
	 * 
	 * Pass 3
	 * 
	 * Compare (2,1) → swap → 1, 2, 3, 4, 5
	 * 
	 * Compare (2,3) → no swap → 1, 2, 3, 4, 5
	 * 
	 * Result after Pass 3: 1, 2, 3, 4, 5 ✅ Sorted!
	 */

}

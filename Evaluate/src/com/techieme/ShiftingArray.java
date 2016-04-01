package com.techieme;

public class ShiftingArray {
	
	// Problem : https://github.com/codingforinterviews/practice-problems/tree/master/array_rotate

	public void shift_arr(int[] arr, int n, int newIndex) {
		if (newIndex < arr.length) {
			int subtractIndex = newIndex;
			if (subtractIndex >= n) {
				subtractIndex = (arr.length -1) - (n - subtractIndex);
			}
			int currIndex = Math.abs((arr.length -1) - subtractIndex);
			int tempnewIndex = newIndex;
			int tempValue = arr[currIndex];
			++newIndex;
			shift_arr(arr, n, newIndex);
			arr[tempnewIndex] = tempValue;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5,7,8, 9};
//		for (int value : arr) {
//			System.out.println("Old value is : " + value);
//		}
		ShiftingArray shiftingArray = new ShiftingArray();
		shiftingArray.shift_arr(arr, 3, 0);
		for (int value : arr) {
			System.out.println("New value is : " + value);
		}
		
	}

}

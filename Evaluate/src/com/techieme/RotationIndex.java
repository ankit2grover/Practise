package com.techieme;

public class RotationIndex {

	public void rotate_binary(int[] arr) {
		int end = arr.length -1;
		int start = 0;
		while (end > start) {
			int mid = ((end - start) / 2);
			if (mid > 0) {
				mid = mid + start;
				if (arr[start] > arr[mid]) {
					end = mid;
				} else if (arr[end] < arr[mid]) {
					start = mid;
				} else {
					System.out.println("Starting rotation index is + " + mid + 1);
				}
			} else {
				if (arr[end] < arr[start] ) {
					System.out.println("Index is = " + end + "value is = " + arr[end]);
					
				}
				break;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		RotationIndex rotIndex = new RotationIndex();
		int[] arr = new int[] {10,11, 14, 17, 34, 89, 91, 101, 9};
		rotIndex.rotate_binary(arr);
	}
}

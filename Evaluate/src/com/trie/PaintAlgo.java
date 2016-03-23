package com.trie;

public class PaintAlgo {

	int[][] newArr = new int[4][4];
	public static void main(String[] args) {
		int[][] arr = new int[][] {{0,1,2,3}, {4,6,6,6}, {5,6,6,2}, {6,6,6,3}};
		PaintAlgo paintAlgo = new PaintAlgo();
		paintAlgo.paintAlgo(arr, 3, 1,1);
		for(int i = 0; i < 4; i++)
		   {
		      for(int j = 0; j < 4; j++)
		      {
		    	  System.out.println("Array " + i + "Item : " + arr[i][j]);
		      }
		   }
	}
	
	public void  paintAlgo(int[][] arr, int replaceDigit, int x, int y) {
		if (x < 4 && y < 4) {
				arr[x][y] = arr[x][y];
				if (arr[x][y] == 6) {
					if (y < 4) {
						int newY = y + 1;
						paintAlgo(arr, replaceDigit, x, newY);
					} 
					if (x < 4) {
						int newX = x + 1;
						paintAlgo(arr, replaceDigit, newX, y);
					}
					arr[x][y] = replaceDigit;
				}
				
		}
				
	}
}

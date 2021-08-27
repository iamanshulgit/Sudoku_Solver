package Main;

import PrintArray.PrintArray;
public class sudoku_solver {

	public static boolean checkRow(int[][] a, int i, int val) {
		for(int k = 0; k < a.length; k++) {
			if(a[i][k]==val) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkCol(int[][] a, int j, int val) {
		for(int k = 0; k < a[0].length; k++) {
			if(a[k][j]==val) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkBox(int[][] a, int i, int j, int val) {
		int irow = i-i%3;
		int jcol = j-j%3;
		
		for(int k = irow; k < irow+3; k++) {
			for(int l = jcol; l < jcol+3; l++) {
				if(a[irow][jcol]==val) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solve(int[][]a) {

		for(int i = 0; i < a.length;i++) {
			for(int j = 0 ; j < a.length; j++) {
				if(a[i][j]==0) {
				for( int val = 1 ; val < 10; val++) {
					if(checkRow(a,i,val) && checkCol(a,j,val) && checkBox(a,i,j,val)) {
						a[i][j] = val;
						if(solve(a)) {
							return true;
						}
						else {
						a[i][j] = 0;
						}
					}
				}
			}
		}
			PrintArray.printArray(a);
		}
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] puzzle = {
				{0,0,7,2,3,8,6,5,0},
				{4,0,3,0,5,1,7,0,0},
				{0,5,0,6,0,0,0,0,9},
				{0,0,0,0,0,0,0,9,0},
				{7,8,0,4,0,9,0,2,6},
				{0,1,0,0,0,0,0,0,0},
				{5,0,0,0,0,4,0,1,0},
				{0,0,1,5,7,0,9,0,8},
				{0,4,8,1,9,3,5,0,0}
		};
		int[][] board = new int[][] {
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }
		};
		solve(board);
		PrintArray.printArray(board);
		
	}

}

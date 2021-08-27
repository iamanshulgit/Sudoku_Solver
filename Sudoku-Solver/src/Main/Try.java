package Main;

 class Try
{
	public static boolean isSafe(int[][] board,
								int row, int col,
								int num)
	{

		for (int d = 0; d < board.length; d++)
		{

			if (board[row][d] == num) {
				return false;
			}
		}

		for (int r = 0; r < board.length; r++)
		{
			if (board[r][col] == num)
			{
				return false;
			}
		}

		int sqrt = (int)Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart;
			r < boxRowStart + sqrt; r++)
		{
			for (int d = boxColStart;
				d < boxColStart + sqrt; d++)
			{
				if (board[r][d] == num)
				{
					return false;
				}
			}
		}

		return true;
	}

	public static boolean solveSudoku(
		int[][] board, int n)
	{
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (board[i][j] == 0)
				{
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}

		if (isEmpty)
		{
			return true;
		}

		for (int num = 1; num <= n; num++)
		{
			if (isSafe(board, row, col, num))
			{
				board[row][col] = num;
				if (solveSudoku(board, n))
				{
					// print(board, n);
					return true;
				}
				else
				{
					// replace it
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static void print(
		int[][] board, int N)
	{
		
		// We got the answer, just print it
		for (int r = 0; r < N; r++)
		{
			for (int d = 0; d < N; d++)
			{
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int)Math.sqrt(N) == 0)
			{
				System.out.print("");
			}
		}
	}

	public static void main(String args[])
	{

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
		int N = puzzle.length;

		if (solveSudoku(puzzle, N))
		{
			// print solution
			print(puzzle, N);
		}
		else {
			System.out.println("No solution");
		}
	}
}

public class Queen {
 
	int[] chessRow;
	int numTries = 0;
	boolean finished = false;
	boolean firstKnightRound = false;

	public Queen(int n) { 
		chessRow = new int[n];
	}
	
	public static void main(String args[]) {
		Queen Q = new Queen(10);
		Q.startPlace();
	}
	
	public void startPlace() {
		placeQueens(0, chessRow.length);
	}
	
	public void placeQueens(int row, int n) {
		numTries++;

		/* set the first row to the secound field */
		if (n % 2 == 0) {
			chessRow[0] = 1;
		}

		for (int column = 0; column < n; column++) {

			if (row >= 1) {
				if (chessRow[row - 1] + 2 <= n && firstKnightRound == false) {
					column = chessRow[row - 1] + 2;
				} else if (chessRow[row - 1] + 2 > n) {
					firstKnightRound = true;

				}
			}

			if (checkPositionQueen(row, column)) {
				chessRow[row] = column;
				/*
				 * skip the next column bc thats not possible to set the queen
				 * there
				 */
				column++;

				if (row == n - 1) {
					printResult(chessRow);
					return;
				} else {
					if (finished == false) {
						placeQueens(row + 1, n);
					}
				}
			}
		}
	}

	public boolean checkPositionQueen(int row, int column) {

		for (int i = 0; i < row; i++) {
			if (chessRow[i] == column || (i - row) == (chessRow[i] - column) || (i - row) == (column - chessRow[i])) {
				return false;
			}
		}
		return true;
	} 

	public void printResult(int[] queens) {
		int N = queens.length;
		
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				if (queens[row] == column) {
					System.out.print("O ");

				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
		System.out.println(); 

		finished = true;

	}

}

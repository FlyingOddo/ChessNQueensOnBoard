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
		Q.placeQueen();
	}
	
	public void callplaceQueens() {
		placeQueen(0, chessRow.length);
	}
	
	public void placeQueens(int r, int n) {
		numTries++;

		/* set the first row to the secound field */
		if (n % 2 == 0) {
			chessRow[0] = 1;
		}

		for (int c = 0; c < n; c++) {

			if (r >= 1) {
				if (chessRow[r - 1] + 2 <= n && firstKnightRound == false) {
					c = chessRow[r - 1] + 2;
				} else if (chessRow[r - 1] + 2 > n) {
					firstKnightRound = true;

				}
			}

			if (checkPositionQueen(r, c)) {
				chessRow[r] = c;
				/*
				 * skip the next column bc thats not possible to set the queen
				 * there
				 */
				c++;

				if (r == n - 1) {
					printResult(chessRow);
					return;
				} else {
					if (finished == false) {
						placeQueens(r + 1, n);
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
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (queens[i] == j) {
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

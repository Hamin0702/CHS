
public class Board {

	private int[][] board;
	
	private int SIZE = 8;
	public static final int EMPTY = 0;
	public static final int QUEEN = 1;
	public static final int RESTRICTED = -1;

	Board() {
		board = new int[SIZE][SIZE];
	}
	
	Board(int length) {
		board = new int[length][length];
		SIZE = length;
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public int getSquare(Coordinate c) {
		return board[c.getR()][c.getC()];
	}
	
	public void setSquare(Coordinate c, int square) {
		board[c.getR()][c.getR()] = square;
	}
	
	public void setSquare(int row, int col, int square) {
		board[row][col] = square;
	}
	
	public void setRestricted(int row, int col) {
		board[row][col] = RESTRICTED;
	}
	
	public void placeQueen(int r, int c) {
		//go top left
		int row=r;

		int col=c;
		//System.out.println(j);

		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;
			row--;
			col++;

		}
		//go top
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;

			col++;
		}
		//go top right
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;

			row++;
			col++;
		}
		//go right
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;

			row++;
		}
		//go bottom right
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;

			row++;
			col--;
		}
		//go bottom
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;
			col--;
		}
		//go bottom left
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;
			row--;
			col--;
		}
		//go  left
		row=r;
		col=c;
		while(row>=0 && col>=0 && row<SIZE && col<SIZE) {
			board[row][col]=Board.RESTRICTED;
			row--;
		}
		board[r][c]=Board.QUEEN;
	}
	
	public void placeQueen(Coordinate Coor) {
		for(int i = 0; i<board.length; i++) {
			board[i][Coor.getC()] = RESTRICTED;
			board[Coor.getR()][i] = RESTRICTED;
		}
		int c = Coor.getC();
		int r = Coor.getR();
		while(r+1<board.length && r>=0 && c+1<board.length && c>=0) {
			r++;
			c++;
			board[r][c] = RESTRICTED;
		}
		c = Coor.getC(); r = Coor.getR();
		while(r<board.length && r-1>=0 && c<board.length && c-1>=0) {
			r--;
			c--;
			board[r][c] = RESTRICTED;
		}
		c = Coor.getC(); r = Coor.getR();
		while(r+1<board.length && r>=0 && c<board.length && c-1>=0) {
			r++;
			c--;
			board[r][c] = RESTRICTED;
		}
		c = Coor.getC(); r = Coor.getR();
		while(r<board.length && r-1>=0 && c+1<board.length && c>=0) {
			r--;
			c++;
			board[r][c] = RESTRICTED;
		}
		board[Coor.getR()][Coor.getC()] = QUEEN;
	}
	
	public Coordinate findSpace() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == EMPTY) {
					return new Coordinate(i,j);
				}
			}
		}
		return null;
	}
	
	public void copyBoard(Board b) {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				b.setSquare(i, j, board[i][j]);
			}
		}
	}
	
	public int remainingEmpty() {
		int empty = 0;
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == EMPTY) {
					empty++;
				}
			}
		}
		return empty;
	}
	
	public Coordinate nextEmpty() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == EMPTY) {
					return new Coordinate(i,j);
				}
			}
		}
		return null;
	}
	
	public void printBoard() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == EMPTY) {
					System.out.print(". ");	
				}else if(board[i][j] == QUEEN) {
					System.out.print("Q ");	
				}else if(board[i][j] == RESTRICTED) {
					System.out.print("x ");	
				}
			}
			System.out.println();
		}
	}
	
	public void eightqueens() {
		placeQueen(0,2);
		placeQueen(1,5);
		placeQueen(2,7);
		placeQueen(3,0);
		placeQueen(4,3);
		placeQueen(5,6);
		placeQueen(6,4);
		placeQueen(7,1);
		printBoard();
	}
	
	public void twelvequeens() {
		placeQueen(0,0);
		placeQueen(1,8);
		placeQueen(2,1);
		placeQueen(3,11);
		placeQueen(4,2);
		placeQueen(5,6);
		placeQueen(6,9);
		placeQueen(7,3);
		placeQueen(8,10);
		placeQueen(9,4);
		placeQueen(10,7);
		placeQueen(11,5);
		printBoard();
	}
}

public class Board {
	public static final int EMPTY=0;
	public static final int QUEEN=1;
	public static final int RESTRICTED=2;
	private static final int SIZE = 8; 
	private int[][] squares = new int[SIZE][SIZE];

	public int[][] getSquares() {
		return squares;
	}
	Board() {
	}
	Board(Board original) {
		int[][] originalSquares = original.getSquares();
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.squares[i][j]=originalSquares[i][j];
			}
		}
	}
	public void printBoard() {
		for(int i = 0; i<squares.length; i++) {
			for(int j = 0; j<squares[0].length; j++) {
				if(squares[i][j] == EMPTY) {
					System.out.print(". ");	
				}else if(squares[i][j] == QUEEN) {
					System.out.print("Q ");	
				}else if(squares[i][j] == RESTRICTED) {
					System.out.print("X ");	
				}
			}
			System.out.println();
		}
	}
	public void placeQueen(int i, int j) {
		//go top left
		int horizontal=i;

		int vertical=j;
		//System.out.println(j);

		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;
			horizontal--;
			vertical++;

		}
		//go top
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;

			vertical++;
		}
		//go top right
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;

			horizontal++;
			vertical++;
		}
		//go right
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;

			horizontal++;
		}
		//go bottom right
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;

			horizontal++;
			vertical--;
		}
		//go bottom
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;
			vertical--;
		}
		//go bottom left
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;
			horizontal--;
			vertical--;
		}
		//go  left
		horizontal=i;
		vertical=j;
		while(horizontal>=0 && vertical>=0 && horizontal<SIZE && vertical<SIZE) {
			squares[horizontal][vertical]=Board.RESTRICTED;
			horizontal--;
		}
		squares[i][j]=Board.QUEEN;
	}
	
	public int[] searchFor(int type) {
		for(int i=0; i<squares.length; i++) {
			for(int j=0; j<squares[0].length; j++) {
				if(squares[i][j]==type) {
					int[] out = new int[2];
					out[0]=i;
					out[1]=j;
					return out;
				}
			}
		}
		return null;
	}
	
	public int findNextRow() {
		
	}
	
}

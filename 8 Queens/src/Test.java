
public class Test {
	
	public static void main (String[] args){
		//Test();
		//Test2();
		//Test3();
		//playEight();
		playTwelve();
	}
	
	public static void Test() {
		int[][] temp = new int[5][10];
		System.out.println("Testing");
		System.out.println(temp.length);
		System.out.println(temp[0].length);
		System.out.println(temp[0][0]);
	}

	public static void Test1() {
		Board temp = new Board();
		//temp.printBoard();
		//System.out.println(temp.getSize());
		//temp.placeQueen(new Coordinate(7,7));
		temp.placeQueen(new Coordinate(3,4));
		temp.printBoard();
	}
	
	public static void Test2() {
		Algorithm nQueens = new Algorithm();
		Board b = new Board();
		nQueens.placeQueens(b, b.getSize()).printBoard();
		
	}
	
	public static void Test3() {
		Board temp = new Board();
		temp.placeQueen(temp.nextEmpty());
		temp.placeQueen(temp.nextEmpty());
		temp.placeQueen(temp.nextEmpty());
		temp.placeQueen(temp.nextEmpty());
		temp.placeQueen(temp.nextEmpty());
		temp.printBoard();
	}
	
	public static void playEight() {
		Board play = new Board(8);
		play.eightqueens();
	}
	
	public static void playTwelve() {
		Board play = new Board(12);
		play.twelvequeens();
	}
	
	/* Solution
	 
Q x x x x x x x x x x x 
x x x x x x x x Q x x x 
x Q x x x x x x x x x x 
x x x x x x x x x x x Q 
x x Q x x x x x x x x x 
x x x x x x Q x x x x x 
x x x x x x x x x Q x x 
x x x Q x x x x x x x x 
x x x x x x x x x x Q x 
x x x x Q x x x x x x x 
x x x x x x x Q x x x x 
x x x x x Q x x x x x x 

	 */
	 
}


public class Test {

	public static void main (String[] args){
		Board test = new Board();
		test.placeQueen(0,2);
		int[] Coordinate = test.searchFor(0);
		int i = Coordinate[0]; int j = Coordinate[1];
		test.placeQueen(i,j);
		Coordinate = test.searchFor(0);
		i = Coordinate[0]; j = Coordinate[1];
		test.placeQueen(i,j);
		Coordinate = test.searchFor(0);
		i = Coordinate[0]; j = Coordinate[1];
		test.placeQueen(i,j);
		Coordinate = test.searchFor(0);
		i = Coordinate[0]; j = Coordinate[1];
		test.placeQueen(i,j);
		test.printBoard();
		
	}
}

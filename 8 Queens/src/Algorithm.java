
public class Algorithm {

	public boolean solution = false;
	public Board solved = new Board();
	
	public Board placeQueens(Board b, int queens) {
		Board temp = new Board();
		if(queens==0) {
			solution = true;
			solved.copyBoard(b);
			return b;
		}else{
			while(!solution && b.remainingEmpty()>0) {
				Coordinate empty = b.nextEmpty();
				temp.copyBoard(b);
				temp.placeQueen(empty);
				placeQueens(temp, queens-1);
				if(solution=false) {
					temp.copyBoard(b);
					temp.setSquare(empty, -1);
				}else {
					System.out.println("one");
					return solved;
				}
			}
			if(!solution) {
				System.out.println("FAILURE");
				return solved;
			}
		}
	System.out.println("two");
	return solved;		
	}
}
/*
PlaceQueens(Board,NumberOfQueens)

IF NumberOfQueens=0 THEN
   Return Board
ELSE
   WHILE a solution has not been found and EMPTY squares 
   remain
      Pick an EMPTY square
      Copy Board into a New Board with a QUEEN placed in 
      the empty square
      Set all the squares on the New Board sharing a row, 
      column, or diagonal with the new queen as RESTRICTED
      Call PlaceQueens(New Board, NumberOfQueens-1)
      IF A Solution was not found THEN
         Set the new queen’s square on Board to RESTRICTED
      ELSE
         Return the Solution
   END WHILE
   IF no solution found THEN
      return failure
END ELSE
 
 
*/
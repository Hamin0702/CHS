import java.util.Scanner;
public class HumanBlackjackPlayer extends BlackjackPlayer{

	public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("  Player Hand:"); playerHand.print(); System.out.println("  Dealer Hand:"); dealerHand.print(); 
		System.out.println("Hit? yes or no");
		Scanner a = new Scanner (System.in);
		String input = a.next();
		if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
			do{
				System.out.println("Oops, try again");
				a = new Scanner (System.in);
				input = a.next();	
			} while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		} 
		System.out.println();
		return input.equalsIgnoreCase("yes");
	}
	
	
	public void dealerHit(BlackjackHand dealerHand) {
		System.out.println();
		System.out.println("the dealer hit");
		System.out.println("  Dealer Hand:"); dealerHand.print(); 
		System.out.println();
		System.out.println();
	}
	
	public void playerBusts(BlackjackHand playerHand) {
		System.out.println("  Player Hand:"); playerHand.print(); 
		System.out.println("You busted");
		System.out.println("------------------------");
		System.out.println();
		System.out.println();
	}
	
	public void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("  Player Hand:"); playerHand.print(); System.out.println("  Dealer Hand:"); dealerHand.print(); 
		System.out.println("You tied the dealer");
		System.out.println("------------------------");
		System.out.println();
		System.out.println();
	}
	
	public void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("  Player Hand:"); playerHand.print(); System.out.println("  Dealer Hand:"); dealerHand.print(); 
		System.out.println("You win!");
		System.out.println("------------------------");
		System.out.println();		
		System.out.println();
	}
	
	public void dealerBusts(BlackjackHand dealerHand) {
		System.out.println("  Dealer Hand:"); dealerHand.print(); 
		System.out.println("The dealer busted");
		System.out.println("------------------------");
		System.out.println();
		System.out.println();
	}
	
	public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("  Player Hand:"); playerHand.print(); System.out.println("  Dealer Hand:"); dealerHand.print(); 
		System.out.println("Dealer wins!");
		System.out.println("------------------------");
		System.out.println();
		System.out.println();
	}

}






public class ComputerBlackjackPlayer extends BlackjackPlayer{
	
	private BlackjackStrategy strat;
	
	ComputerBlackjackPlayer(BlackjackStrategy theStrategy){
		strat = theStrategy;
	}
	
	public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand) {
		int handValue = playerHand.handValue();
		int dealerHandValue = dealerHand.handValue();
		boolean soft = playerHand.soft();
		return strat.hit(handValue, dealerHandValue, soft);
	}
	public void dealerHit(BlackjackHand dealerHand) {
		
	}
	
	public void playerBusts(BlackjackHand playerHand) {
		
	}
	public void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand) {
		
	}
	public void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand) {
		
	}
	public void dealerBusts(BlackjackHand dealerHand) {
		
	}
	public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {
		
	}
}

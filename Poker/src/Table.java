import java.util.ArrayList;

public class Table {
	private ArrayList<Card> board;
	//private Card[] burnCards = new Card[3];
	
	Table(Deck play){
		board = new ArrayList<Card>();
		for(int i = 0; i<5; i++) {
			board.add(play.drawFromDeck());
		}
	}
	
	Table(Card card1, Card card2, Card card3, Card card4, Card card5){
		board = new ArrayList<Card>();
		board.add(card1); board.add(card2); board.add(card3); board.add(card4); board.add(card5);
	}
	
	public ArrayList<Card> returnTable() {
		return board;
	}
	

	public void setBoardCard(Card card, int cardNum){
		board.set(cardNum, card);
	}
	
	public Card getBoardCard(int cardNum){
		return board.get(cardNum);
	}
	
//	public void setBurnCard(Card card, int cardNum){
//		this.burnCards[cardNum] = card;
//	}
	
//	public Card getBurnCard(int cardNum){
//		return this.burnCards[cardNum];
//	}
	
	public int boardSize(){
		return board.size();
	}
	
	public void printBoard(){
		System.out.println("The board contains the following cards:");
		for(int i =0; i<board.size();i++){
			System.out.println(i+1 + ": " + getBoardCard(i).toString());
		}
		System.out.println("\n");
	}
	
//	protected void printBurnCards(){
//		System.out.println("The burn cards are:");
//		for(int i =0; i<burnCards.length;i++){
//			System.out.println(i+1 + ": " + getBurnCard(i).printCard());
//		}
//		System.out.println("\n");
//	}

}



import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand;
	
	Hand(Deck play) {
		hand = new ArrayList<Card>();
		for(int i = 0; i<2; i++) {
			hand.add(play.drawFromDeck());
		}
	}
	
	Hand(Card card1, Card card2){
		hand = new ArrayList<Card>();
		hand.add(card1);
		hand.add(card2);
	}
	
	public ArrayList<Card> returnHand() {
		return hand;
	}
	
	public int numberOfCards() {
		return hand.size();
	}
	
	public int highestCard() {
		int highestValue=0;
		for(int i=0; i<hand.size();i++) {
			if((hand.get(i)).getValue()>highestValue) {
				highestValue = (hand.get(i)).getValue();
			}
		}
		return highestValue;
	}
	
	public Card nthCard(int N) {
		Card returnCard = hand.get(N);
		return returnCard;
	}
	
	public void print() {
		System.out.println("Player has the following cards:");
		for(int i = 0; i<hand.size(); i++) {
			System.out.println(i+1 + ": " +hand.get(i));
		}
		System.out.println("\n");
	}
	

	//public void addCard(Card newCard, int index) {
	//	hand[index]=newCard;
	//}
	
}


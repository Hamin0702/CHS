import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	
	Deck() {
		cards = new ArrayList<Card>();
		
		for (int a = 1; a<=4; a++) {
			for (int b= 1; b<=13; b++) {
				cards.add(new Card(a,b));
			}
		}
		
		shuffle();
	}
	
	public void print() {
		int counter = 1;
		System.out.println("Remaining cards in deck");
		for(Card deck: cards) {
			System.out.println(""+counter+": "+ deck);
			counter++;
		}
		System.out.print("\n");
	}

	public Card drawFromDeck() {	   
		return cards.remove(0);
	}

	public int getTotalCards() {
		return cards.size(); 
	}
		
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}

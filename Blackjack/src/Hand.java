import java.util.ArrayList;
public class Hand {
	
	private ArrayList<PlayingCard> myList;
	
	Hand() {
		myList = new ArrayList<PlayingCard>();
	}
	
	public int numberOfCards() {
		return myList.size();
	}
	
	public PlayingCard nthCard(int N) {
		PlayingCard returnCard = myList.get(N);
		return returnCard;
	}
	
	public void print() {
		for(PlayingCard card : myList) {
			System.out.println(card);
		}
	}
	
	public void addCard(PlayingCard newCard) {
		myList.add(newCard);
	}
}



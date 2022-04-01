
public class Card {
	

	private int suit;
	private int value;
	
	public static final int ACE = 1;
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;
	
	public static int HEARTS = 1;
	public static int SPADES = 2;
	public static int CLUBS = 3;
	public static int DIAMONDS = 4;
	
	Card(int suitNum, int valueNum) {
		suit = suitNum;
		value = valueNum;
	}
	
	Card(boolean random) {
		if(random==true) {
			suit = 1 + (int) (Math.random() * 4);
			value = 1 + (int) (Math.random() * 13);
		}
	}
	
	public int getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public String valueAsString(){
		String valueStr = "";
		
		if(value==1) {
			valueStr = "A";
		}else if(value==13) {
			valueStr = "King";
		}else if(value==12) {
			valueStr = "Queen";
		}else if(value==11) {
			valueStr = "Jack";
		}else {
			valueStr = "" + value;
		}
		
		return valueStr;
	}
	
	public String suitAsString(){
		String suitStr = "";
		
		if(suit==1) {
			suitStr = "Hearts";
		}else if(suit==2) {
			suitStr = "Spades";
		}else if(suit==3) {
			suitStr = "Clubs";
		}else if(suit==4) {
			suitStr = "Diamonds";
		}
		
		return suitStr;
	}

	public String toString() {
		String suitStr="";
		String valueStr="";
		
		if(suit==1) {
			suitStr = "Hearts";
		}else if(suit==2) {
			suitStr = "Spades";
		}else if(suit==3) {
			suitStr = "Clubs";
		}else if(suit==4) {
			suitStr = "Diamonds";
		}
		
		if(value==1) {
			valueStr = "A";
		}else if(value==13) {
			valueStr = "King";
		}else if(value==12) {
			valueStr = "Queen";
		}else if(value==11) {
			valueStr = "Jack";
		}else {
			valueStr = "" + value;
		}
		
		return "" + valueStr + " of " + suitStr;
	}
	
	public String imageName() {
		String suitStr="";
		String valueStr="";
		
		if(suit==1) {
			suitStr = "H";
		}else if(suit==2) {
			suitStr = "S";
		}else if(suit==3) {
			suitStr = "C";
		}else if(suit==4) {
			suitStr = "D";
		}
		
		if(value==1) {
			valueStr = "A";
		}else if(value==13) {
			valueStr = "K";
		}else if(value==12) {
			valueStr = "Q";
		}else if(value==11) {
			valueStr = "J";
		}else {
			valueStr = "" + value;
		}
		
		return "" + valueStr + suitStr;
	}
	
	public void setSuit(int suit){
		this.suit = suit;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public static boolean sameCard(Card card1, Card card2){
		return (card1.value == card2.value && card1.suit == card2.suit);
	}
}

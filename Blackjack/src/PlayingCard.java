import java.util.*;
public class PlayingCard {
	
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
	
	public static boolean random = true;
	
	PlayingCard(int suitNum, int valueNum) {
		suit = suitNum;
		value = valueNum;
	}
	
	PlayingCard() {
		if(random==true) {
			suit = 1 + (int) (Math.random() * 4);
			value = 1 + (int) (Math.random() * 13);
		} else {
			System.out.println("Enter a number between 1 and 4");
			Scanner a = new Scanner (System.in);
			suit = Integer.parseInt(a.nextLine());
			System.out.println("Enter a number between 1 and 13");
			Scanner b = new Scanner (System.in);
			value = Integer.parseInt(b.nextLine());
		}
	}
	
	public int getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
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
	
	public static void setRandom (boolean rand) {
		random = rand;
	}
}










import java.util.ArrayList;

public class HandEvaluator {
	
	private int rankNum;
	private String rank;
	private ArrayList<Card> player, table, total, comp;
	private int highestCard;
	private ArrayList<Integer> values;
	private ArrayList<Integer> noRpt;
	
	boolean royalFlush, straightFlush, fourKind, fullHouse, flush, straight, threeKind, twoPair, onePair, highCard , royal= false;
	
	HandEvaluator(Hand myHand, Table myTable){
		player = myHand.returnHand();
		table = myTable.returnTable();
		total = new ArrayList<Card>();
		values = new ArrayList<Integer>();
		CombineHand();
		orderHand();
		for(int i=0; i<total.size();i++) {
			values.add(total.get(i).getValue());
		
		}
		noRepeat();
		testHands();
		setRank();
	}
	
	HandEvaluator(ArrayList<Card> computer, ArrayList<Card> tableCards){
		player = computer;
		table = tableCards;
		total = new ArrayList<Card>();
		values = new ArrayList<Integer>();
		CombineHand();
		orderHand();
		for(int i=0; i<total.size();i++) {
			values.add(total.get(i).getValue());
		
		}
		noRepeat();
		testHands();
		setRank();
	}
	
	HandEvaluator(Hand myHand, Hand computer, Table myTable){
		comp = computer.returnHand();
		player = myHand.returnHand();
		table = myTable.returnTable();
		total = new ArrayList<Card>();
		values = new ArrayList<Integer>();
		CombineHand();
		orderHand();
		for(int i=0; i<total.size();i++) {
			values.add(total.get(i).getValue());
		
		}
		noRepeat();
		testHands();
		setRank();
	}
	
	public ArrayList<Card> getComputer(){
		return comp;
	}
	
	public ArrayList<Card> getTable(){
		return table;
	}
	
	public ArrayList<Card> getPlayerCards(){
		return player;
	}
	
	public ArrayList<Card> getCombined(){
		return total;
	}
	
	public void CombineHand() {
		for(int i = 0; i<player.size(); i++) {
			total.add(player.get(i));
		}
		for(int i = 0; i<table.size(); i++) {
			total.add(table.get(i));
		}
	}
	
	public void orderHand() {
		boolean check = true;
		ArrayList<Card> temp = new ArrayList();
		while(check) {
			int highestValue=0;
			int highestIndex=-1;
			for(int i=0; i<total.size();i++) {
				if((total.get(i)).getValue()>highestValue) {
					highestValue = (total.get(i)).getValue();
					highestIndex=i;
				}
			}
			temp.add(total.remove(highestIndex));
			if(total.size()==0) {
				check=false;
			}
		}
		total=temp;
		
	}
	public void Highest() {
		int highestValue=0;
		for(Card deck: total) {
			if(deck.getValue()>highestValue) {
				highestValue = deck.getValue();
			}
		}
		highestCard=highestValue;
	}

	public void printHighest() {
		Highest();
		System.out.println("Highest Value: " + highestCard);
		System.out.println("\n");
	}
	
	public void printCombined() {
		int i = 0;
		System.out.println("Combined Hand:");
		for(Card deck: total) {
			System.out.println(i+1 + ": " +deck);
			i++;
		}
		System.out.println("\n");
		
	}
	
	public void noRepeat() {
		noRpt = new ArrayList<Integer>();
		for(int i = 0; i<values.size(); i++) {
			if(!noRpt.contains(values.get(i)))
				noRpt.add(values.get(i));
		}
		
	//	for(Integer num: noRpt) {
	//		System.out.println(num);
	//	}
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	public void returnType() {
		if (royal && flush) {
			System.out.println("Royal Flush!");
			System.out.println("\n");
		} else if(straight&&flush) {
			System.out.println("Straight Flush!");
			System.out.println("\n");
		} else if(fourKind) {
			System.out.println("Four of a Kind!");
			System.out.println("\n");
		} else if(threeKind&&onePair) {
			System.out.println("Full House!");
			System.out.println("\n");
		} else if(flush) {
			System.out.println("Flush!");
			System.out.println("\n");
		} else if(straight) {
			System.out.println("Straight!");
			System.out.println("\n");
		} else if(threeKind) {
			System.out.println("Three of a Kind!");
			System.out.println("\n");
		} else if(twoPair) {
			System.out.println("Two Pairs!");
			System.out.println("\n");
		} else if(onePair) {
			System.out.println("One Pair!");
			System.out.println("\n");
		} else if(highCard) {
			System.out.println("Higher Card!");
			System.out.println("\n");
		} else {
			System.out.println("You've got nothing, better luck next time!");
			System.out.println("\n");
		}
	}
	
	public void setRank() {
		if (royal && flush) {
			rank = "Royal Flush!";
			rankNum = 9;
		} else if(straight&&flush) {
			rank = "Straight Flush!";
			rankNum = 8;
		} else if(fourKind) {
			rank = "Four of a Kind!";
			rankNum = 7;
		} else if(threeKind&&onePair) {
			rank = "Full House!";
			rankNum = 6;
		} else if(flush) {
			rank = "Flush!";
			rankNum = 5;
		} else if(straight) {
			rank = "Straight!";
			rankNum = 4;
		} else if(threeKind) {
			rank = "Three of a Kind!";
			rankNum = 3;
		} else if(twoPair) {
			rank = "Two Pairs!";
			rankNum = 2;
		} else if(onePair) {
			rank = "One Pair!";
			rankNum = 1;
		} else if(highCard) {
			rank = "Higher Card!";
		} else {
			rank = "Nothing :(";
			rankNum = 0;
		}
	}
	
	public String getRank() {
		return rank;
	}
	
	public int getRankNum() {
		return rankNum;
	}
	
	public void testHands() {
		flush();
		Pairs();
		straight();
		specialStraight();
	}
	
	public void flush() {
		for (int i = 0; i<total.size(); i++) {
			int suitTemp=(total.get(i)).getSuit();
			int counter=0;
			for(Card deck: total) {
				if(deck.getSuit()==suitTemp) {
					counter++;
				}
			}
			if (counter>=5) {
				flush=true;
			}
		}
	}

	public void Pairs() {
		int firstPair=0;
		int secondPair=0;
		for(int i = 0; i<values.size(); i++) {
			int check=values.get(i);
			boolean continues=true;
			for(int k = 0; k<i; k++) {
				if(check==values.get(k)) {
					continues=false;
				}
			}
			
			if(continues) {
			int pair=0;
			for(int j = i+1; j<values.size(); j++) {
				if(values.get(j)==check) {
					pair++;
				}
			}
			if(pair==1) {
				onePair=true;
				if(firstPair==0) {
					firstPair=check;
				} else if(firstPair!=0) {
					secondPair=check;
				}
			}
			
			if((pair==2 && check!= firstPair) && check!= secondPair) {
				threeKind=true;
			}
			if(pair==3) {
				fourKind=true;
			}
		}
		}
		if(firstPair!=0 && secondPair!=0) {
			twoPair=true;
		}
	}
	
	public void straight() {
		int counter = 0;
		for(int i = 0; i < noRpt.size()-1; i++) {
			for(int j = i; j<noRpt.size()-1; j++) {
				if(noRpt.get(j)-noRpt.get(j+1)==1) {
					counter++;
				}
			}
		if(counter>=4) {
			straight=true;
		}
		counter = 0;
		}
		
	}
	
	public void specialStraight() {
		int counter = 0;
		if(noRpt.get(noRpt.size()-1)==1) {
			for(int j = 0; j<noRpt.size()-1; j++) {
				if(noRpt.get(j)-noRpt.get(j+1)==1) {
					counter++;
				}
			}
		}
		if(counter>=3) {
			royal=true;
		}
	}
	
}



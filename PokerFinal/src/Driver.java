
public class Driver {
	
	static Card ace = new Card(1,1);
	static Card two = new Card(2,2);
	static Card three = new Card(3,3);
	static Card four = new Card(4,4);
	static Card five = new Card(1,5);
	static Card six = new Card(2,6);
	static Card seven = new Card(3,7);
	static Card eight = new Card(4,8);
	static Card nine = new Card(1,9);
	static Card ten = new Card(2,10);
	static Card jack = new Card(3,11);
	static Card queen = new Card(4,12);
	static Card king = new Card(1,13);
	
	
	
	//basic testing
	public static void Driver1() {
		Deck playingDeck = new Deck();
		Table myTable = new Table(playingDeck);
		Hand myHand = new Hand(playingDeck);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.printHighest();
		playingDeck.print();
	}

	//flush checker
	public static void Driver2() {
		Hand myHand = new Hand(ace, five);
		Table myTable = new Table(nine, king, ace, two, four);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//onePair
	public static void Driver3() {
		Hand myHand = new Hand(ace, ace);
		Table myTable = new Table(two,three,king,five,six);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//two pairs
	public static void Driver4() {
		Hand myHand = new Hand(ace, ace);
		Table myTable = new Table(two,two,king,five,six);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//three of a kind
	public static void Driver5() {
		Hand myHand = new Hand(ace, ace);
		Table myTable = new Table(ace,two,queen,five,six);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
		
	//full house
	public static void Driver6() {
		Hand myHand = new Hand(ace, ace);
		Table myTable = new Table(two,two,two,five,six);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}

	//four of a kind
	public static void Driver7() {
		Hand myHand = new Hand(ace, ace);
		Table myTable = new Table(ace,ace,two,five,six);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//straight
	public static void Driver8() {
		Hand myHand = new Hand(ace, eight);
		Table myTable = new Table(seven,ace,nine,six,ten);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//straight flush
	public static void Driver9() {
		Card nine = new Card(1,9);
		Card ten = new Card(1,10);
		Card jack = new Card(1,11);
		Card queen = new Card(1,12);
		Card king = new Card(1,13);

		Hand myHand = new Hand(ace, jack);
		Table myTable = new Table(king,ace,nine,queen,ten);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//straight flush
	public static void Driver10() {
		Card ace = new Card(1,1);
		Card ten = new Card(1,10);
		Card jack = new Card(1,11);
		Card queen = new Card(1,12);
		Card king = new Card(1,13);

		Hand myHand = new Hand(ace, jack);
		Table myTable = new Table(king,ace,nine,queen,ten);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
		
	public static void Driver11() {
		Deck playingDeck = new Deck();
		Table myTable = new Table(playingDeck);
		Hand myHand = new Hand(playingDeck);
		HandEvaluator myHandEval = new HandEvaluator(myHand,myTable);
		
		myTable.printBoard();
		myHand.print();
		myHandEval.printCombined();
		myHandEval.returnType();
	}
	
	//image
	public static void Driver12() {
		Deck playingDeck = new Deck();
		Table myTable = new Table(playingDeck);
		Hand myHand = new Hand(playingDeck);
		Hand ComputerHand = new Hand(playingDeck);
		HandEvaluator myHandEval = new HandEvaluator(myHand,ComputerHand,myTable);
		Game myGame = new Game(myHandEval);
		myGame.printBoard();
		myHand.print();
		myGame.askPlayer();
		myGame.printCombined();
		myGame.printRank();
		myGame.printCompCards();
		myGame.printCompRank();
		myGame.winner();
	}
	
	public static void main(String[] args) {
		//Driver1();
		//Driver2();
		//Driver3();
		//Driver4();
		//Driver5();
		//Driver6();
		//Driver7();
		//Driver8();
		//Driver9();
		//Driver10();
		//Driver11();
		Driver12();
		
	}
}

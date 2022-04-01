public class Driver {
	
	public static void Driver1() {
		PlayingCard cardA =new PlayingCard();
		PlayingCard cardB =new PlayingCard();
		System.out.println(cardA);
		System.out.println(cardB);

		cardA.setRandom(false);
		
		PlayingCard cardC=new PlayingCard();
		System.out.println(cardC);
		PlayingCard cardD =new PlayingCard();
		System.out.println(cardD);

		cardD.setRandom(true);
		
		PlayingCard cardE =new PlayingCard();
		PlayingCard cardF =new PlayingCard();
		System.out.println(cardE);
		System.out.println(cardF);
		
		PlayingCard card1 = new PlayingCard(1,PlayingCard.ACE);
		PlayingCard card2 = new PlayingCard(2,2);
		PlayingCard card3 = new PlayingCard(3,3);
		PlayingCard card4 = new PlayingCard(4,4);
		PlayingCard card5 = new PlayingCard(1,5);
		PlayingCard card6 = new PlayingCard(2,6);
		PlayingCard card7 = new PlayingCard(3,7);
		PlayingCard card8 = new PlayingCard(4,8);
		PlayingCard card9 = new PlayingCard(1,9);
		PlayingCard card10 = new PlayingCard(2,10);
		PlayingCard card11 = new PlayingCard(3,PlayingCard.JACK);
		PlayingCard card12 = new PlayingCard(4,PlayingCard.QUEEN);
		PlayingCard card13 = new PlayingCard(1,PlayingCard.KING);
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
		System.out.println(card6);
		System.out.println(card7);
		System.out.println(card8);
		System.out.println(card9);
		System.out.println(card10);
		System.out.println(card11);
		System.out.println(card12);
		System.out.println(card13);
	}
	
	public static void Driver2() {
		//empty hand
		Hand test = new Hand();
		System.out.println(test.numberOfCards());
		test.print();
		//one card
		PlayingCard card1 =new PlayingCard();
		test.addCard(card1);
		System.out.println(test.numberOfCards());
		System.out.println(test.nthCard(0));
		test.print();
		//two cards
		PlayingCard card2 =new PlayingCard();
		test.addCard(card2);
		System.out.println(test.numberOfCards());
		System.out.println(test.nthCard(0));
		System.out.println(test.nthCard(1));
		test.print();
		//three cards
		PlayingCard card3 =new PlayingCard();
		test.addCard(card3);
		System.out.println(test.numberOfCards());
		System.out.println(test.nthCard(0));
		System.out.println(test.nthCard(2));
		System.out.println(test.nthCard(1));
		test.print();
		
	}
	
	public static void Driver3() {
		BlackjackHand test1 = new BlackjackHand();
		PlayingCard king = new PlayingCard(1,PlayingCard.KING);
		test1.addCard(king);
		test1.print();
		System.out.println(test1.handValue());
		System.out.println(test1.soft());
		BlackjackHand test2 = new BlackjackHand();
		PlayingCard queen = new PlayingCard(1,PlayingCard.QUEEN);
		test2.addCard(queen);
		test2.print();
		System.out.println(test2.handValue());
		System.out.println(test2.soft());
		BlackjackHand test3 = new BlackjackHand();
		PlayingCard jack = new PlayingCard(1,PlayingCard.JACK);
		test3.addCard(jack);
		test3.print();
		System.out.println(test3.handValue());
		System.out.println(test3.soft());
		
		BlackjackHand test4 = new BlackjackHand();
		PlayingCard ace = new PlayingCard(1,PlayingCard.ACE);
		test4.addCard(ace); test4.addCard(ace);
		test4.print();
		System.out.println(test4.handValue());
		System.out.println(test4.soft());
		
		BlackjackHand test5 = new BlackjackHand();
		test5.addCard(king); test5.addCard(queen); test5.addCard(ace);
		test5.print();
		System.out.println(test5.handValue());
		System.out.println(test5.soft());
		
		BlackjackHand test6 = new BlackjackHand();
		PlayingCard nine = new PlayingCard(1,9);
		test6.addCard(nine); test6.addCard(ace);
		test6.print();
		System.out.println(test6.handValue());
		System.out.println(test6.soft());
		
		BlackjackHand test7 = new BlackjackHand();
		test7.addCard(king); test7.addCard(queen); test7.addCard(jack); test7.addCard(ace); test7.addCard(ace);
		test7.print();
		System.out.println(test7.handValue());
		System.out.println(test7.soft());
		
		BlackjackHand test8 = new BlackjackHand();
		test8.addCard(king); test8.addCard(ace);
		test8.print();
		System.out.println(test8.handValue());
		System.out.println(test8.soft());
		
		BlackjackHand test9 = new BlackjackHand();
		test9.addCard(ace); test9.addCard(nine);
		test9.print();
		System.out.println(test9.handValue());
		System.out.println(test9.soft());
		
		BlackjackHand test10 = new BlackjackHand();
		PlayingCard five = new PlayingCard(2,5);
		test10.addCard(ace); test10.addCard(nine); test10.addCard(five);
		test10.print();
		System.out.println(test10.handValue());
		System.out.println(test10.soft());
		
		BlackjackHand test11 = new BlackjackHand();
		test11.addCard(five); test11.addCard(ace);
		test11.print();
		System.out.println(test11.handValue());
		System.out.println(test11.soft());
		
		BlackjackHand test12 = new BlackjackHand();
		test12.addCard(jack); test12.addCard(five); test12.addCard(ace);
		test12.print();
		System.out.println(test12.handValue());
		System.out.println(test12.soft());
		
		BlackjackHand test13 = new BlackjackHand();
		PlayingCard two = new PlayingCard(2,2);
		test13.addCard(two); test13.addCard(five);
		test13.print();
		System.out.println(test13.handValue());
		System.out.println(test13.soft());
		
		BlackjackHand test14 = new BlackjackHand();
		test14.addCard(ace); test14.addCard(jack); test14.addCard(two);
		test14.print();
		System.out.println(test14.handValue());
		System.out.println(test14.soft());
	}
	
	public static void Driver4() {
		HumanBlackjackPlayer test = new HumanBlackjackPlayer();
		BlackjackHand player = new BlackjackHand();
		BlackjackHand dealer = new BlackjackHand();
		PlayingCard one = new PlayingCard(2,1);
		PlayingCard two = new PlayingCard(2,2);
		PlayingCard eight = new PlayingCard(2,8);
		PlayingCard ten = new PlayingCard(2,11);
		
		/*player.addCard(one); player.addCard(two); dealer.addCard(one); dealer.addCard(two);
		test.playerTies(player, dealer);
		
		//player.addCard(eight); player.addCard(ten);
		//test.playerWins(player, dealer);
		
		dealer.addCard(eight); dealer.addCard(ten); 
		test.dealerWins(dealer, player);
		
		player.addCard(ten); player.addCard(ten); player.addCard(ten);
		test.playerBusts(player);
		
		dealer.addCard(ten); dealer.addCard(ten);
		test.dealerBusts(player);
		
		test.dealerHit(dealer);
		
		test.hit(dealer, player);
*/
		while (test.hit(dealer, player)==true) {
			System.out.print("m");
		}
	}

	public static void Driver5() {
		BlackjackPlayer player = new HumanBlackjackPlayer();
		BlackjackDealer jack = new BlackjackDealer();
		System.out.print(jack.playBlackjack(player,5));
	}
	
	public static void Driver6() {
		BlackjackStrategy myStrat = new MySimpleStrategy();
		System.out.println("15,11,true = " + myStrat.hit(15, 11, true));
		System.out.println("15,11,false = " + myStrat.hit(15, 11, false));
		System.out.println("11,10,false = " + myStrat.hit(11, 10, false));
		System.out.println("17,7,false = " + myStrat.hit(17, 7, false));
		System.out.println("16,6,false = " + myStrat.hit(16, 6, false));
		System.out.println("17,2,false = " + myStrat.hit(17, 2, false));
		
		BlackjackPlayer player = new ComputerBlackjackPlayer(myStrat);
		BlackjackDealer jack = new BlackjackDealer();
		System.out.println("Wins " + jack.playBlackjack(player,1000)*100 + " percent of games");
	}
	
	public static void main(String[] args) {
		//Driver1();
		//Driver2();
		//Driver3();
		//Driver4();
		Driver6();
	}
}



public class BlackjackDealer {
   	double wins=0;
   	public double playBlackjack(BlackjackPlayer player, int numGames) {
          	for(int i = 0; i < numGames; i++) {
          		BlackjackHand dealerHand = new BlackjackHand(), playerHand = new BlackjackHand();
          		PlayingCard dealerCard1 = new PlayingCard(), playerCard1 = new PlayingCard(), playerCard2 = new PlayingCard();
                dealerHand.addCard(dealerCard1);
                playerHand.addCard(playerCard1);
                playerHand.addCard(playerCard2);

                while (playerHand.handValue()<=21 && player.hit(dealerHand, playerHand)) {
                    PlayingCard hitCard1 = new PlayingCard();
                    playerHand.addCard(hitCard1);
                    if(playerHand.handValue()>21) {
                    	player.playerBusts(playerHand);
                    }
                }
                if (playerHand.handValue()<=21) {
                    while(dealerHand.handValue() < 17) {
                    	PlayingCard hitCard2 = new PlayingCard();
                        dealerHand.addCard(hitCard2);
                        player.dealerHit(dealerHand);
                        if(dealerHand.handValue() > 21) {
                        wins++;
                        player.dealerBusts(dealerHand);
                        }
                   }
                }
                if (playerHand.handValue()<=21 && dealerHand.handValue()<=21) {
                	if(playerHand.handValue()>dealerHand.handValue()) {
                		wins++;
                        player.playerWins(playerHand, dealerHand);
                    }else if(playerHand.handValue()==dealerHand.handValue()) {
                        player.playerTies(playerHand, dealerHand);
                    }else {
                        player.dealerWins(dealerHand, playerHand);
                    }  	
                }
          	}
    double finalScore = wins/(double)(numGames);
    return finalScore;
   	}
}
 



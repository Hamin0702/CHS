public class BlackjackHand extends Hand {

	private int handValue;
	private boolean soft;
	
	private void computeValue() {
		handValue = 0;
		soft = false;
		boolean aces=false;
			for(int i = 0; i<numberOfCards(); i++ ) {
				PlayingCard loop = nthCard(i);
				int valueNum = loop.getValue();
				  if(valueNum==11 || valueNum==12 || valueNum==13) {
					 handValue+=10; 
				  } else {
					  handValue+=valueNum;
				  }
				  if(valueNum==1) {
					 aces=true;
				  }
			}
			if(aces==true && handValue<12) {
				handValue+=10;
				soft=true;
			}
		}
	
	BlackjackHand() {
		handValue = 0;
		soft = false;
	}

	public void addCard(PlayingCard newCard) {
		super.addCard(newCard);
		computeValue();
	}
	
	public int handValue() {
		return handValue;
	}
	
	public boolean soft() {
		return soft;
	}

}



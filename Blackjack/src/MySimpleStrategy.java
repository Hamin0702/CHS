
public class MySimpleStrategy extends BlackjackStrategy{
	public boolean hit(int handValue, int dealerHandValue, boolean soft) {
		boolean check = false;
		if(dealerHandValue==11 && handValue<21) {
			check = true;
		} else if (handValue<17) {
			check = true;
		} else if (soft==true) {
			check = true;
		}
	return check;
	}
}

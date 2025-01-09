public class BlackjackHand extends Hand {
	private int handValue;
	private boolean soft;
	BlackjackHand(boolean dealer) {
		super(1);
		if (!dealer)
			addCard();
	}
	BlackjackHand() {
		super(0);
	}
	private void computeValue() {
		handValue = 0;
		boolean aces = false;
		soft = false; 
		for (int i=0; i<this.numberOfCards(); i++) {
			if ((this.nthCard(i)).getValue()==PlayingCard.KING||(this.nthCard(i)).getValue()==PlayingCard.QUEEN||(this.nthCard(i)).getValue()==PlayingCard.JACK)
				handValue+=10;
			else 
				handValue+=(this.nthCard(i)).getValue();
			if ((this.nthCard(i)).getValue()==PlayingCard.ACE)
				aces = true;
		}
		if (aces && handValue<12) {
			handValue+=10;
			soft = true;
		}
	}
	public void addCard() {
		super.addCard();
		computeValue();
	}
	public void addCard(PlayingCard card) {
		super.addCard(card);
		computeValue();
	}
	public int handValue() {
		return handValue;
	}
	public boolean soft() {
		return soft;
	}
}

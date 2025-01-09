import java.util.*;
public class Hand {
	private ArrayList<PlayingCard> playersHand;
	Hand(int initialCards) {
		playersHand = new ArrayList<PlayingCard>();
		for (int i=0; i<initialCards; i++)
			addCard();
	}
	public int numberOfCards() {
		return playersHand.size();
	}
	public PlayingCard nthCard(int N) {
		return playersHand.get(N);
	}
	public void print() {
		for (PlayingCard card : playersHand)
			System.out.println(card);
	}
	public void addCard(PlayingCard card) {
		playersHand.add(card);
	}
	public void addCard() {
		PlayingCard card = new PlayingCard();
		addCard(card);
	}
}

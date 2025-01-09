import java.util.*;
public class PlayingCard {
	private int suit;
	private int value;
	final public static int ACE = 1; 
	final public static int KING = 13;
	final public static int QUEEN = 12;
	final public static int JACK = 11;
	final public static int HEARTS = 1;
	final public static int SPADES = 2;
	final public static int CLUBS = 3;
	final public static int DIAMONDS = 4;
	private static boolean random = true;
	PlayingCard(int cardSuit, int cardValue) {
		suit = cardSuit;
		value = cardValue;
	}
	PlayingCard() {
		if (random==true) {
			suit = (int) (Math.random()*4) + 1;
			value = (int) (Math.random()*13) + 1;
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a suit: ");
			suit = Integer.parseInt(sc.nextLine());
			System.out.print("Enter a face value: ");
			value = Integer.parseInt(sc.nextLine());
		}
	}
	public int getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	public String toString() {
		String suitName = "";
		String cardName = "";
		if (suit==PlayingCard.HEARTS)
			suitName = "Hearts";
		else if (suit==PlayingCard.SPADES)
			suitName = "Spades";
		else if (suit==PlayingCard.CLUBS)
			suitName = "Clubs";
		else if (suit==PlayingCard.DIAMONDS)
			suitName = "Diamonds";
		if (value==PlayingCard.ACE)
			cardName = "A of "+suitName;
		else if (value==PlayingCard.KING)
			cardName = "King of "+suitName;
		else if (value==PlayingCard.QUEEN)
			cardName = "Queen of "+suitName;
		else if (value==PlayingCard.JACK)
			cardName = "Jack of "+suitName;
		else
			cardName = value+" of "+suitName;
		return cardName;
	}
	public static void setRandom(boolean b) {
		random = b;
	}
}
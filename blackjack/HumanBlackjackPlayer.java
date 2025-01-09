import java.util.*;
public class HumanBlackjackPlayer extends BlackjackPlayer {
	public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("Dealer Hand:");
		dealerHand.print();
		System.out.println("Player Hand:");
		playerHand.print();
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to hit?");
		String answer = sc.nextLine();
		while (!(answer.equals("yes"))&&!(answer.equals("no"))) {
			System.out.println("Please enter yes or no");
			answer = sc.nextLine();
		}
		if (answer.equals("yes"))
			return true;
		else
			return false;
	}
	public void dealerHit(BlackjackHand dealerHand) {
		System.out.println("Dealer Hand:");
		dealerHand.print();
		System.out.println("The dealer hit");
	}
	public void playerBusts(BlackjackHand playerHand) {
		System.out.println("Player Hand:");
		playerHand.print();
		System.out.println("You busted");
		System.out.println("----------------------\n");
	}
	public void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("Dealer Hand:");
		dealerHand.print();
		System.out.println("Player Hand:");
		playerHand.print();
		System.out.println("You tied the dealer");
		System.out.println("----------------------\n");
	}
	public void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("Dealer Hand:");
		dealerHand.print();
		System.out.println("Player Hand:");
		playerHand.print();
		System.out.println("You won");
		System.out.println("----------------------\n");
	}
	public void dealerBusts(BlackjackHand dealerHand) {
		System.out.println("Dealer Hand:");
		dealerHand.print();
		System.out.println("The dealer busted");
		System.out.println("----------------------\n");
	}
	public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("Dealer Hand:");
		dealerHand.print();
		System.out.println("Player Hand:");
		playerHand.print();
		System.out.println("The dealer won");
		System.out.println("----------------------\n");
	}
}

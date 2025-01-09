public class BlackjackDealer {
	public double playBlackjack(BlackjackPlayer player, int numGames) {
		boolean hit;
		double points=0;
		for (int game=0; game<numGames; game++) {
			BlackjackHand dealerHand = new BlackjackHand(true);
			BlackjackHand playerHand = new BlackjackHand(false);
			do {
				hit = player.hit(dealerHand, playerHand);
				if (hit)
					playerHand.addCard();
			} while (hit&&playerHand.handValue()<22);
			if (playerHand.handValue()>=22)
				player.playerBusts(playerHand);
			else {
				while (dealerHand.handValue()<17) {
					dealerHand.addCard();
					player.dealerHit(dealerHand);
				}
				if (dealerHand.handValue()>=22) {
					player.dealerBusts(dealerHand);
					points++;
				}
				else {
					if (playerHand.handValue()==dealerHand.handValue()) {
						player.playerTies(playerHand, dealerHand);
						points+=0.5;
					}
					else if (playerHand.handValue()>dealerHand.handValue()) {
						player.playerWins(playerHand, dealerHand);
						points++;
					}
					else
						player.dealerWins(dealerHand, playerHand);
				}
			}
		}
		return points/numGames;
	}
}
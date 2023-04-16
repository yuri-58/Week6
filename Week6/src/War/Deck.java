package War;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	Card cards = new Card();
	List<String> beta = cards.cardName(true);
	List<String> delta = cards.cardSuit(true);
	public List<String> shuffle() {
		List<String> tempAlpha = deckOfCards();
		List<String> tempBeta = new ArrayList<String>();
		List<String> tempDelta = new ArrayList<String>();
		do {
			Random randomNum = new Random();
			int randNum = randomNum.nextInt(52);
			tempBeta.add(tempAlpha.get(randNum));
			for(String beta : tempBeta) {
					if (!tempDelta.contains(beta)) {
						tempDelta.add(tempAlpha.get(randNum));
				}
			}
		} while(tempDelta.size() < 52);
		return tempDelta;
	}
	public String draw() {
		List<String> tempDeck = shuffle();
		tempDeck.add(tempDeck.get(0));
		tempDeck.remove(0);
		return tempDeck.get(51);
	}
	public List<String> deckOfCards(){
		List<String> newDeck = new ArrayList<String>();
		for(int i = 0; i < 13; i++) {
			for(int j = 0; j < 4; j ++) {
				newDeck.add(beta.get(i) + " of " + delta.get(j));
			}
		}
		return newDeck;
	}
}

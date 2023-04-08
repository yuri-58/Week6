package War;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Deck {

	Card alpha = new Card();
	List<String> beta = alpha.cardName(true);
	List<String> delta = alpha.cardSuit(true);
	public List<String> deckOfCards(){
		List<String> newDeck = new ArrayList<String>();
		for(int i = 0; i < alpha.cardSize(); i++) {
			for(int j = 0; j < alpha.suitSize(); j ++) {
				newDeck.add(beta.get(i) + " of " + delta.get(j));
			}
		}
		return newDeck;
	}
	public List<String> shuffleDeck() {
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
}

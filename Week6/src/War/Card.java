package War;

import java.util.ArrayList;
import java.util.List;

public class Card {
	
	public static List<String> cardName(boolean a) {
		List<String> cards = new ArrayList<String>();
		cards.add("Ace");
		cards.add("King");
		cards.add("Queen");
		cards.add("Jack");
		cards.add("10");
		cards.add("9");
		cards.add("8");
		cards.add("7");
		cards.add("6");
		cards.add("5");
		cards.add("4");
		cards.add("3");
		cards.add("2");
		return cards;
	}
	public List<String> cardSuit(boolean a){
		List<String> suit = new ArrayList<String>();
		suit.add("Spades");
		suit.add("Hearts");
		suit.add("Diamonds");
		suit.add("Clubs");
		return suit;
	}	
	public String describe(int a) {
		List<String> name = new ArrayList<String>();
		for(int i = 0; i < cardName(true).size(); i++) {
			for(int j = 0; j < cardSuit(true).size(); j ++) {
				name.add(cardName(true).get(i) + " of " + cardSuit(true).get(j));
			}
		}
		return name.get(a);
	}
}

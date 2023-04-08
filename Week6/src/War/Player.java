package War;

import java.util.ArrayList;
import java.util.List;

public class Player {
	Deck alpha = new Deck();
		List<String> beta = alpha.shuffleDeck();
		
		
	public List<String> dealCardsPlayer1(){
		List<String> tempAlpha = new ArrayList<String>();
		for(int i = 0; i < beta.size();i++) {
			if(i % 2 == 0) {
				tempAlpha.add(beta.get(i));
			} 
		}
		return tempAlpha;
	}
	public List<String> dealCardsPlayer2(){
		List<String> tempBeta = new ArrayList<String>();
		for(int i = 0; i < beta.size(); i++) {
			if(i % 2 == 1) {
				tempBeta.add(beta.get(i));
			}
		}
		return tempBeta;
	}
}

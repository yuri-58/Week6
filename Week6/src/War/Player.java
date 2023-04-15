package War;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
	Deck alpha = new Deck();
		List<String> beta = alpha.shuffleDeck();
		List<String> tempP1 = dealCardsPlayer1(beta);
		List<String> tempP2 = dealCardsPlayer2(beta);
		int reiterateNum = 0;
		int p1Points = 0;
		int p2Points = 0;
		
	public List<String> dealCardsPlayer1(List<String> a){
		List<String> tempAlpha = new ArrayList<String>();
		for(int i = 0; i < a.size();i++) {
			if(i % 2 == 0) {
				tempAlpha.add(a.get(i));
			} 
		}
		return tempAlpha;
	}
	public List<String> dealCardsPlayer2(List<String> a){
		List<String> tempBeta = new ArrayList<String>();
		for(int i = 0; i < a.size(); i++) {
			if(i % 2 == 1) {
				tempBeta.add(a.get(i));
			}
		}
		return tempBeta;
	}
	public void rounds() {
		prog:
		if(p1Points <= 25 && p2Points <= 25) {
				if (reiterateNum == 26) {
					System.out.println("Shuffling hands");
					shuffleHand(tempP1);
					shuffleHand(tempP2);
					reiterateNum = 0;
					contin();
					rounds();
				} else {
					int a = cardValue(tempP1.get(0));
					int b = cardValue(tempP2.get(0));
					System.out.println(tempP1.get(0));
					System.out.println(tempP2.get(0));
					if (a > b) {
						tempP1.add(tempP1.get(0));
						tempP1.add(tempP2.get(0));
						tempP1.remove(0);
						tempP2.remove(0);
						p1Points++;
						roundWinner(1);
					} else if (a == b) {
						System.out.println("WAR!");
						War(a, b);
					} else {
						tempP2.add(tempP1.get(0));
						tempP2.add(tempP2.get(0));
						tempP1.remove(0);
						tempP2.remove(0);
						p2Points++;
						roundWinner(2);
					}
					System.out.println("Player 1 has: "+ p1Points +" points ");
					System.out.println("Player 2 has: "+ p2Points +" points ");
					contin();
					rounds();
				}
		} else if(p2Points > 25) {
				System.out.println("!!Player 2 is the Winner!!!");
				System.out.println("!!Player 2 is the Winner!!!");
				System.out.println("!!Player 2 is the Winner!!!");
				System.out.println("Thanks for playing!");
				break prog;
		} else if(p1Points > 25) {
				System.out.println("!!Player 1 is the Winner!!!");
				System.out.println("!!Player 1 is the Winner!!!");
				System.out.println("!!Player 1 is the Winner!!!");
				System.out.println("Thanks for playing!");
				break prog;
			} 
	}
	public List<String> shuffleHand(List<String> a) {
		List<String> tempDelta = new ArrayList<String>();
		do {
			Random randomNum = new Random();
			int randNum = randomNum.nextInt(a.size());
			a.get(randNum);
			for(String beta : a) {
					if (!tempDelta.contains(beta)) {
						tempDelta.add(a.get(randNum));
				}
			}
		} while(tempDelta.size() <= a.size());
		return tempDelta;
	}
	public void contin() {
		Scanner in = new Scanner(System.in);
		System.out.println("Press enter to continue ");
		System.out.println("");
		String userInput = in.nextLine();
	}
	public void War(int a, int b){
		contin();
		int cap = 4;
		if(cardValue(tempP1.get(cap)) > cardValue(tempP2.get(cap))) {
			for(int k = 0; k < cap; k++) {
				tempP1.add(tempP2.get(k));
				tempP1.add(tempP1.get(k));
				tempP1.remove(0);
				tempP2.remove(0);
			}
				System.out.println(tempP1.get(tempP1.size() - 1));
				System.out.println(tempP2.get(tempP2.size() - 1));
				p1Points += 2;
				roundWinner(1);
				System.out.println("Player 1 has: "+ p1Points +" points");
				System.out.println("Player 2 has: "+ p2Points +" points");
				reiterateNum += 1;
				contin();
				rounds();
		} else if(cardValue(tempP1.get(cap)) < cardValue(tempP2.get(cap))){
			for(int l = 0; l < cap; l++) {
				tempP2.add(tempP1.get(l));
				tempP2.add(tempP2.get(l));
				tempP1.remove(0);
				tempP2.remove(0);
			}
				System.out.println(tempP1.get(tempP1.size() - 1));
				System.out.println(tempP2.get(tempP2.size() - 1));
				p2Points += 2;
				roundWinner(2);
				System.out.println("Player 1 has: "+ p1Points +" points");
				System.out.println("Player 2 has: "+ p2Points +" points");
				reiterateNum += 1;
				contin();
				rounds();
		} else {
			System.out.println(tempP1.get(cap));
			System.out.println(tempP2.get(cap));
			System.out.println("ANOTHER WAR!");
			WarCont1(cardValue(tempP1.get(cap)), cardValue(tempP2.get(cap)), cap + 4);
		}
	}
	public void WarCont1(int a, int b, int cap){
		contin();
		if(cardValue(tempP1.get(cap)) > cardValue(tempP2.get(cap))) {
			for(int k = 0; k < cap; k++) {
				tempP1.add(tempP2.get(k));
				tempP1.add(tempP1.get(k));
				tempP1.remove(0);
				tempP2.remove(0);
			}
				System.out.println(tempP1.get(tempP1.size() - 1));
				System.out.println(tempP2.get(tempP2.size() - 1));
				p1Points += 3;
				roundWinner(1);
				System.out.println("Player 1 has: "+ p1Points +" points");
				System.out.println("Player 2 has: "+ p2Points +" points");
				reiterateNum += 2;
				contin();
				rounds();
		} else if(cardValue(tempP1.get(cap)) < cardValue(tempP2.get(cap))){
			for(int l = 0; l < cap; l++) {
				tempP2.add(tempP1.get(l));
				tempP2.add(tempP2.get(l));
				tempP1.remove(0);
				tempP2.remove(0);
			}
				System.out.println(tempP1.get(tempP1.size() - 1));
				System.out.println(tempP2.get(tempP2.size() - 1));
				p2Points += 3;
				roundWinner(2);
				System.out.println("Player 1 has: "+ p1Points +" points");
				System.out.println("Player 2 has: "+ p2Points +" points");
				reiterateNum += 2;
				contin();
				rounds();
		} else {
			System.out.println("ANOTHER WAR!");
			WarCont1(cardValue(tempP1.get(cap)), cardValue(tempP2.get(cap)), cap + 4);
		}
	}
	public int cardValue(String beta) {
		int a = 0;
			if(beta.contains("Ace")) {
				a = 14;
			} else if(beta.contains("King")) {
				a = 13;
			} else if(beta.contains("Queen")) {
				a = 12;
			} else if(beta.contains("Jack")) {
				a = 11;
			} else if(beta.contains("10")) {
				a = 10;
			} else if(beta.contains("9")) {
				a = 9;
			} else if(beta.contains("8")) {
				a = 8;
			} else if(beta.contains("7")) {
				a = 7;
			} else if(beta.contains("6")) {
				a = 6;
			} else if(beta.contains("5")) {
				a = 5;
			} else if(beta.contains("4")) {
				a = 4;
			} else if(beta.contains("3")) {
				a = 3;
			} else if(beta.contains("2")) {
				a = 2;
			}
		return a;
	}
	public void roundWinner(int a) {
		if(a == 1) {
			System.out.println("Winner of this round: Player 1");
			reiterateNum++;
		} else if(a == 2) {
			System.out.println("Winner of this round: Player 2");
			reiterateNum++;
		} else {
			System.out.println("Thanks for playing!");
		}
	}
}

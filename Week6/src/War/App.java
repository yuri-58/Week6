package War;

import java.util.List;
import java.util.Scanner;

public class App {
	Scanner in = new Scanner (System.in);
	Player players = new Player();	
	List<String> player1 = players.dealCardsPlayer1();
	List<String> player2 = players.dealCardsPlayer2();
	
	
	public static void main(String[] args) {
		
		System.out.println(rounds(player1, player2));

	}
	
	public void rounds(List<String> p1, List<String> p2) {
		int a = cardValue(p1.get(0));
		int b = cardValue(p2.get(0));
		if (a > b) {
			player1.add(p1.get(0));
			player1.add(p2.get(0));
		} else if (a == b) {
			
			
			
		} else {
			player2.add(p1.get(0));
			player2.add(p2.get(0));
		}
			
		
	}
	
	public void contin() {
		System.out.println("Press enter to continue ");
		String userInput = in.nextLine();
	}
	
	public void War(){
		
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

}

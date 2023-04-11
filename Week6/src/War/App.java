package War;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		Player players = new Player();	
		System.out.println("Are you ready? ");
		String userResponse = in.nextLine();
		boolean isReady = areReady(userResponse);
		
		if(isReady) {
			players.rounds();
		}

	}
	public static boolean areReady(String delta) {
		if(delta.contains("yes") || delta.contains("Yes")) {
			return true;
		} else {
			System.out.println("Goodbye!");
			return false;
		}
	}
}

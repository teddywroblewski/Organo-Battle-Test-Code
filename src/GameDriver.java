
public class GameDriver {

	public static void main(String[] args) {
		int health = 100;
		int power = 20;
		boolean gameWon = false;
		
		AttackOptions attackOptions = new AttackOptions();
	
		PlayerOne playerOne = new PlayerOne(health, power, true, "Player One");
		PlayerTwo playerTwo = new PlayerTwo(health, power, false, "Player Two");
		
		OpeningWindow ow = new OpeningWindow(playerOne, playerTwo);
		ow.setVisible(true);
		
	}

}

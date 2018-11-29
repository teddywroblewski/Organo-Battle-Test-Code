
public class GameDriver {

	public static void main(String[] args) {
		int health = 100;
		int power = 20;
		boolean gameWon = false;
		
		OpeningWindow ow = new OpeningWindow();
		ow.setVisible(true);
	
		PlayerOne playerOne = new PlayerOne(health, power, true, "Player One");
		PlayerTwo playerTwo = new PlayerTwo(health, power, false, "Player Two");
		SelectionWindow sw = new SelectionWindow(playerOne, playerTwo);
		sw.setVisible(true);
		
	}

}

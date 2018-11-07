
public class PlayerTwo extends Player {
	
	private static int health;
	private static int power;
	private static boolean isTurn;
	private static String playerName;
	
	public PlayerTwo(int health, int power, boolean isTurn, String playerName) {
		this.health = health;
		this.power = power;
		this.isTurn = isTurn;
		this.playerName = playerName;
	}

	@Override 
	public int getHealth() {
		return health;
	}
	@Override
	public void setHealth(int health) {
		this.health = health;
	}
	@Override
	public int getPower() {
		return power;
	}
	@Override
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public boolean isTurn() {
		return isTurn;
	}
	@Override
	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	@Override
	public String getName() {
		return playerName;
	}

}

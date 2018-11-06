package BenzeneGroup;


public abstract class Chemical {
	private String chemical;
	
	public Chemical (String chemical) {
		this.chemical = chemical; 
	}
	
	public abstract Chemical optionOne();
	public abstract Chemical optionTwo();
	public abstract Chemical optionThree();
	public abstract Chemical optionFour();
	
	public String getName() { return chemical; }
	
	public abstract String textOptionOne();
	public abstract String textOptionTwo();
	public abstract String textOptionThree();
	public abstract String textOptionFour();
}

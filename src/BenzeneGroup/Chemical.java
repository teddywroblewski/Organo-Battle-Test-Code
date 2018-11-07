package BenzeneGroup;


public abstract class Chemical {
	private String chemical;
	private boolean isFinal;
	
	public Chemical (String chemical, boolean isFinal) {
		this.chemical = chemical; 
		this.isFinal = isFinal;
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
	
	public boolean isFinal() { return isFinal; }
}

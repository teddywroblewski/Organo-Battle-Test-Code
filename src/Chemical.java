


public abstract class Chemical {
	private String chemical;
	private boolean isFinal;
	private String pictureFile;
	
	public Chemical (String chemical, boolean isFinal, String pictureFile) {
		this.chemical = chemical; 
		this.isFinal = isFinal;
		this.pictureFile = pictureFile;
		
	}
	
	public abstract Chemical optionOne();
	public abstract Chemical optionTwo();
	public abstract Chemical optionThree();
	public abstract Chemical optionFour();
	
	public String getName() { return chemical; }
	
	public String getFile() { return pictureFile; }
	
	public abstract String textOptionOne();
	public abstract String textOptionTwo();
	public abstract String textOptionThree();
	public abstract String textOptionFour();
	
	public boolean isFinal() { return isFinal; }
	
	public static Chemical getStartingChemical(String startingChemical) {
		if (startingChemical.equals("Benzene")) {
			return new Benzene();
		}else if(startingChemical.equals("TwoMethyl2Butene")){
			return new TwoMethyl2Butene();
		}
		
		return null;
	}
}


public class ThreeMethyl2Butanol extends TwoMethyl2Butene {
	public ThreeMethyl2Butanol() {
		super("ThreeMethyl2Butanol", false, "21.jpeg");
	}
	
	public ThreeMethyl2Butanol(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}

	@Override
	public Chemical optionOne() {
		//Acid Catalyzed and Heat
		return new TwoMethyl2Butene();
	}

	@Override
	public Chemical optionTwo() {
		//HBr Addition
		return new TwoBromo3MethylButane();
	}

	@Override
	public Chemical optionThree() { 
		// PCC
		return new MethylIsopropylKetone();
	}

	@Override
	public Chemical optionFour() {
		//Don't have an option yet
		return this;
	}

	@Override
	public String textOptionOne() {
		return "Acid and Heat";
	}

	@Override
	public String textOptionTwo() {
		return "Hydrobromination";
	}

	@Override
	public String textOptionThree() {
		return "PCC";
	}

	@Override
	public String textOptionFour() {
		return "NA";
	}
}

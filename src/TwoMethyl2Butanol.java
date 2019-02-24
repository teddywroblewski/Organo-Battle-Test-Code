
public class TwoMethyl2Butanol extends TwoMethyl2Butene {

	public TwoMethyl2Butanol() {
		super("TwoMethyl2Butanol", false, "20.jpeg");
	}

	public TwoMethyl2Butanol(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}
	
	@Override
	public Chemical optionOne() {
		// reduction and heat
		return new TwoMethyl2Butene();
	}

	@Override
	public Chemical optionTwo() {
		// Hydrogen Bromide 
		return new TwoBromo2MethylButane();
	}

	@Override
	public Chemical optionThree() {
		// NA
		return this;
	}

	@Override
	public Chemical optionFour() {
		// NA
		return this;
	}

	@Override
	public String textOptionOne() {
		return "Reduction and Heat";
	}

	@Override
	public String textOptionTwo() {
		return "Hydrogen Bromide";
	}

	@Override
	public String textOptionThree() {
		return "NA";
	}

	@Override
	public String textOptionFour() {
		return "NA";
	}

}

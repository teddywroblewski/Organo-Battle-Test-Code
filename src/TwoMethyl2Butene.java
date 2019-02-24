
public class TwoMethyl2Butene extends Chemical {
	
	public TwoMethyl2Butene() {
		super("TwoMethyl2Butene", false, "18.jpeg");
	}
	
	public TwoMethyl2Butene(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}

	@Override
	public Chemical optionOne() {
		// Hydrogen bromination
		return new TwoBromo3MethylButane();
	}

	@Override
	public Chemical optionTwo() {
		// Oxymurcueration and oxidation
		return new TwoMethyl2Butanol();
	}

	@Override
	public Chemical optionThree() {
		// Hydroboration
		return new ThreeMethyl2Butanol();
	}

	@Override
	public Chemical optionFour() {
		// Ozanalysis
		return new AcetoneAndAcetaldehyde();
	}

	@Override
	public String textOptionOne() {
		return "Hydrogenbromination";
	}

	@Override
	public String textOptionTwo() {
		return "Oxymercuration";
	}

	@Override
	public String textOptionThree() {
		return "Hydroboration";
	}

	@Override
	public String textOptionFour() {
		return "Ozonolysis";
	}

}

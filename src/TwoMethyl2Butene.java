
public class TwoMethyl2Butene extends Chemical {
	
	public TwoMethyl2Butene() {
		super("TwoMethyl2Butene", false, "18.jpg");
	}
	
	public TwoMethyl2Butene(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}

	@Override
	public Chemical optionOne() { //19
		// Hydrogen bromination
		return new TwoBromo3MethylButane();
	}

	@Override
	public Chemical optionTwo() { //20
		// Oxymurcueration and oxidation
		return new TwoMethyl2Butanol();
	}

	@Override
	public Chemical optionThree() { // 21
		// Hydroboration
		return new ThreeMethyl2Butanol();
	}

	@Override
	public Chemical optionFour() { // 22
		// Ozanalysis
		return new AcetoneAndAcetaldehyde();
	}

	@Override
	public String textOptionOne() {
		return "Hydrogen Bromide";
	}

	@Override
	public String textOptionTwo() {
		return "Oxymercuration";
	}

	@Override
	public String textOptionThree() {
		return "Hydrogenbromination";
	}

	@Override
	public String textOptionFour() {
		return "Ozonolysis";
	}

}


public class TwoBromo3MethylButane extends TwoMethyl2Butene {

	public TwoBromo3MethylButane() {
		super("TwoBromo3MethylButane", false, "19.jpeg");
	}
	
	public TwoBromo3MethylButane(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}
	
	@Override
	public Chemical optionOne() {
		// Hydration
		return new ThreeMethyl2Butanol();
	}

	@Override
	public Chemical optionTwo() {
		// Gringard
		return new ThreeMethyl2ButaneMagnesiumBromide();
	}

	@Override
	public Chemical optionThree() {
		// Triple bond backside attack
		return new TwoMethyl3Octyne();
	}

	@Override
	public Chemical optionFour() {
		// reduction
		return new 2Methyl2Butene();
	}

	@Override
	public String textOptionOne() {
		return "Hydration";
	}

	@Override
	public String textOptionTwo() {
		return "Magnesium";
	}

	@Override
	public String textOptionThree() {
		return "Alkyne and Strong Base";
	}

	@Override
	public String textOptionFour() {
		return "Reduction";
	}

}

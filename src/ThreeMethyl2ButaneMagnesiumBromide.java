
public class ThreeMethyl2ButaneMagnesiumBromide extends TwoBromo3MethylButane {

	public ThreeMethyl2ButaneMagnesiumBromide() {
		super("ThreeMethyl2ButaneMagnesiumBromide", false, "24.jpeg");
	}

	public ThreeMethyl2ButaneMagnesiumBromide(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}
	
	@Override
	public Chemical optionOne() {
		// Strong base and R
		return new TwoMethyl3PhenylButane();
	}

	@Override
	public Chemical optionTwo() {
		// NA
		return this;
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
		return "Strong Base and R Group";
	}

	@Override
	public String textOptionTwo() {
		return "NA";
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

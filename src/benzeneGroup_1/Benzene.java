package benzeneGroup_1;

public class Benzene extends Chemical {
	
	public Benzene() {
		super("Benzene", false, "3.jpeg");
		
	}
	public Benzene(String name, boolean isFinal, String pictureFile) {
		super(name, isFinal, pictureFile);
	}
	
	@Override
	public Chemical optionOne() {
		// Freidel Crafts
		return new Methylbenzene();
	}
	@Override
	public Chemical optionTwo() {
		// Bromination
		return new Bromobenzene();
	}
	@Override
	public Chemical optionThree() {
		// Nitration
		return new Nitrobenzene();
	}
	@Override
	public Chemical optionFour() {
		// Sulfonation
		return new BenezesulfonicAcid();
	}
	@Override
	public String textOptionOne() {
		return "Friedel Crafts";
	}
	@Override
	public String textOptionTwo() {
		return "Bromination";
	}
	@Override
	public String textOptionThree() {
		return "Nitration";
	}
	@Override
	public String textOptionFour() {
		return "Sulfonation";
	}
}

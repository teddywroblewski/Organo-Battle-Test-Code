package BenzeneGroup;

public class Benzene extends Chemical {
	
	public Benzene() {
		super("Benzene");
		// this will call the graphic benzene 
		
	}
	public Benzene(String name) {
		super(name);
	}
	
	@Override
	public Chemical optionOne() {
		// Freidel Crafts
		System.out.println("returning Methyl");
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

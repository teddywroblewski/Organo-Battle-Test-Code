package BenzeneGroup;

public class Nitrobenzene extends Benzene {

	public Nitrobenzene() {
		super("Nitrobenzene", false); 
		
	}
	public Nitrobenzene(String name, boolean isFinal) {
		super(name, isFinal);
	}
	
	@Override
	public Chemical optionOne() {
		// Nitration
		return new MDinitrobenzene();
	}
	@Override
	public Chemical optionTwo() {
		// Sulfonation
		return new MetanilicAicd();
	}
	@Override
	public Chemical optionThree() {
		// Chlorination
		return new MChloronitrobenzene();
	}
	@Override
	public Chemical optionFour() {
		// reduction
		return new Aniline();
	}
	@Override
	public String textOptionOne() {
		return "Nitration";
	}
	@Override
	public String textOptionTwo() {
		return "Sulfonation";
	}
	@Override
	public String textOptionThree() {
		return "Chlorination";
	}
	@Override
	public String textOptionFour() {
		return "Reduction";
	}
}

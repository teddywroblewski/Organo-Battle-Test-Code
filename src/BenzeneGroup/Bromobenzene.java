package BenzeneGroup;

public class Bromobenzene extends Benzene {
	
	public Bromobenzene() {
		super("Bromobenzene", false);
	}
	
	public Bromobenzene(String name, boolean isFinal) {
		super(name, isFinal);
	}
	
	@Override
	public Chemical optionOne() {
		// Grignard Reaction
		return new PhenylmagnesiumBromide();
	}
	@Override
	public Chemical optionTwo() {
		// Potassium Cyanate
		return new Benzonitrile();
	}
	@Override
	public Chemical optionThree() {
		// Friedel 
		return new PBromotoluene();
	}
	@Override
	public Chemical optionFour() {
		// NAA with NaNH2
		return new Aniline();
	}
	@Override
	public String textOptionOne() {
		return "Grignard Reaction";
	}
	@Override
	public String textOptionTwo() {
		return "Pottassium Cyanate";
	}
	@Override
	public String textOptionThree() {
		return "Friedel Crafts Acelation with Methyl Chloride";
	}
	@Override
	public String textOptionFour() {
		return "Nucleophilic Areomatic Attack with NaNH2";
	}
}

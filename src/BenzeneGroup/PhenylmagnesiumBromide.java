package BenzeneGroup;

public class PhenylmagnesiumBromide extends Bromobenzene {

	public PhenylmagnesiumBromide() {
		super("PhenylmagnesiumBromide", false);
	}
	
	public PhenylmagnesiumBromide(String name, boolean isFinal) {
		super(name, isFinal);
	}
	
	@Override
	public Chemical optionOne() {
		// Sn2 with NFM
		return new BenzoicAcid();
	}
	@Override
	public Chemical optionTwo() {
		// Sn2 with Methyl Bromide
		return new Methylbenzene();
	}
	@Override
	public Chemical optionThree() {
		// Hydration
		return new Benzene();
	}
	@Override
	public Chemical optionFour() {
		// React with Ketone
		return new TWOPhenyl2Propanol();
	}
	@Override
	public String textOptionOne() {
		return "Sn2 Reaction with NFM";
	}
	@Override
	public String textOptionTwo() {
		return "Sn2 with Methyl Bromide";
	}
	@Override
	public String textOptionThree() {
		return "Hydration";
	}
	@Override
	public String textOptionFour() {
		return "React with Ketone";
	}
}

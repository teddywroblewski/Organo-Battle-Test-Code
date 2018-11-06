package BenzeneGroup;

public class Methylbenzene extends Benzene {
	
	public Methylbenzene() {
		super("Methylbenzene");
	}
	public Methylbenzene(String name) {
		super(name);
	}
	
	@Override
	public Chemical optionOne() {
		// excessNitrofication
		System.out.println("returning tri");
		return new Trinitrotoluene();
	}
	@Override
	public Chemical optionTwo() {
		return new Methylbromobenzene();
	}
	@Override
	public Chemical optionThree() {
		return new BenzoicAcid();
	}
	@Override
	public Chemical optionFour() {
		return new PXylene();
	}
	
	@Override
	public String textOptionOne() {
		return "Excess Nitrofication with Heat";
	}
	@Override
	public String textOptionTwo() {
		return "Bromination";
	}
	@Override
	public String textOptionThree() {
		return "Oxidation";
	}
	@Override
	public String textOptionFour() {
		return "Fridel Crafts Acelation with Methyl Chloride";
	}
}

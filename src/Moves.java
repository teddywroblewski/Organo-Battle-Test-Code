
//This class keeps track of all the moves and chemical groups

public class Moves {
	//Working List of Attacks
	private String attacks[][] = {{"Explosion", "Acid Attack"}, //This is the shown name
								  {"Trinitrotoluene", "Acid"}}; //This is the chemical name
	
	//Working List of Defends
	private String defends[][] = {{"Anti Inflammitory", "Defend2"}, //This is the shown name
									{"BenzoicAcid", "DefendChemical"}}; //This is the chemical name
	
	//Working List of Groups
	private  String groups[] = {"Benzene", "Alkenes"};
	
	//Constructor
	public Moves() {}
	
	//Attack Getters
	public String getAttackName(int index) {
		String name = attacks[0][index];
		return name;
	}
	
	public String getAttackChemical(int index) {
		String chemical = attacks[1][index];
		return chemical;
	}
	
	//Defend Getters
	public String getDefendName(int index) {
		String name = defends[0][index];
		return name;
	}
	public String getDefendChemical(int index) {
		String chemical = defends[1][index];
		return chemical;
	}
	
	//Group Getter
	public int getGroupNum(int index) {
		if(index<=2) { return 1; } //Benzene Group 
		else { return 2;} //Other Group
	}
	
}

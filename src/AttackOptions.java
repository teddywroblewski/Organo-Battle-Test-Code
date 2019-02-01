import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public final class AttackOptions {
	
	private static HashSet<String> attackOptions;
	private static HashMap<String, Chemical> startingChemicals;

	public AttackOptions() {
		attackOptions = new HashSet<String>();
		startingChemicals = new HashMap<String, Chemical>();
		try {
			Scanner textIn = new Scanner(new File("attacks.txt")).useDelimiter(",");
			Scanner textMapIn = new Scanner(new File("attackMap.txt")).useDelimiter(",");
			while (textIn.hasNext()) {
				attackOptions.add(textIn.next());
			}
			while (textMapIn.hasNext()) {
				String endChemical = textMapIn.next();
				String starting = textMapIn.next();
				Chemical startingChem = Chemical.getStartingChemical(starting);
				startingChemicals.put(endChemical, startingChem);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static HashSet<String> getAcidAttacks() {
		HashSet<String> ret = new HashSet<String>();
		int randTarget = new Random().nextInt(attackOptions.size() - 5);
		int i = 0;
		int j = 0;
		for (String chem : attackOptions) {
			if (i == randTarget) {
				ret.add(chem);
				randTarget++;
				j++;
			}
			i++;
			if (j == 5) {
				break;
			}
		}
		return ret;
	}
	
	public static Chemical getStartChemical(String targetChemical) {
		return startingChemicals.get(targetChemical);
	}
}

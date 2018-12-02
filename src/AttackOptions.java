import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import BenzeneGroup.Chemical;

public final class AttackOptions {
	
	private static HashSet<String> attackOptions;
	private static HashMap<String, Chemical> startingChemicals;

	public AttackOptions() {
		try {
			Scanner textIn = new Scanner(new File("attacks.txt"));
			Scanner textMapIn = new Scanner(new File("attackMap.txt"));
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
		int i = 0;
		for (String chem : attackOptions) {
			ret.add(chem);
			i++;
			if (i == 5) {
				break;
			}
		}
		return ret;
	}
	
	public static Chemical getStartChemical(String targetChemical) {
		return startingChemicals.get(targetChemical);
	}
}

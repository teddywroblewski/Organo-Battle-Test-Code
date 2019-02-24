import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public final class DefenseOptions {
	private static HashSet<String> defenseOptions;
	private static HashMap<String, Chemical> startingChemicals;

	public DefenseOptions() {
		defenseOptions = new HashSet<String>();
		startingChemicals = new HashMap<String, Chemical>();
		
		try {
			
			Scanner textIn = new Scanner(new File("defenses.txt")).useDelimiter(",");
			Scanner textMapIn = new Scanner(new File("defenseMap.txt")).useDelimiter(",");
			while (textIn.hasNext()) {
				defenseOptions.add(textIn.next());
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
	
	public static HashSet<String> getAntiInflamatoryDefenses() {
		HashSet<String> ret = new HashSet<String>();
		int size = defenseOptions.size();
		int randTarget = 0;
		if (randTarget > 5){
			randTarget = new Random().nextInt(defenseOptions.size() - 5);
		}
		int i = 0;
		int j = 0;
		for (String chem : defenseOptions) {
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
	
	public static Chemical getStartingChemical(String targetChemical) {
		return startingChemicals.get(targetChemical);
	}
}

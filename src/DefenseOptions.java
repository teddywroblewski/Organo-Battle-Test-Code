import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public final class DefenseOptions {
	private HashSet<String> defenseOptions;
	private static HashMap<String, Chemical> startingChemicals;

	public DefenseOptions() {
		try {
			Scanner textIn = new Scanner(new File("defenses.txt"));
			Scanner textMapIn = new Scanner(new File("defenseMap.txt"));
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
		return null;
	}
	
	public static Chemical getStartingChemical(String targetChemical) {
		return startingChemicals.get(targetChemical);
	}
}

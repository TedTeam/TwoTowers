package tedteam.twotowers.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCompare {
		
	/**
	 * Compare fo fuggvenye, ez hivodik meg a parancs kiadasanal. 
	 * Beolvassuk a fajlok tartalmat, osszehasonlitjuk a sorokat, majd kiirjuk a hibakat. 
	 * @param locActual
	 * @param locIdeal
	 * @return
	 */
	public String inputFile(String locActual, String locIdeal) {
		ArrayList<String> actualTest = new ArrayList<String>();
		ArrayList<String> idealTest = new ArrayList<String>();
		
		//beolvas
		if(!readFromFile(actualTest, locActual)) return "File loading unsuccess";
		if(!readFromFile(idealTest, locIdeal)) return "File loading unsuccess";
		
		ArrayList<Integer> wrongLines = compareTest(actualTest,idealTest);
		if(wrongLines.size() == 0) {
			return "Successful testing";
		} else { 
			printErrors(actualTest, idealTest, wrongLines);
			return "Failed testing";
		}
	}
	
	/**
	 * A ket bemeneti fajl osszehasonlitasa tortenik meg.
	 * @param actualTest
	 * @param idealTest
	 * @return
	 */
	private ArrayList<Integer> compareTest(ArrayList<String> actualTest, ArrayList<String> idealTest) {
		ArrayList<Integer> wrongLines = new ArrayList<Integer>();
		int max = 0; //eddig megy a ciklus
		if(actualTest.size() <= idealTest.size())
			max = actualTest.size();
		else max = idealTest.size(); //ha az idealis a kisebb, addig megy
		for(int i = 0; i < max; ++i) {
			if(!actualTest.get(i).equals(idealTest.get(i)) && !actualTest.get(i).equals(""))
				wrongLines.add(i+1);
		}
		
		//Ha nem egyeznek a sor meretek, akkor azok a sorok, amiknek a masik fajlba nincs parja, 
		//hibasnak tekinthetoek.
		if(actualTest.size() < idealTest.size()) {
			for(int i = 0; i< (idealTest.size()-actualTest.size()); ++i)
				wrongLines.add(actualTest.size()+i +1);
		}
		//ha a tesztelt kimenet a nagyobb, akkor a plusz sorokat hibasnak irjuk.
		if(actualTest.size() > idealTest.size()) {
			for(int i = 0; i< (actualTest.size()-idealTest.size()); ++i)
				wrongLines.add(idealTest.size()+i +1);
		}
		return wrongLines;
	}
	
	/**
	 * A hibas sorokat irja ki sorszammal.
	 * @param actualTest
	 * @param wrongLines
	 */
	private void printErrors(ArrayList<String> actualTest, 
			ArrayList<String> idealTest, ArrayList<Integer> wrongLines) {
		System.out.println("Wrong lines in output: ");
		for(int i = 0; i < wrongLines.size(); ++i) {
			//ha null, az azt jelenti, hogy az egy olyan sor, ami a helyes megoldasban benne van,
			//de a teszteltben nincs
			try {
				System.out.println("    Line: "+ wrongLines.get(i) 
						+ " Output: " + actualTest.get(wrongLines.get(i)-1));
				if(wrongLines.get(i) <= idealTest.size())
					System.out.println("             Ideal: "+ idealTest.get(wrongLines.get(i)-1));
				else 
					System.out.println("             Ideal: no pair");
			} catch(IndexOutOfBoundsException e) {
				System.out.println("    Line: "+ wrongLines.get(i) 
						+ " Missing output row.");
			}
		}
				
				
	}
	
	/**
	 * Beolvassuk a listaba a fileName helyen levo és nevu fajlt.
	 * @param list
	 * @param fileName
	 * @return
	 */
	private boolean readFromFile(ArrayList<String> list, String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				//System.out.println(line);
				line = br.readLine();
			}
			br.close();
			return true; 
		} catch (IOException e) {
			return false;
		}	
		
	}
}

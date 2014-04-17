package tedteam.twotowers.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCompare {
		
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
			printErrors(actualTest, wrongLines);
			return "Failed testing";
		}
	}
	
	private ArrayList<Integer> compareTest(ArrayList<String> actualTest, ArrayList<String> idealTest) {
		ArrayList<Integer> wrongLines = new ArrayList<Integer>();
		int max = 0; //eddig megy a ciklus
		if(actualTest.size() <= idealTest.size())
			max = actualTest.size();
		else max = idealTest.size(); //ha az idealis a kisebb, addig megy
		for(int i = 0; i < max; ++i) {
			if(actualTest.get(i) != idealTest.get(i))
				wrongLines.add(i+1);
		}
		
		//Ha nem egyeznek a sor meretek, a nem paros sorok azok hibasak.
		if(actualTest.size() < idealTest.size()) {
			for(int i = 0; i< (idealTest.size()-actualTest.size()); ++i)
				wrongLines.add(actualTest.size()+i);
		}
		if(actualTest.size() < idealTest.size()) {
			for(int i = 0; i< (actualTest.size()-idealTest.size()); ++i)
				wrongLines.add(idealTest.size()+i);
		}
		return wrongLines;
	}
	
	private void printErrors(ArrayList<String> actualTest, ArrayList<Integer> wrongLines) {
		for(int i = 0; i < wrongLines.size(); ++i) {
			String actual = actualTest.get(wrongLines.get(i));
			if(actual == null) {
				System.out.println("Error: No matching output row in ideal command row.");
			} else {
				System.out.println("Line: "+ wrongLines.get(i) 
						+ "Output: " + actualTest.get(wrongLines.get(i)));
			}
		}
				
				
	}
	
	private boolean readFromFile(ArrayList<String> list, String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
			return true; 
		} catch (IOException e) {
			return false;
		}	
		
	}
}

package tedteam.twotowers.logger;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tedteam.twotowers.main.BlackStone;
import tedteam.twotowers.main.Blocker;
import tedteam.twotowers.main.Cell;
import tedteam.twotowers.main.GameState;
import tedteam.twotowers.main.Generator;
import tedteam.twotowers.main.GreenStone;
import tedteam.twotowers.main.Tower;


public class Menu {

	public int choice;

	public void handleChoice() {
		Logger.count=0;
		Logger.resetLines();
		
		switch (choice) {

		case 1:
			Generator g1 = new Generator();
			g1.buildField();		
			break;
		case 2:
			GameState gs2 = new GameState();
			gs2.checkGame();
			break;
		case 3:
			Generator g3 = new Generator();
			Cell c3 = new Cell();
			g3.createBlocker(c3);
			break;
		case 4:
			Generator g4 = new Generator();
			Cell c4 = new Cell();
			g4.createTower(c4);
			break;
		case 5:
			Generator g5 = new Generator();
			BlackStone bs = new BlackStone();
			
			Cell c5 = new Cell();
			c5.setElement(new  Blocker());
			g5.addStone(bs, c5);
			break;
		case 6:
			Generator g6 = new Generator();
			GreenStone gs = new GreenStone();
			
			Cell c6 = new Cell();
			c6.setElement(new Tower());
			g6.addStone(gs, c6);						
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
			
		}
		Logger.printLines();
	}

	public void printMenu() throws IOException {

		System.out.println("-------- Menu --------");
		System.out.println();

		System.out.println("(  1 ) Pálya felépítése");
		System.out.println("(  2 ) Játékállás ellenõrzése");
		System.out.println("(  3 ) Akadály építése");
		System.out.println("(  4 ) Torony építése");
		System.out.println("(  5 ) Kõ akadályra helyezése");
		System.out.println("(  6 ) Kõ toronyra helyezése");
		System.out.println("(  7 ) Akadály hatása");
		System.out.println("(  8 ) Torony lövés");
		System.out.println("(  9 ) Ellenség generálás");
		System.out.println("( 10 ) Léptetés");
		System.out.println("( 11 ) Ellenség sebzés");
		System.out.println();

		System.out.println("Kérlek válassz menüpontot: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		try {
			choice = Integer.parseInt(s1);
			if (choice > 11 | choice < 1) {
				System.err.println("Invalid Format!");
				String s2 = br.readLine();
				choice = Integer.parseInt(s2);
			}
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}
		System.out.println(choice);

	}
	


}

package tedteam.twotowers.logger;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tedteam.twotowers.main.BlackStone;
import tedteam.twotowers.main.Blocker;
import tedteam.twotowers.main.Cell;
import tedteam.twotowers.main.ElementList;
import tedteam.twotowers.main.EnemyList;
import tedteam.twotowers.main.GameState;
import tedteam.twotowers.main.Generator;
import tedteam.twotowers.main.GreenStone;
import tedteam.twotowers.main.Hobbit;
import tedteam.twotowers.main.Tower;

/**
 * Ez az osztaly listazza ki a valaszthato szekvenciakat. 
 */
public class Menu {

	public int choice;

	/**
	 * Ez a metodus kezeli le a felhasznalo altal valasztott menupontot,
	 * vagyis valasztastol fuggoen meghivja az adott szekvencia kezdo metodusat,
	 * ill. letrehozza a szukseges objektumokat.
	 */
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
			ElementList el7 = new ElementList();
			el7.addElement(new Blocker());
			el7.notifyAllElement();
			
			break;
		case 8:
			ElementList elementList = new ElementList();
			elementList.addElement(new Tower());
			elementList.notifyAllElement();
			break;
		case 9:
			Generator g9 = new Generator();
			g9.generateEnemies();
			break;
		case 10:
			EnemyList enemyList = new EnemyList();
			enemyList.stepAll();
			break;
		case 11:
			Tower tower11 = new Tower();
			Hobbit hobbit11 = new Hobbit();
			hobbit11.acceptDamage(tower11);
			break;
			
		}
		Logger.printLines();
	}
	
	/**
	 * Ez a metodus irja ki a valaszthato menupontokat.
	 * Hibakezeles is talalhato benne, ha esetleg a felhasznalo rossz szamot adna meg.
	 */
	public void printMenu() throws IOException {

		System.out.println("-------- Menu --------");
		System.out.println();

		System.out.println("(  1 ) Palya felepitese");
		System.out.println("(  2 ) Jatekallas ellenorzese");
		System.out.println("(  3 ) Akadaly epitese");
		System.out.println("(  4 ) Torony epitese");
		System.out.println("(  5 ) Ko akadalyra helyezese");
		System.out.println("(  6 ) Ko toronyra helyezese");
		System.out.println("(  7 ) Akadaly hatasa");
		System.out.println("(  8 ) Torony loves");
		System.out.println("(  9 ) Ellenseg generalas");
		System.out.println("( 10 ) Leptetes");
		System.out.println("( 11 ) Ellenseg sebzes");
		System.out.println();

		System.out.println("Kerlek valassz menupontot: ");

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

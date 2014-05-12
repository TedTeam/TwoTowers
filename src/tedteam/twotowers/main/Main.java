package tedteam.twotowers.main;

import java.io.IOException;

/**
 * A Main osztaly. Itt hozzuk letre a jatek osszes fobb objektumat,
 * es beallitjuk azok osszefuggosegeit.
 * A jatek elejen egy menuvel inditunk, majd ha abbol tovabbleptunk
 * kirajzoljuk a palyat es elinditjuk a jatek utemezojet.
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Generator generator = new Generator();
		EnemyList enemyList = new EnemyList();
		ElementList elementList = new ElementList();
		GameState gameState = new GameState();
		GameField gameField = new GameField();
		Controller controller = new Controller();
		Converter converter = new Converter();
		Scheduler scheduler = new Scheduler();
		ManaController manaController = new ManaController();
		View view = new View();
		User user = new User();
		Hit hit = new Hit();
		hit.setConverter(converter);
		generator.setGameState(gameState);
		generator.setGameField(gameField);
		generator.setHit(hit);
		gameState.setElementList(elementList);
		gameState.setEnemyList(enemyList);
		gameState.setManaController(manaController);
		converter.setGameField(gameField);
		scheduler.setGenerator(generator);
		scheduler.setController(controller);
		manaController.setUser(user);
		
		user.setGenerator(generator);
		view.setController(controller);
		controller.setView(view);
		controller.setUser(user);
		controller.setConverter(converter);
		controller.setGameField(gameField);
		controller.setGameState(gameState);
		controller.setHit(hit);
	
		gameField.init();
		gameState.setFinalCell(gameField.getFinalCell());
		
		MenuView menuView = new MenuView();
		menuView.initComponents(); 
		while(menuView.wait) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		view.init();
		gameState.setMaximumEnemy(15);
		scheduler.work();
	}

}

package tedteam.twotowers.main;


import java.io.IOException;




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
		generator.setGameState(gameState);
		generator.setGameField(gameField);
		gameState.setElementList(elementList);
		gameState.setEnemyList(enemyList);
		
		View view = new View();
		User user = new User();
		view.setController(controller);
		controller.setView(view);
		controller.setUser(user);
		view.init();
		
		//view.modifyField();
		view.field.removeAll();
		

		
		view.drawIcon(0,0);
		view.field.repaint();
	}

}

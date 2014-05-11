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
		Converter converter = new Converter();
		Scheduler scheduler = new Scheduler();
		ManaController manaController = new ManaController();
		View view = new View();
		User user = new User();
		generator.setGameState(gameState);
		generator.setGameField(gameField);
		gameState.setElementList(elementList);
		gameState.setEnemyList(enemyList);
		gameState.setManaController(manaController);
		converter.setGameField(gameField);
		scheduler.setEnemyList(enemyList);
		scheduler.setController(controller);
		scheduler.setElementList(elementList);
		manaController.setUser(user);
		
		user.setGenerator(generator);
		view.setController(controller);
		controller.setView(view);
		controller.setUser(user);
		controller.setConverter(converter);
		controller.setGameField(gameField);
		controller.setGameState(gameState);
		
		gameField.init();
		view.init();
		generator.generateEnemies();
		scheduler.work();
		
	}

}

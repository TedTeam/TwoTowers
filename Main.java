package tedteam.twotowers.main;


import java.io.IOException;




public class Main {

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		MenuView menuView = new MenuView();
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
		controller.setHit(hit);
		
		gameField.init();
		
		menuView.initComponents();
		while(menuView.wait) {Thread.sleep(1000);}
		view.init();
		generator.generateEnemies();
		scheduler.work();
		
	}

}

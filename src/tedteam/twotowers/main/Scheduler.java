package tedteam.twotowers.main;

public class Scheduler {

	Controller controller;
	Generator generator;
	
	final int STEP = 200; //ennyi ms-onkent tortenik tick
	
	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void work(){

	    double started = System.currentTimeMillis();
	    int tick = 0;
	    while (true) {
	        while (System.currentTimeMillis() > (started+tick*STEP)) {
	        	if(tick % 100 == 0 && generator.getGameState().getMaximumEnemy() != generator.getGameState().getCountEnemy()) {
	        		generator.generateEnemies();
	        		generator.generateEnemies();
	        		generator.generateEnemies();
	        	} if(tick % 20 == 0 && generator.getGameState().getMaximumEnemy() != generator.getGameState().getCountEnemy()) {
	        		generator.generateEnemies();
	        	}
	    		generator.getGameState().getEnemyList().stepAll();
	    		generator.getGameState().getElementList().notifyAllElement();
	    		controller.drawAll();
	    		tick++;
	    		
	    		if(generator.getGameState().checkGame()) {
	    			System.exit(0);
	    		}
	    			
	            }
	        
	    }
	}
}

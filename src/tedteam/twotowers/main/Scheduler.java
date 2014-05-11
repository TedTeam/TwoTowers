package tedteam.twotowers.main;

/**
 * Az utemezesert felelos osztaly. Ez utemezi az ellensegek lepteteset,
 * a tornyok loveset, valamint a grafikus felulet kirajzolasat is.
 */
public class Scheduler {
	// Referencia egy Controller objektumra
	Controller controller;
	// Referencia egy Generator objektumra
	Generator generator;
	// Ennyi ms-onkent tortenik tick
	final int STEP = 200;
	
	/**
	 * Beallitja a generator objektumot.
	 * @param generator: erre allitja be.
	 */
	public void setGenerator(Generator generator) {
		this.generator = generator;
	}
	
	/**
	 * Beallitja a controller objektumot.
	 * @param controller: erre allitja be.
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * A jatek utemezeseert felelos metodus.
	 * Egy vegtelen ciklusbol all, melyben megvizsgaljuk, hogy tortent-e tick.
	 * Ha igen, akkor megnezzuk, hogy generalhatunk-e ellensegeket, majd
	 * meghivjuk az osszes ellenseg lepteto fuggvenyet, az osszes epitmeny
	 * akcio fuggvenyet, valamint a kirajzolo fuggvenyt.
	 * Illetve azt is megnezzuk, hogy nem-e ert veget a jatek.
	 */
	public void work() {
	    double started = System.currentTimeMillis();
	    int tick = 0;
	    while (true) {
	        while (System.currentTimeMillis() > (started+tick*STEP)) {
	        	if(tick % 100 == 0 && generator.getGameState().getMaximumEnemy() != generator.getGameState().getCountEnemy()) {
	        		generator.generateEnemies();
	        		generator.generateEnemies();
	        		generator.generateEnemies();
	        	} if(tick % 40 == 0 && generator.getGameState().getMaximumEnemy() != generator.getGameState().getCountEnemy()) {
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

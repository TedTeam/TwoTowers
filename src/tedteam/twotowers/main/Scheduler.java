package tedteam.twotowers.main;

public class Scheduler {

	EnemyList enemyList;
	Controller controller;
	
	final int STEP = 1000; //ennyi ms-onkent tortenik tick
	
	public void setEnemyList(EnemyList enemyList) {
		this.enemyList = enemyList;
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}


	public void work(){

	    double started = System.currentTimeMillis();
	    int tick = 0;
	    
	    while (true) {
	        while (System.currentTimeMillis() > (started+tick*STEP)) {

	    		enemyList.stepAll();
	    		controller.drawAll();
	    		tick++;
	            }
	        
	    }
	}
}

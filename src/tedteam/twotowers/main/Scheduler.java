package tedteam.twotowers.main;

public class Scheduler {

	EnemyList enemyList;
	Controller controller;
	ElementList elementList;
	
	final int STEP = 200; //ennyi ms-onkent tortenik tick
	
	public void setEnemyList(EnemyList enemyList) {
		this.enemyList = enemyList;
	}


	
	public void setElementList(ElementList elementList) {
		this.elementList = elementList;
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
	    		elementList.notifyAllElement();
	    		controller.drawAll();
	    		tick++;
	            }
	        
	    }
	}
}

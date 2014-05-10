package tedteam.twotowers.main;

public class Scheduler {

	EnemyList enemyList;
	Controller controller;
	
	public void setEnemyList(EnemyList enemyList) {
		this.enemyList = enemyList;
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}


	public void work(){
		while(true){
			for(int i=0;i<10000;i++)
				for(int j=0;j<10000;j++);
		enemyList.stepAll();
		controller.drawAll();
		}
	}
}

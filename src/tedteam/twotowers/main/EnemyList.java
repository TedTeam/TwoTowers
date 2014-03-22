package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class EnemyList {

	private Enemy enemies[] = new Enemy[20];

	/**
	 * 
	 * @param e
	 */
	public void addEnemy(Enemy enemy){
		Logger.enter("enemyList", "addEnemy", "enemy", "");
		
		Logger.exit("void");
	}

	/**
	 * 
	 * @param e
	 */
	public void deleteEnemy(Enemy e){

	}


	public void stepAll(){
		Logger.enter("enemyList", "stepAll", "","");
		
		enemies[0] = new Hobbit();
		enemies[0].step();
		Logger.exit("void");
	}

	public void notifyAllEnemy(IDamage d) {
		
	}

}
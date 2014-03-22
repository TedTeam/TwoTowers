package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Hobbit extends Enemy {

	/**
	 * 
	 * @param d
	 */
	public void acceptDamage(IDamage d){
		Logger.enter("hobbit", "acceptDamage", "tower", "");
		
		d.affect(this);
		
		Logger.exit("void");

	}

	/**
	 * 
	 * @param g
	 * @param c
	 */
	public void init(GameState gameState, Cell cell){
		Logger.enter("hobbit", "init", "gameState", "cell");
		
		Logger.exit("void");
	}

	public void step() {
		Logger.enter("hobbit", "step", "", "");
		
		Cell neighbors[] = cell.getNeighbors();
		neighbors[0].hasRoad();
		neighbors[1].hasRoad();
		neighbors[2].hasRoad();
		neighbors[3].hasRoad();
		neighbors[3].addEnemy(this);
		Logger.exit("void");
	}
	
	public void damage(int damageValue) {
		Logger.enter("hobbit", "damageValue", "damageValue:int", "");
		
		Logger.exit("void");
	}
}
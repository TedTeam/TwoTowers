package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Elf extends Enemy {

	/**
	 * 
	 * @param v
	 */
	public void acceptDamage(IDamage v){

	}

	/**
	 * 
	 * @param g
	 * @param c
	 */
	public void init(GameState g, Cell c) {

	}
	
	public void block(int slowing) {
		Logger.enter("elf", "block", "slowing: int", "");
		
		Logger.exit("void");
	}

}
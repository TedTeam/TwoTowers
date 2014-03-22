package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class GreenStone extends MagicStone {

	/**
	 * 
	 * @param b
	 */
	public boolean effect(Blocker b){
		return false;
	}

	/**
	 * 
	 * @param t
	 */
	public boolean effect(Tower tower){
		Logger.enter("greenStone", "effect", "tower", "");
		
		int i = 0;
		
		tower.setSpeed(i);
		
		Logger.exit("true");
		return true;
	}

}
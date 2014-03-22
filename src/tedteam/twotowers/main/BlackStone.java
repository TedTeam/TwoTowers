package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class BlackStone extends MagicStone {

	/**
	 * 
	 * @param b
	 */
	public boolean effect(Blocker blocker) {
		Logger.enter("blackStone", "effect", "blocker", "");
		
		int i = 0;
		
		blocker.setSlowing(i);
		
		Logger.exit("true");
		return true;
	}

	/**
	 * 
	 * @param t
	 */
	public boolean effect(Tower t){
		return false;
	}

}
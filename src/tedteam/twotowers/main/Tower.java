package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Tower extends Element {

	/**
	 * 
	 * @param m
	 */
	public boolean enhance(MagicStone greenStone) {
		Logger.enter("tower", "enchance", "greenStone", "");
		greenStone.effect(this);
		
		Logger.exit("true");
		return true;
	}

	public void setCell(Cell cell) {
		Logger.enter("tower", "setCell", "cell", "");
		
		cell.setElement(this);
		
		Logger.exit("false");
	}
	
	public void setSpeed(int i) {
		Logger.enter("tower", "setSpeed", "i:int", "");
		
		Logger.exit("true");		
	}
	
	/**
	 * Loggoláshoz, skeleton után törlendő!
	 * @return
	 */
	public String loggerGetName() {
		return "Tower";
	}
}
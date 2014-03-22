package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Blocker extends Element {

	private GameState gameState = new GameState();
	private int countRemain = 0;
	private int slowing = 0;
	

	/**
	 * 
	 * @param m
	 */
	public boolean enhance(MagicStone blackStone) {
		Logger.enter("blocker", "enchance", "blackStone", "");
		blackStone.effect(this);
		
		Logger.exit("true");
		return true;
	}

	public void setCell(Cell cell) {
		Logger.enter("blocker", "setCell", "", "");
		
		cell.setElement(this);
		
		Logger.exit("void");
	}

	public void setGameState(GameState gameState) {
		Logger.enter("blocker", "setGameState", "gameState","");
		this.gameState = gameState;
		
		Logger.exit("void");
	}
	
	public void setSlowing(int i) {
		Logger.enter("blocker", "setSlowing", "i:int", "");
		
		Logger.exit("true");
	}
	
	/**
	 * Loggoláshoz, skeleton után törlendő!
	 * @return
	 */
	public String loggerGetName() {
		return "Blocker";
	}
	

}
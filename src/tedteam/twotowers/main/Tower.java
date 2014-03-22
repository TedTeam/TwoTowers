package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Tower extends Element implements IDamage {

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

	
	public void action() {
		Logger.enter("tower", "action", "", "");
		
		Cell cell1 = new Cell();
		Enemy[] enemies = new Enemy[10];
		enemies = cell1.getEnemy();
		enemies[0].acceptDamage(this);
		
		Logger.exit("void");	
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
	

	@Override
	public void affect(Hobbit e) {
		Logger.enter("tower", "affect", "hobbit", "");
		
		int damageValue = 0;
		e.damage(damageValue);
		
		Logger.exit("void");
		
	}

	@Override
	public void affect(Elf e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affect(Dwarf d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affect(Human h) {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * Loggoláshoz, skeleton után törlendő!
	 * @return
	 */
	public String loggerGetName() {
		return "Tower";
	}
}
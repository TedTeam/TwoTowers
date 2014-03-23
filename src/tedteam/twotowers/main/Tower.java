package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A tornyot megvalosito osztaly. Egy torony fobb
 * tulajdonsagait tartalmazza.
 * Ososztaly: Element
 * Interface: IDamage
 */
public class Tower extends Element implements IDamage {
	// A torp ellenseg sebzesenek merteke.
	private int dwarfDamage;
	
	// A tunde ellenseg sebzesenek merteke.
	private int elfDamage;
	
	// A hobbit ellenseg sebzesenek merteke.
	private int hobbitDamage;
	
	// Az ember ellenseg sebzesenek merteke.
	private int humanDamage;
	
	// A torony hatotavolsaga.
	private int range;
	
	// A torony tuzelesi gyakorisaga.
	private int speed;
	
	/**
	 * Ez a metodus donti el, hogy a varazskovel lehet-e erositeni
	 * a tornyot. Ha igen, akkor erositi is.
	 * A szkeleton miatt itt konkret pelda.
	 * @param greenStone: a varazsko, mellyel erositeni szeretnenk a tornyot.
	 * @return visszajelzes, hogy sikeres volt-e a muvelet.
	 */
	public boolean enhance(MagicStone greenStone) {
		Logger.enter("tower", "enhance", "greenStone", "");
		greenStone.effect(this);
		
		Logger.exit("true");
		return true;
	}

	/**
	 * A torony loveset vegrehajto metodus.
	 */
	public void action() {
		Logger.enter("tower", "action", "", "");
		Cell[] cells=cell.getNeighbors();

		cells[0].getEnemy();
		cells[1].getEnemy();
		Enemy hobbit=new Hobbit();
		hobbit.acceptDamage(this);

		
		Logger.exit("void");	
	}
	
	/**
	 * Beallitja magat egy cellaba.
	 * @param cell: ebbe a cellaba allitja be magat.
	 */
	public void setCell(Cell cell) {
		Logger.enter("tower", "setCell", "cell", "");
		
		cell.setElement(this);
		
		Logger.exit("false");
	}
	
	/**
	 * Beallitja a torony lovesi gyakorisagat.
	 * @param i: erre allitja be.
	 */
	public void setSpeed(int i) {
		Logger.enter("tower", "setSpeed", "i:int", "");
		
		Logger.exit("true");		
	}
	
	/**
	 * A hobbit ellenseg sebzeseert felelos metodus.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	@Override
	public void affect(Hobbit e) {
		Logger.enter("tower", "affect", "hobbit", "");
		
		int damageValue = 0;
		e.damage(damageValue);
		
		Logger.exit("void");
		
	}

	/**
	 * A tunde ellenseg sebzeseert felelos metodus.
	 * A szkeletonba nem szukseges megvalositani.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	@Override
	public void affect(Elf e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * A torp ellenseg sebzeseert felelos metodus.
	 * A szkeletonba nem szukseges megvalositani.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	@Override
	public void affect(Dwarf d) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Az ember ellenseg sebzeseert felelos metodus.
	 * A szkeletonba nem szukseges megvalositani.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	@Override
	public void affect(Human h) {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * Loggolashoz, skeleton utan torlendo!
	 * @return
	 */
	public String loggerGetName() {
		return "Tower";
	}
}
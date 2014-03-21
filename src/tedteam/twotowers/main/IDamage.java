

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:14:23
 */
public interface IDamage {

	/**
	 * 
	 * @param e
	 */
	public affect(Hobbit e);

	/**
	 * 
	 * @param e
	 */
	public affect(Elf e);

	/**
	 * 
	 * @param d
	 */
	public affect(Dwarf d);

	/**
	 * 
	 * @param h
	 */
	public affect(Human h);

}
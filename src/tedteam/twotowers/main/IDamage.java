package tedteam.twotowers.main;

public interface IDamage {

	/**
	 * 
	 * @param e
	 */
	public void affect(Hobbit e);

	/**
	 * 
	 * @param e
	 */
	public void affect(Elf e);

	/**
	 * 
	 * @param d
	 */
	public void affect(Dwarf d);

	/**
	 * 
	 * @param h
	 */
	public void affect(Human h);

}
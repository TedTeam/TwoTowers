package tedteam.twotowers.main;
/**
 * Ez az interface felelos azert, hogy a kulonbozo tipusu
 * ellensegeket kulonbozo erosseggel lehessen sebezni.
 */
public interface IDamage {

	/**
	 * A hobbit ellenseg sebzeseert felelos metodus.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	public void affect(Hobbit e);

	/**
	 * A tunde ellenseg sebzeseert felelos metodus.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	public void affect(Elf e);

	/**
	 * A torp ellenseg sebzeseert felelos metodus.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	public void affect(Dwarf d);

	/**
	 * Az ember ellenseg sebzeseert felelos metodus.
	 * @param e: az ellenseg melyet sebezni kell.
	 */
	public void affect(Human h);

}
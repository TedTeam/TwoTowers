package tedteam.twotowers.main;
/**
 * A kek varazskovet megvalosito osztaly.
 * Ososztaly: MagicStone
 */
public class BlueStone extends MagicStone {

	/**
	 * Ez a metodus valtoztatja meg az akadaly hatotavolsaganak nagysagat.
	 * Mivel ilyen attributuma nincs az akadalynak, ezert ez a metodus nem csinal semmit.
	 * @param b: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra (false).
	 */
	public boolean effect(Blocker b){
		return true;
	}

	/**
	 * Ez a metodus valtoztatja meg a torony hatotavolsaganak nagysagat.
	 * @param t: a torony, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet a toronyra.
	 */
	public boolean effect(Tower t){
		return false;
	}

}
package tedteam.twotowers.main;

/**
 * A felhasznalo altal hasznalhato funkciokat megvalosito osztaly.
 */
public class User {
	// Aktualis varazsero nagysaga.
	private int actualMana = 500;
	// Maximalis varazsero nagysaga.
	private int maximumMana = 1000;
	// Referencia egy Generator objektumra.
	private Generator generator;

	/**
	 * A generator referenciat beallito metodus.
	 * @param g: amit be kell allitani a generatornak
	 */
	public void setGenerator(Generator g) {
		generator = g;
	}
	
	/**
	 * Az akadalyt letrehozo metodus. Meghivja a generator createBlocker
	 * metodusat, ha van eleg mana a felhasznalonal. Levonjuk a
	 * "koltsegeket", ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni az akadalyt
	 * @return az akadaly lerakasanak sikeressege
	 */
	public boolean createBlocker(Cell cell){
		if(actualMana >= 150) {
			boolean created = generator.createBlocker(cell);
			if(created) {
				actualMana -= 150;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A tornyot letrehozo metodus. Meghivja a generator createTower
	 * metodusat, ha van eleg mana a felhasznalonal. Levonjuk a
	 * "koltsegeket", ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a tornyot
	 * @return a torony lerakasanak sikeressege
	 */
	public boolean createTower(Cell cell){
		if(actualMana >= 200) {
			boolean created = generator.createTower(cell);
			if(created) {
				actualMana -= 200;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A fekete varazskovet letrehozo metodus. Letrehozzuk a BlackStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createBlackStone(Cell cell){
		if(actualMana >= 100) {
			BlackStone bs = new BlackStone();
			boolean added = generator.addStone(bs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A kek varazskovet letrehozo metodus. Letrehozzuk a BlueStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createBlueStone(Cell cell){
		if(actualMana >= 100) {
			BlueStone bs = new BlueStone();
			boolean added = generator.addStone(bs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A zold varazskovet letrehozo metodus. Letrehozzuk a GreenStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createGreenStone(Cell cell){
		if(actualMana >= 100) {
			GreenStone gs = new GreenStone();
			boolean added = generator.addStone(gs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A torpere hato piros varazskovet letrehozo metodus. Letrehozzuk a RedStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createDwarfRedStone(Cell cell){
		if(actualMana >= 100) {
			RedStone rs = new RedStone(30, 0, 0, 0);
			boolean added = generator.addStone(rs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A tundere hato piros varazskovet letrehozo metodus. Letrehozzuk a RedStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createElfRedStone(Cell cell){
		if(actualMana >= 100) {
			RedStone rs = new RedStone(0, 30, 0, 0);
			boolean added = generator.addStone(rs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A hobbitre hato piros varazskovet letrehozo metodus. Letrehozzuk a RedStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createHobbitRedStone(Cell cell){
		if(actualMana >= 100) {
			RedStone rs = new RedStone(0, 0, 30, 0);
			boolean added = generator.addStone(rs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Az emberre hato piros varazskovet letrehozo metodus. Letrehozzuk a RedStone
	 * objektumot, ha van eleg mana a felhasznalonal. Majd ezt a
	 * generator addStone metodusanak adjuk. Levonjuk a "koltsegeket",
	 * ha sikeres volt a letrehozas.
	 * @param cell: erre a cella objektumra akarjuk rakni a varazskovet
	 * @return a varazsko lerakasanak sikeressege
	 */
	public boolean createHumanRedStone(Cell cell){
		if(actualMana >= 100) {
			RedStone rs = new RedStone(0, 0, 0, 30);
			boolean added = generator.addStone(rs, cell);
			if(added) {
				actualMana -= 100;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Visszadaja az actualMana erteket.
	 * @return az actualMana erteke
	 */
	public int getMana() {
		return actualMana;
	}
	
	/**
	 * Noveli az actualMana erteket.
	 * @param increase: ennyivel noveli.
	 */
	public void increaseMana(int increase) {
		actualMana += increase;
		if(actualMana > maximumMana) {
			actualMana = maximumMana;
		}
	}

	public int getMaxMana() {
		return maximumMana;
	}
}

package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A palyan levo epitmenyeket tarolo osztaly.
 */
public class ElementList {
	// A palyan levo epitmenyek tombje.
	private Element elements[] = new Element[10];

	/**
	 * Hozzaad egy epitmenyt az elements tombhoz.
	 * @param element: a hozzaadando epitmeny.
	 */
	public void addElement(Element element) {
		if (element.loggerGetName().equals("Tower"))
			Logger.enter("elementList", "addElement", "tower", "");
		if (element.loggerGetName().equals("Blocker"))
			Logger.enter("elementList", "addElement", "blocker", "");
		
		elements[0] = element;
		
		Logger.exit("void");
	}

	/**
	 * Torol egy epitmenyt az elements tombbol.
	 * @param e: ezt torli a tombbol.
	 */
	public void deleteElement(Element e) {
	}

	/**
	 * Meghivja az osszes tartalmazott epitmeny action metodusat.
	 */
	public void notifyAllElement() {
		Logger.enter("elementList", "notifyAllElement", "", "");
		
		elements[0].action();
		Logger.exit("void");
	}

}
package tedteam.twotowers.main;

import java.util.ArrayList;

/**
 * A palyan levo epitmenyeket tarolo osztaly.
 */
public class ElementList {
	// A palyan levo epitmenyek tombje.
	private ArrayList<Element> elements = new ArrayList<Element>();

	/**
	 * Hozzaad egy epitmenyt az elements tombhoz.
	 * @param element: a hozzaadando epitmeny.
	 */
	public void addElement(Element element) {
		elements.add(element);
	}

	/**
	 * Torol egy epitmenyt az elements tombbol.
	 * @param element: ezt torli a tombbol.
	 */
	public void deleteElement(Element element) {
		elements.remove(element);
	}

	/**
	 * Meghivja az osszes tartalmazott epitmeny action metodusat.
	 */
	public void notifyAllElement() {
		for(Element e : elements) {
			e.action();
		}
	}

	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * Visszadja a name nevű elemet.
	 * @param name
	 * @return
	 */
	public Element getElementByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
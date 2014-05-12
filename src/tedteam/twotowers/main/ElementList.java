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
	 * Vegigmegy az osszes epitmenyen, es hasznalja a visitor mintat.
	 * @param visitor
	 */
	public void visitElements(ElementVisitor visitor) {
		for(Element e:elements){
			e.visitElement(visitor);
		}
	}

}
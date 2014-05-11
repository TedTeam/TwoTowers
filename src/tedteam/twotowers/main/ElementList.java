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
	 * Parancsfeldolgozo - temporalis fuggveny
	 * Visszadja a name nevu elemet.
	 * @param name: az ilyen nevu elementet keressuk
	 * @return a megtalalt element (ha van)
	 */
	public Element getElementByName(String name) {
		int index = -1;
		for(Element e : elements) {
			if(e.getName().equals(name))
				index = elements.indexOf(e);
		}
		if(index == -1)
			return null;
		return elements.get(index);
	}

	public void visitElements(ElementVisitor visitor) {
		// TODO Auto-generated method stub
		for(Element e:elements){
			e.visitElement(visitor);
		}
	}

}
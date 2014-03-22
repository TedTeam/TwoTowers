package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class ElementList {

	private Element elements[] = new Element[10];

	/**
	 * 
	 * @param e
	 */
	public void addElement(Element element) {
		if (element.loggerGetName().equals("Tower"))
			Logger.enter("cell", "setElement", "tower", "");
		if (element.loggerGetName().equals("Blocker"))
			Logger.enter("cell", "setElement", "blocker", "");
		
		elements[0] = element;
		
		Logger.exit("void");
	}

	/**
	 * 
	 * @param e
	 */
	public void deleteElement(Element e) {
	}

	public void notifyAllElement() {
		Logger.enter("elementList", "notifyAllElement", "", "");
		
		elements[0].action();
	}

}
package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class ElementList {

	private Element elements[];
	public Element m_Element;

	public ElementList() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param e
	 */
	public void addElement(Element element) {
		if (element.loggerGetName().equals("Tower"))
			Logger.enter("cell", "setElement", "tower", "");
		if (element.loggerGetName().equals("Blocker"))
			Logger.enter("cell", "setElement", "blocker", "");

		Logger.exit("void");
	}

	/**
	 * 
	 * @param e
	 */
	public void deleteElement(Element e) {

	}

	public void notifyAllElement() {

	}

}
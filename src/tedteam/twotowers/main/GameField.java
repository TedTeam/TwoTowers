package tedteam.twotowers.main;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 * A jatekteret megvalosito osztaly.
 */
public class GameField {
	// A palyat alkoto cellak.
	private Map<Point,Cell> cells = new HashMap<Point,Cell>();
	
	//ideiglenes tarolo a prototipushoz,utana toroljuk
	//private List<Cell> cells = new ArrayList<Cell>();
	
	//A kezdo cellat eltarolo valtozo. Innet indulnak majd ki az ellensegek.
	private Cell startCell;
	
	//Az utolso cellat eltarolo valtozo. Ezt a cellat akarjak az ellensegek elerni.
	private Cell finalCell;
	
	/**
	 * Lekeri a palya utolso cellajat.
	 * @return az utolso cella.
	 */
	public Cell getFinalCell(){
		return finalCell;
	}
	
	/**
	 * A parameterkent kapott Cell objektumot 
	 * eltarolja a finalCell valtozoba.
	 * @param cell: tarolando Cella
	 */
	public void setFinalCell(Cell cell){
		finalCell = cell;
	}
	
	/**
	 * A parameterkent kapott Cell objektumot eltarolja a startCell valtozoba.
	 * @param cell: tarolando Cella
	 */
	public void setStartCell(Cell cell){
		startCell = cell;
	}
	
	/**
	 * Lekeri a palya kezdo cellajat.
	 * @return a kezdo cella.
	 */
	public Cell getStartCell(){
		return startCell;
	}

	/**
	 * Az inicializalo fuggveny. Feladata a cellak letrehozasa,
	 * es azok szomszedossaganak beallitasa.
	 */
	public void init(){ 
		
		
		try {
			File xmlFile = new File("map.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("Cell");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
			
					Integer x;
					x =Integer.parseInt(eElement.getElementsByTagName("x").item(0).getTextContent());
					Integer y;
					y =Integer.parseInt(eElement.getElementsByTagName("y").item(0).getTextContent());
					boolean road;
					road = Boolean.parseBoolean(eElement.getElementsByTagName("road").item(0).getTextContent());
					boolean isFinalCell;
					isFinalCell = Boolean.parseBoolean(eElement.getElementsByTagName("road").item(0).getTextContent());
					boolean isStartCell;
					isStartCell = Boolean.parseBoolean(eElement.getElementsByTagName("road").item(0).getTextContent());
					Cell c = new Cell();
					if(road) c.setRoad();
					cells.put(new Point(x,y), c);
					if(isFinalCell)finalCell = c;
					if(isStartCell)startCell = c;
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	/**
	 * A parameterkent kapott Cell objektumot eltarolja a cells 
	 * kollekcioba a Point tipuskent kapott kulccsal.
	 * @param c: kapott Cell objektum
	 * @param point: kulcs koordinatak
	 * @return
	 */
	public void addCell(Cell c, Point point) {
		// TODO Auto-generated method stub
		
	}

}
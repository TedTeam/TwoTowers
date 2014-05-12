package tedteam.twotowers.main;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
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
					isFinalCell = Boolean.parseBoolean(eElement.getElementsByTagName("final").item(0).getTextContent());
					boolean isStartCell;
					isStartCell = Boolean.parseBoolean(eElement.getElementsByTagName("start").item(0).getTextContent());
					Cell c = new Cell();
					if(road)c.setRoad();
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
		
		//szomszedok osszekapcsolasa
		for(int y=1;y<19;y++)
			for(int x=1;x<23;x++){
				Map<String,Cell> neighbors = new HashMap<String, Cell>();
				if(cells.containsKey(new Point(x,y))){
						neighbors.put("up",cells.get(new Point(x,y-1)));
						neighbors.put("down",cells.get(new Point(x,y+1)));
						neighbors.put("left",cells.get(new Point(x-1,y)));
						neighbors.put("right",cells.get(new Point(x+1,y)));
						cells.get(new Point(x,y)).setNeighbors(neighbors);	
				}
			}
		/*System.out.println(cells.get(new Point(6,16)));
		System.out.println(cells.get(new Point(1,1)).getNeighbors().get("up"));*/
	}

	/**
	 * Visszater a parameterben kapott koordinatan talalhato cellaval.
	 * @param point: a koordinata.
	 * @return a keresett cella.
	 */
	public Cell getCell(Point point) {
		return cells.get(point);
	}

	/**
	 * Visszater a parameterben kapott cella koordinataival.
	 * @param cell: a cella.
	 * @return a keresett koordinatak.
	 */
	public Point getPoint(Cell cell) {
		for (java.util.Map.Entry<Point, Cell> entry : cells.entrySet()) {
            if (entry.getValue().equals(cell)) {
            	return entry.getKey();
                //System.out.println(entry.getKey());
            }
           
		}
		 return null;
	}

	/**
	 * Visszater az utakat tartalmazo cellakkal.
	 * @return az utakat tartalmazo cellak.
	 */
	public ArrayList<Cell> getRoads() {
		ArrayList<Cell> roads = new ArrayList<Cell>();
		for (java.util.Map.Entry<Point, Cell> entry : cells.entrySet()) {
            if (entry.getValue().hasRoad()) {
            	roads.add(entry.getValue());
            }
        }
		return roads;
		
	}

}
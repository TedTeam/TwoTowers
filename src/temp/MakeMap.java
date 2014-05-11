package temp;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 


import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MakeMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Field");
			doc.appendChild(rootElement);
			
			//j :oszlop, i :sor
			for(int j=1;j<19;j++){
				for(int i=1;i<23;i++){
				Element cell = doc.createElement("Cell");
				rootElement.appendChild(cell);
				Integer xc= i;
				Integer yc = j;
				Element x = doc.createElement("x");
				x.appendChild(doc.createTextNode(xc.toString()));
				cell.appendChild(x);
				
				Element y = doc.createElement("y");
				y.appendChild(doc.createTextNode(yc.toString()));
				cell.appendChild(y);
				
				Boolean roadBol = false;
				if(i == 1 && j<11)roadBol = true;
				if(j == 1 && i>0 && i<23)roadBol = true;
				if(j == 4)roadBol = true;
				if(j == 2 && i == 22)roadBol = true;
				if(j == 3 && i == 22)roadBol = true;
				if(j == 10 && i < 7)roadBol = true;
				if(i == 6 && j>9 && j<18)roadBol = true;
				if(j==13 && i>5 && i<14)roadBol = true;
				if(j == 16 && i>5)roadBol = true;
				if(i == 22 && j>3)roadBol = true;
				if(i==7 && j>3 && j<9)roadBol = true;
				if(j==8 && i>6 && i <14)roadBol = true;
				if(i==13 && j>7 && j<14)roadBol = true;
				if(j==12 && i>12 && i<21)roadBol = true;
				if(i==20 && j>11 && j<15)roadBol = true;
				if(i==21 && j==14)roadBol = true;
				if(j == 18 && i>5 && i<22)roadBol = true;
				
				Element road = doc.createElement("road");
				road.appendChild(doc.createTextNode(roadBol.toString()));
				cell.appendChild(road);
				
				Boolean finalCellBol = false;
				if(j == 18 && i == 22)finalCellBol = true;
				Element finalCell = doc.createElement("final");
				finalCell.appendChild(doc.createTextNode(finalCellBol.toString()));
				cell.appendChild(finalCell);
				
				Boolean startCell = false;
				if(i == 1 && j == 1) startCell = true;
				Element start = doc.createElement("start");
				start.appendChild(doc.createTextNode(startCell.toString()));
				cell.appendChild(start);
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("map.xml"));
			transformer.transform(source, result);

			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

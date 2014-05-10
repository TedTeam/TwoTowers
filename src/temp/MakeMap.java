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
				
				Element road = doc.createElement("road");
				road.appendChild(doc.createTextNode("false"));
				cell.appendChild(road);
				
				Element finalCell = doc.createElement("final");
				finalCell.appendChild(doc.createTextNode("false"));
				cell.appendChild(finalCell);
				
				Element start = doc.createElement("start");
				start.appendChild(doc.createTextNode("false"));
				cell.appendChild(start);
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\file2.xml"));
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

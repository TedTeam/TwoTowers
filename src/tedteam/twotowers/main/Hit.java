package tedteam.twotowers.main;

import java.awt.Point;
import java.util.ArrayList;

public class Hit {
	private ArrayList<Point> from; 
	private ArrayList<Point> to;
	private Converter converter;
	

	public Hit(){
		from = new ArrayList<Point>();
		to = new ArrayList<Point>();
	}	
	public void addHit(Cell f, Cell t) {
		
		from.add(converter.getCoords(f));
		to.add(converter.getCoords(t));
	}
	
	public ArrayList<Point> getFrom() {
		return from;
	}
	
	public void setConverter(Converter converter) {
		this.converter = converter;
	}

	public ArrayList<Point> getTo() {
		return to;
	}
	
	public void clearAll(){
		from.clear();
		to.clear();
		
	}
	
}

package tedteam.twotowers.main;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Egy torony loveseit megvalosito osztaly. A lovesek kirajzolashoz szukseges.
 */
public class Hit {
	// Honnan jonnek a lovesek.
	private ArrayList<Point> from;
	// Hova mennek a lovesek.
	private ArrayList<Point> to;
	// Referencia a Converter objektumra.
	private Converter converter;
	
	/**
	 * Konstruktor. Letrehozza a ket ures lancolt listat.
	 */
	public Hit(){
		from = new ArrayList<Point>();
		to = new ArrayList<Point>();
	}	
	
	/**
	 * Uj loves hozzaadasa.
	 * @param f: honnan
	 * @param t: hova
	 */
	public void addHit(Cell f, Cell t) {
		from.add(converter.getCoords(f));
		to.add(converter.getCoords(t));
	}
	
	/**
	 * A lovesek forrasainak lekerdezeese.
	 * @return
	 */
	public ArrayList<Point> getFrom() {
		return from;
	}
	
	/**
	 * A converter attributum beallitasa.
	 * @param converter: erre.
	 */
	public void setConverter(Converter converter) {
		this.converter = converter;
	}

	/**
	 * A lovesek celjainak lekerdezese.
	 * @return
	 */
	public ArrayList<Point> getTo() {
		return to;
	}
	
	/**
	 * Torli az eddigi loveseket.
	 */
	public void clearAll(){
		from.clear();
		to.clear();
	}
	
}

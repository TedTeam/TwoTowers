package tedteam.twotowers.main;

import java.awt.Point;

public class Hit {
	private Point from; 
	private Point to;
	private int live = 30;
	
	public Hit() {
		//singleton
	}
	
	public void setHit(Point f, Point t) {
		from = f;
		to = t;
	}
	
	public Point getFrom() {
		return from;
	}
	
	public Point getTo() {
		return to;
	}
	
}

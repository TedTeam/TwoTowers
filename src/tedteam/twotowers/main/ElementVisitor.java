package tedteam.twotowers.main;

/**
 * Az epitmenyekhez tartozo visitor.
 */
public interface ElementVisitor {

	public void affect(Tower tower);
	
	public void affect(Blocker blocker);
	
}

package tedteam.twotowers.main;

public interface ElementVisitor {

	public void affect(Tower tower);
	
	public void affect(Blocker blocker);
	
}

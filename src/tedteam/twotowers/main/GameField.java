package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class GameField {

	private Cell cells[] = new Cell[4];

	public GameField(){

	}

	public Cell getFinalCell(){
		Logger.enter("gfield", "getFinalCell", "", "");
		
		Logger.exit("cell4");
		return cells[3];
	}

	public Cell getStartCell(){
		return null;
	}

	public void init(){ 
		Logger.enter("gfield", "init", "", "");
		
		cells[0] = new Cell();
		cells[1] = new Cell();
		cells[2] = new Cell();
		cells[3] = new Cell();
		cells[0].setNeighbors(cells);
		cells[1].setNeighbors(cells);
		cells[2].setNeighbors(cells);
		cells[3].setNeighbors(cells);
		
		Logger.exit("void");
		
	}

}
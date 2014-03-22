package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class GameField {

	private Cell cells[] = new Cell[4];

	public Cell getFinalCell(){
		Logger.enter("gameField", "getFinalCell", "", "");
		
		Logger.exit("cell4");
		return cells[3];
	}

	public Cell getStartCell(){
		Logger.enter("gameField", "getStartCell", "", "");
		
		cells[1] = new Cell();
		
		Logger.exit("cell");
		return cells[1];
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
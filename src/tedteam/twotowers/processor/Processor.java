package tedteam.twotowers.processor;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import tedteam.twotowers.main.BlackStone;
import tedteam.twotowers.main.Blocker;
import tedteam.twotowers.main.BlueStone;
import tedteam.twotowers.main.Cell;
import tedteam.twotowers.main.Dwarf;
import tedteam.twotowers.main.Elf;
import tedteam.twotowers.main.Enemy;
import tedteam.twotowers.main.Generator;
import tedteam.twotowers.main.GreenStone;
import tedteam.twotowers.main.Hobbit;
import tedteam.twotowers.main.Human;
import tedteam.twotowers.main.RedStone;
import tedteam.twotowers.main.Tower;

public class Processor {

	// parancssorhoz sz�ks�ges valtozok, kollekciok
	Generator g = new Generator();

	// Map-be taroljuk a create-lt elemeket, ahol:
	// kulcs: az atadott nev
	// ertek: a tipus (Type)
	HashMap<String, Type> createdElements = new HashMap<String, Type>();

	// Create-tel ezeket lehet letrehozni
	public enum Type {
		Tower, Blocker, Cell, Elf, Dwarf, Human, Hobbit, RedStone, BlackStone, GreenStone, BlueStone
	};

	// az �sszes kimeneti sort tartalmazza, melyet fajlba irhatunk
	private ArrayList<String> outputAll = new ArrayList<String>();

	/**
	 * Fo loop, ezt hivjuk fel a mainbol, addig megy, mig quit parancsot nem kap
	 * az inputCommand()
	 */
	public void inputProcessLoop() {
		System.out.println("Ez a Two Towers jatek konzol felulete."
				+ " Kerlek ird be a parancsokat. Segitseg: help");
		// Parancsok bevitele
		while (inputCommand()) {
		}
	}

	/**
	 * A parancs beolvasasa billentyuzetrol.
	 * 
	 * @return true, ha tovabbi parancsok varhatoak, false, ha nincs tobb
	 *         parancs
	 */
	public boolean inputCommand() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command;
		try {
			command = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return processCommand(command);
	}

	/**
	 * A billentyuzetrol megadott sztring parancsok szerinti szetbontasa Minden
	 * parancsot kiirunk a kepernyore, es elmentjuk az outputAll kollecioba.
	 * 
	 * @param command
	 *            : bekert sztring
	 * @return igaz, ha fut tovabb, false, ha nincs tobb parancs
	 */
	public boolean processCommand(String command) {
		String[] parts = command.split(" ");
		String actual = new String();
		if (parts[0].equals("create")) {
			actual = commandCreate(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("put")) {
			actual = commandPut(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("setRoad")) {
			actual = commandSetRoad(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("setNeighbor")) {
			actual = commandSetNeighbor(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("print")) {
			actual = commandPrint(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("shoot")) {
			actual = commandShoot(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("step")) {
			actual = commandStep(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("block")) {
			actual = commandBlock(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("checkGame")) {
			actual = commandCheckGame(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("gameInit")) {
			actual = commandGameInit(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("load")) {
			actual = commandLoad(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("save")) {
			actual = commandSave(parts);
			outputAll.add(actual);
			System.out.println(actual);
		} else if (parts[0].equals("writefile")) {
			actual = writeToFile(parts);
			System.out.println(actual);
		} else if (parts[0].equals("readfile")) {
			actual = readFromFile(parts);
			System.out.println(actual);
		} else if (parts[0].equals("help")) {
			System.out.println(commandHelp(parts));
		} else if (parts[0].equals("compare")) {
			System.out.println(compare(parts));
		} else if (parts[0].equals("quit")) {
			return false;
		} else { // Nincs ilyen parancs
			System.out.println("Nem letezik ilyen parancs!");
		}

		return true;
	}

	/**
	 * Kilistazza a parancsokat parameterekkel.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandHelp(String[] parts) {
		if (parts.length != 1)
			return "error";
		System.out.println("create [element] [element-name]");
		System.out.println("put [element-name] [where]");
		System.out.println("setRoad [cell-name]");
		System.out
				.println("setNeighbor [target-cell] [neighbor-cell] [direction]");
		System.out.println("print [element-name]");
		System.out.println("shoot [tower-name] [/fog]");
		System.out.println("step [enemy-name] [/direction]");
		System.out.println("block [block-name]");
		System.out.println("checkGame");
		System.out.println("gameInit [startCell] [finalCell]");
		System.out.println("load");
		System.out.println("save");
		System.out.println("writefile [file-name]");
		System.out.println("readfile [file-name]");
		System.out.println("quit");

		return "";
	}

	
	private String compare(String[] parts) {
		if (parts.length != 3)
			return "error";
		TestCompare compare = new TestCompare();
		return compare.inputFile(parts[1], parts[2]);
	}
	/**
	 * Kiirja fajlba a kapott kimeneteket. A kiiras utan a stack torlodik.
	 * 
	 * @param parts
	 * @return
	 */
	private String writeToFile(String[] parts) {
		if (parts.length != 2)
			return "error";
		try {
			PrintWriter writer = new PrintWriter(parts[1], "UTF-8");
			for (int i = 0; i < outputAll.size(); ++i)
				writer.println(outputAll.get(i));
			writer.close();
			outputAll.clear(); // toroljuk a kiirt kimeneteket a stackbol
			return "File writing success";
		} catch (IOException e) {
			return "File reading success";
		}

	}

	/**
	 * Beolvassa egy text fileb�l a parancsokat, es egy ciklusban meghivja az
	 * processCommandot az osszes parancsra
	 * 
	 * @param destination
	 * @return
	 */
	private String readFromFile(String[] parts) {
		if (parts.length != 2)
			return "error";
		try {
			BufferedReader br = new BufferedReader(new FileReader(parts[1]));
			String line = br.readLine();
			outputAll.clear(); // torli a korabban beleirt elemeket
			while (line != null) {
				outputAll.add(line);
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			return "File reading unsuccess";
		}
		return "File reading success";
	}

	/**
	 * Jatekallas lementese
	 * 
	 * @param parts
	 * @return
	 */
	private String commandSave(String[] parts) {
		// TODO
		return null;
	}

	/**
	 * J�t�k�ll�s betoltese
	 * 
	 * @param parts
	 * @return
	 */
	private String commandLoad(String[] parts) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Jatek kezdocellajanak (ahonnan az ellenseges egysegek indulnak) es
	 * vegcellajanak (ahova ha odaer az ellenseg, a felhasznalo veszit)
	 * beallitasa.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandGameInit(String[] parts) {
		if (parts.length != 3)
			return "error";
		String startCell = parts[1];
		String finalCell = parts[2];
		Type type = createdElements.get(startCell);
		if (type == null || type != Type.Cell)
			return "invalid " + startCell;
		if (type == null || type != Type.Cell)
			return "invalid " + finalCell;
		Cell startC = g.getGameField().getCellByName(startCell);
		Cell finalC = g.getGameField().getCellByName(finalCell);
		g.getGameState().setStartCell(startC);
		g.getGameState().setFinalCell(finalC);
		return "initialized";
	}

	/**
	 * Jatek aktualis allapotat vizsgalja meg, vagyis hogy meghalt-e minden
	 * ellenseg, illetve elert-e az ellenseg a vegzet hegyeig (ezaltal legyozve
	 * a jatekost).
	 * 
	 * @param parts
	 * @return
	 */
	private String commandCheckGame(String[] parts) {
		if (parts.length != 1)
			return "error";
		// itt a win-lose m�g nem tiszta
		if (g.getGameState().checkGame()) {
			return "win";
		} else
			return "not finish";
	}

	/**
	 * Utasitas a parameterben megadott blocker elemnek a blokkolasra.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandBlock(String[] parts) {
		if (parts.length != 2)
			return "error";
		String name = parts[1];
		Type type = createdElements.get(name);
		if (type == null || type != Type.Blocker)
			return "invalid " + name;
		Blocker b = (Blocker) g.getGameState().getElementList().getElementByName(name);
		b.action();
		if (b.getBlockedEnemies() == "") {
			return "no block";
		} else
			return "block " + b.getBlockedEnemies();

	}

	/**
	 * Parameterben megadott ellenseg leptetese. Elagazas eseten opcionalis
	 * irany parameter is megadhato, hogy az ellenseg arra lepjen tovabb.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandStep(String[] parts) {
		if (parts.length < 2)
			return "error";
		String name = parts[1];
		Type type = createdElements.get(name);
		if (type == null || (type != Type.Elf && type != Type.Dwarf
				&& type != Type.Human && type != Type.Hobbit))
			return "invalid " + name;
		Enemy actual = g.getGameState().getEnemyList().getEnemyByName(name);
		if(parts.length == 3){
			String direction = parts[2];
			if (direction.equals("left") || direction.equals("right") || direction.equals("up")
					|| direction.equals("down"))
				actual.setDirection(direction);
			else 
				return "invalid " + direction;
		}
		
		try{
		actual.step();
		return name + " step";
		}
		catch(Exception e){
			return "error";
			
		}
	}

	/**
	 * A parameterben megadott torony szamara parancs lovesre. Opcionalisan
	 * megadhato, hogy a torony kodben van-e eppen, illetve hogy az adott loves
	 * kette vagja-e az ellenfelet.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandShoot(String[] parts) {
		if (parts.length > 3 && parts.length < 2)
			return "error";
		String name = parts[1];
		Type type = createdElements.get(name);
		if (type == null || type != Type.Tower)
			return "invalid " + name;
		boolean fog = false;
		// opcionalis parameter van-e, illetve az /fog alakban van-e, ha igen,
		// akkor megjegyezzuk
		if (parts[2] != null) {
			if (parts[2] == "/fog")
				fog = true;
			else
				return "error";
		}
		Tower t = (Tower) g.getGameState().getElementList()
				.getElementByName(name);
		if (fog)
			t.fog(); // beallitja a kodot
		t.action();
		if (t.getLastShotEnemyName() == "") {
			return "no damage";
		} else
			return "damage " + t.getLastShotEnemyName();

	}

	/**
	 * Kiirja a kepernyore az adott elementrol minden lenyeges informaciot (pl.
	 * allapotat, elhelyezkedeset, eleterejet � ha van neki)
	 * 
	 * @param parts
	 * @return
	 */
	private String commandPrint(String[] parts) {
		if (parts.length != 2)
			return "error";
		String name = parts[1];
		Type type = createdElements.get(name);
		if (type == null)
			return "invalid " + name;
		if (type == Type.Elf || type == Type.Dwarf || type == Type.Human
				|| type == Type.Hobbit) {
			Enemy actual = g.getGameState().getEnemyList().getEnemyByName(name);
			if (actual != null) {
				return "lifepoint "
						+ String.valueOf(actual.getCurrentLifePoint())
						+ ", cell " + actual.getCell().getCellName()
						+ ", formercell "
						+ actual.getFormerCell().getCellName();
			} else
				return "error";
		}
		if (type == Type.Tower) {
			Tower actual = (Tower) g.getGameState().getElementList()
					.getElementByName(name);
			StringBuilder string = new StringBuilder();
			string.append("range " + String.valueOf(actual.getRange())
					+ ", dwarfdamage "
					+ String.valueOf(actual.getDwarfDamage()) + " "
					+ String.valueOf(actual.getElfDamage()) + ", "
					+ String.valueOf(actual.getHobbitDamage()) + ", "
					+ String.valueOf(actual.getHumanDamage()) + ", cell "
					+ actual.getCell().getCellName() + ", stones");
			if (actual.getEnhancedByBlue())
				string.append(" blue");
			if (actual.getEnhancedByGreen())
				string.append(" green");
			if (actual.getEnhancedByRed())
				string.append(" red");
			return string.toString();
		}
		if (type == Type.Blocker) {
			Blocker actual = (Blocker) g.getGameState().getElementList()
					.getElementByName(name);
			if (actual != null) {
				return "slowing " + String.valueOf(actual.getSlowing())
						+ ", remain " + String.valueOf(actual.getCountRemain())
						+ ", cell " + actual.getCell().getCellName();
			} else
				return "error";
		}
		if (type == Type.Cell) {
			Cell cell = g.getGameField().getCellByName(name);
			if (cell != null) {
				StringBuilder neighborsString = new StringBuilder();
				// a szomszedok vizsgalasa es stringge alakitasa
				HashMap<String, Cell> neighbors = cell.getNeighbors();
				Cell c = neighbors.get("left");
				if (c != null)
					neighborsString.append(c.getCellName() + " "+"left");
				c = neighbors.get("right");
				if (c != null)
					neighborsString.append(c.getCellName() + " "+"right");
				c = neighbors.get("up");
				if (c != null)
					neighborsString.append(c.getCellName() + " "+"up");
				c = neighbors.get("down");
				if (c != null)
					neighborsString.append(c.getCellName() + " "+"down");
				
				StringBuilder elementString = new StringBuilder();
				if(cell.getElement() == null)
					elementString.append("null");
				else elementString.append(cell.getElement().getName());
				StringBuilder enemyString = new StringBuilder();
				ArrayList<Enemy> enemies = cell.getEnemy();
				if(enemies.isEmpty()) 
					enemyString.append(" null");
				for(Enemy e:enemies){
					if(e != null)
						enemyString.append(" "+e.getName());
				}
				return "road " + cell.hasRoad() + ", neighbors "
						+ neighborsString.toString() + ", element "
						+ elementString.toString() + ", enemies" + enemyString.toString();
			}
		}
		
		if (type == Type.RedStone) {
			return "color red, change 30, used true";
		}
		if (type == Type.GreenStone) {
			return "color green, change 4, used true";
		}
		if (type == Type.BlueStone) {
			return "color blue, change 2, used true";
		}
		if (type == Type.BlackStone) {
			return "color black, change 2, used true";
		}
		return "error";
	}

	/**
	 * Beallitja az elso parameterben megadott cella szomszedjanak a masodik
	 * parameterben megadott cellat, a megadott iranyba.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandSetNeighbor(String[] parts) {
		if (parts.length != 4)
			return "error";
		String targetCell = parts[1];
		String neighborCell = parts[2];
		String direction = parts[3];
		Cell target = g.getGameField().getCellByName(targetCell);
		if (target == null)
			return "invalid " + targetCell;
		Cell neighbor = g.getGameField().getCellByName(neighborCell);
		if (neighbor == null) 
			return "invalid " + neighborCell;
		if (direction == null)
			return "invalid " + direction;
		if(direction.equals("left") || direction.equals("right") || direction.equals("up") || direction.equals("down")){
			HashMap<String, Cell> neighbors = target.getNeighbors();
			neighbors.put(direction, neighbor);
			return neighborCell + " set " + targetCell + " " + direction
					+ " neighbor";
		}
		else 
			return "invalid " + direction;
	}

	/**
	 * A parameterben megadott cella ut lesz.
	 * 
	 * @param parts
	 * @return
	 */
	private String commandSetRoad(String[] parts) {
		if (parts.length != 2)
			return "error";
		String cellName = parts[1];
		Cell cell = g.getGameField().getCellByName(cellName);
		if (cell == null)
			return "invalid " + cellName;
		if (cell.hasRoad())
			return "error: road on " + cellName;
		if (cell.hasElement())
			return "error: " + cellName + " has tower";
		cell.setRoad();
		return cellName + " set Road";
	}

	/**
	 * Command: put [element-name] [where] Leirass: Lehelyezi a parameterben
	 * megadott cellara a valasztott elemet, ha lehetseges. Opciok: element-name:
	 * az element create paranccsal tortent letrehozasakor valasztott nev, ezt
	 * akarjuk lehelyezni a palyara. (Element-name tartozhat a kovetkezokhoz:
	 * Tower, Block, Elf, Hobbit, Human, Dwarf, GreenStone, BlackStone,
	 * RedStone) where: cell, ahova le szeretnenk helyezni a valasztott
	 * elementet.
	 */
	public String commandPut(String[] parts) {
		if (parts.length != 3) {
			return "error";
		}
		String elementName = parts[1];
		String cellName = parts[2];

		Cell where = g.getGameField().getCellByName(cellName);
		if (where == null) // nem letezo cella eseten
			return "invalid " + cellName;
		Type type = createdElements.get(elementName);
		if (type == null) // nem letezo element-name eseten
			return "invalid" + elementName;
		// ha lezezik az element es a cell
		if (type == Type.Blocker) {
			if (!g.createBlocker(where,elementName))
				return "error: not road on " + where.getCellName();
		}
		if (type == Type.Tower) {
			if (!g.createTower(where,elementName)) {
				if (where.hasRoad()) // ez azer kell, mert a createTower csak
										// annyit ad vissza, hogy false
					return "error: road on " + where.getCellName();
				return "error: " + where.getCellName() + " has tower"; // ha nem az a baj,
															// hogy road, akkor
															// ez
			}
		}
		if (type == Type.Elf) {
			if (!where.hasRoad())
				return "error: not road on " + where.getCellName();
			Elf elf = new Elf();
			elf.setName(elementName);
			elf.init(g.getGameState(), where);
			g.getGameState().addEnemy(elf);
			where.addEnemy(elf);
		}
		if (type == Type.Dwarf) {
			if (!where.hasRoad())
				return "error: not road on " + where.getCellName();
			Dwarf dwarf = new Dwarf();
			dwarf.setName(elementName);
			dwarf.init(g.getGameState(), where);
			g.getGameState().addEnemy(dwarf);
			where.addEnemy(dwarf);
		}
		if (type == Type.Human) {
			if (!where.hasRoad())
				return "error: not road on " + where.getCellName();
			Human human = new Human();
			human.setName(elementName);
			human.init(g.getGameState(), where);
			g.getGameState().addEnemy(human);
			where.addEnemy(human);
		}
		if (type == Type.Hobbit) {
			if (!where.hasRoad())
				return "error: not road on " + where.getCellName();
			Hobbit hobbit = new Hobbit();
			hobbit.setName(elementName);
			hobbit.init(g.getGameState(), where);
			g.getGameState().addEnemy(hobbit);
			where.addEnemy(hobbit);
		}
		if (type == Type.RedStone) {
			if (!where.hasElement())
				return "error: not element on " + where.getCellName();
			RedStone redStone = new RedStone();
			redStone.setName(elementName);
			if(!g.addStone(redStone, where)) {
				return "error";
			}
		}
		if (type == Type.GreenStone) {
			if (!where.hasElement())
				return "error: not element on " + where.getCellName();
			GreenStone greenStone = new GreenStone();
			greenStone.setName(elementName);
			if(!g.addStone(greenStone, where)) {
				return "error";
			}
		}
		if (type == Type.BlueStone) {
			if (!where.hasElement())
				return "error: not element on " + where.getCellName();
			BlueStone blueStone = new BlueStone();
			blueStone.setName(elementName);
			if(!g.addStone(blueStone, where)) {
				return "error";
			}
		}
		if (type == Type.BlackStone) {
			if (!where.hasElement())
				return "error: not element on " + where.getCellName();
			BlackStone blackStone = new BlackStone();
			blackStone.setName(elementName);
			if(!g.addStone(blackStone, where)) {
				return "error";
			}
		}
			

		// minden sikeres
		return elementName + " put " + cellName;
	}

	/**
	 * Parancs: create A cella kivetelevel virtualisan jonnek csak letre az
	 * elemek, mivel nem tudjuk inicializalni ekkor meg oket (mert nincs
	 * cellajuk, amit csak put-nal kapnak)
	 * 
	 * @param parts
	 *            : billentyuzetrol megadott sztring
	 * @return kiiratando szoveg
	 */
	public String commandCreate(String[] parts) {
		if (parts.length < 3) {
			return "error";
		}
		String name = parts[2];

		// megnezzuk, hogy van-e mar ilyen nevu element
		if (createdElements.containsKey(name))
			return "exist " + name;

		if (parts[1].equals("Cell")) {
			// ha nem letezik, akkor elkeszitjuk
			createdElements.put(name, Type.Cell);
			Cell c = new Cell();
			c.setCellName(name);
			g.getGameField().addCell(c, new Point());
			return name + " created";
		}
		// Ha nincs, akkor letrehozhatjuk az elementet
		else if (parts[1].equals("Tower")) {
			createdElements.put(name, Type.Tower);
		} else if (parts[1].equals("Blocker")) {
			createdElements.put(name, Type.Blocker);
		} else if (parts[1].equals("Elf")) {
			createdElements.put(name, Type.Elf);
			/*Elf elf = new Elf();
			elf.setName(name);*/
			
		} else if (parts[1].equals("Hobbit")) {
			createdElements.put(name, Type.Hobbit);
		} else if (parts[1].equals("Human")) {
			createdElements.put(name, Type.Human);
		} else if (parts[1].equals("Dwarf")) {
			createdElements.put(name, Type.Dwarf);
		} else if (parts[1].equals("GreenStone")) {
			createdElements.put(name, Type.GreenStone);
		} else if (parts[1].equals("BlackStone")) {
			createdElements.put(name, Type.BlackStone);
		} else if (parts[1].equals("RedStone")) {
			createdElements.put(name, Type.RedStone);
		} else if (parts[1].equals("BlueStone")) {
			createdElements.put(name, Type.BlueStone);
		}
		// nincs ilyen nevu element
		else
			return "invalid " + parts[1];

		// ha elert ide, akkor sikerult letrehozni
		return name + " created";

	}

}

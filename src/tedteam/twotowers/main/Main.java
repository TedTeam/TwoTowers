package tedteam.twotowers.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import tedteam.twotowers.processor.Processor;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Generator generator = new Generator();
		EnemyList enemyList = new EnemyList();
		ElementList elementList = new ElementList();
		GameState gameState = new GameState();
		GameField gameField = new GameField();
		generator.setGameState(gameState);
		generator.setGameField(gameField);
		gameState.setElementList(elementList);
		gameState.setEnemyList(enemyList);
		
		View view = new View();
		view.init();
		
		//view.modifyField();
		view.field.removeAll();
		
		
		view.modifyField();
		view.field.repaint();
	}

}

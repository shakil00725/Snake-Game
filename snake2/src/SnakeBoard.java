

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class SnakeBoard extends JPanel {
	

	private static final long serialVersionUID = -1102632585936750607L;

	public static final int column = 25;
	
	public static final int row = 25;
	

	public static final int TILE_SIZE = 20;

	private static final int Large_inset = TILE_SIZE / 3;
	

	private static final int Small_inset = TILE_SIZE / 6;
	

	private static final int Length_eye = TILE_SIZE / 5;
	

	private static final Font FONT = new Font("Arial", Font.BOLD, 25);

	private SnakeMatch game;

	private TileType[] types;
		
	public SnakeBoard(SnakeMatch game) {
		this.game = game;
		this.types = new TileType[row * column];
		
		setPreferredSize(new Dimension(column * TILE_SIZE, row * TILE_SIZE));
		setBackground(Color.BLACK);
	}

	public void BoardClear() {
		for(int i = 0; i < types.length; i++) {
			types[i] = null;
		}
	}
	
	public void setTile(Point point, TileType type) {
		setTile(point.x, point.y, type);
	}
	
	public void setTile(int x, int y, TileType type) {
		types[y * row + x] = type;
	}
	
	public TileType getTile(int x, int y) {
		return types[y * row + x];
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		
		for(int x = 0; x < column; x++) {
			for(int y = 0; y < row; y++) {
				TileType type = getTile(x, y);
				if(type != null) {
					TileDraw(x * TILE_SIZE, y * TILE_SIZE, type, graphics);
				}
			}
		}
		
		graphics.setColor(Color.DARK_GRAY);
		graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		for(int x = 0; x < column; x++) {
			for(int y = 0; y < row; y++) {
				graphics.drawLine(x * TILE_SIZE, 0, x * TILE_SIZE, getHeight());
				graphics.drawLine(0, y * TILE_SIZE, getWidth(), y * TILE_SIZE);
			}
		}		
		
		if(game.GameOver() || game.NewGame() || game.Paused()) {
			graphics.setColor(Color.WHITE);
			
			int centerX = getWidth() / 2;
			int centerY = getHeight() / 2;
			
			String lMessage = null;
			String sMessage = null;
			if(game.NewGame()) {
				lMessage = "Welcome To  snake Game";
				sMessage = "Enter To Start";
			} else if(game.GameOver()) {
				lMessage = "You Lost";
				sMessage = "Enter to Restart";
			} else if(game.Paused()) {
				lMessage = "Paused";
				sMessage = "Press P to Resume";
			}
			
			graphics.setFont(FONT);
			graphics.drawString(lMessage, centerX - graphics.getFontMetrics().stringWidth(lMessage) / 2, centerY - 50);
			graphics.drawString(sMessage, centerX - graphics.getFontMetrics().stringWidth(sMessage) / 2, centerY + 50);
		}
	}
	
	private void TileDraw(int x, int y, TileType type, Graphics graphics) {
	
		switch(type) {
		

		case Points:
			graphics.setColor(Color.YELLOW);
			graphics.fillOval(x + 2, y + 2, TILE_SIZE - 4, TILE_SIZE - 4);
			break;
			

		case Bodyofthesnake:
			graphics.setColor(Color.BLUE);
			graphics.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			break;
			

		case Headofthesnake:
		
			graphics.setColor(Color.ORANGE);
			graphics.fillRect(x, y, TILE_SIZE, TILE_SIZE);
	
			graphics.setColor(Color.BLACK);
			
			switch(game.getDirection()) {
			case Up: {
				int base_y = y + Small_inset;
				graphics.drawLine(x + Large_inset, base_y, x + Large_inset, base_y + Length_eye);
				graphics.drawLine(x + TILE_SIZE - Large_inset, base_y, x + TILE_SIZE - Large_inset, base_y + Length_eye);
				break;
			}
				
			case Down: {
				int base_y = y + TILE_SIZE - Small_inset;
				graphics.drawLine(x + Large_inset, base_y, x + Large_inset, base_y - Length_eye);
				graphics.drawLine(x + TILE_SIZE - Large_inset, base_y, x + TILE_SIZE - Large_inset, base_y - Length_eye);
				break;
			}
			
			case Left: {
				int base_x = x + Small_inset;
				graphics.drawLine(base_x, y + Large_inset, base_x + Length_eye, y + Large_inset);
				graphics.drawLine(base_x, y + TILE_SIZE - Large_inset, base_x + Length_eye, y + TILE_SIZE - Large_inset);
				break;
			}
				
			case Right: {
				int base_x = x + TILE_SIZE - Small_inset;
				graphics.drawLine(base_x, y + Large_inset, base_x - Length_eye, y + Large_inset);
				graphics.drawLine(base_x, y + TILE_SIZE - Large_inset, base_x - Length_eye, y + TILE_SIZE - Large_inset);
				break;
			}
			
			}
			break;
		}
	}

}



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;


public class SideP extends JPanel {
	
	private static final Font LargeF = new Font("Arial", Font.BOLD, 30);
	
	private static final Font MediumF = new Font("Arial", Font.BOLD, 20);

	private static final Font SmallF = new Font("Arial", Font.BOLD, 12);

	private SnakeMatch game;

	private Score op;
	
	
	public SideP(SnakeMatch game) {
		this.game = game;
		
		setPreferredSize(new Dimension(200, SnakeBoard.row * SnakeBoard.TILE_SIZE));
		setBackground(Color.DARK_GRAY);
	}
	
	private static final int Stat_offset = 250;
	
	private static final int Control_offset = 320;
	
	private static final int Message_stride = 30;
	
	private static final int Small_offset = 30;
	
	private static final int LargeOff = 50;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(LargeF);
		g.drawString("Snake Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2, 70);
		
		
		g.setFont(SmallF);
		
		int drawY = Stat_offset;
		g.drawString("Total Score: " + game.gettheScore(), LargeOff, drawY += Message_stride);
	
		
		
		
	
	}

}

	


	



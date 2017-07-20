

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class SnakeMatch extends JFrame {
		

	private static final long FRAME_TIME = 1000L / 50L;
	

	private static final int min = 5;
	

	private static final int max = 3;
	

	private SnakeBoard board;
	

	private SideP side;
	

	private Random Random;
	

	private TimeTable Timer;
	

	private boolean NewGame;
		

	private boolean GameOver;
	

	private boolean Paused;
	
	public Score sc;
	
	
	private LinkedList<Point> snake;
	

	private LinkedList<Direction> dist;

	private int score;

	private int gamefruit;

	private int nextScore;

	private SnakeMatch() {
		super("Snake");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		this.board = new SnakeBoard(this);
		this.side = new SideP(this);
		
		add(board, BorderLayout.CENTER);
		add(side, BorderLayout.WEST);

		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {

				case KeyEvent.VK_W:
				case KeyEvent.VK_UP:
					if(!Paused && !GameOver) {
						if(dist.size() < max) {
							Direction last = dist.peekLast();
							if(last != Direction.Down && last != Direction.Up) {
								dist.addLast(Direction.Up);
							}
						}
					}
					break;

	
				case KeyEvent.VK_S:
				case KeyEvent.VK_DOWN:
					if(!Paused && !GameOver) {
						if(dist.size() < max) {
							Direction last = dist.peekLast();
							if(last != Direction.Up && last != Direction.Down) {
								dist.addLast(Direction.Down);
							}
						}
					}
					break;
						
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					if(!Paused && !GameOver) {
						if(dist.size() < max) {
							Direction last = dist.peekLast();
							if(last != Direction.Right && last != Direction.Left) {
								dist.addLast(Direction.Left);
							}
						}
					}
					break;
			
		
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					if(!Paused && !GameOver) {
						if(dist.size() < max) {
							Direction last = dist.peekLast();
							if(last != Direction.Left && last != Direction.Right) {
								dist.addLast(Direction.Right);
							}
						}
					}
					break;
			
			

				case KeyEvent.VK_ENTER:
					if(NewGame || GameOver) {
						resettheGame();
					}
					break;
				}
			}
			
		});
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void startthegame() {

		this.Random = new Random();
		this.snake = new LinkedList<>();
		this.dist = new LinkedList<>();
		this.Timer = new TimeTable(9.0f);
		this.NewGame = true;
		
		Timer.setPaused(true);

		while(true) {
			
			long start = System.nanoTime();
			
			Timer.update();
	
			if(Timer.hasElapsedCycle()) {
				updatetheGame();
			}
			
	
			board.repaint();
			side.repaint();
			
			long delta = (System.nanoTime() - start) / 1000000L;
			if(delta < FRAME_TIME) {
				try {
					Thread.sleep(FRAME_TIME - delta);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void updatetheGame() {
		
		TileType collision = updatetheSnake();
		
	
		if(collision == TileType.Points) {
			gamefruit++;
			score += nextScore;
			
			resSpawnFruit();
		} else if(collision == TileType.Bodyofthesnake) {
			
			new Score(score);
			GameOver = true;
			Timer.setPaused(true);
		} 
			
		
	}
	

	private TileType updatetheSnake() {

		Direction direction = dist.peekFirst();
				
			
		Point head = new Point(snake.peekFirst());
		switch(direction) {
		case Up:
			head.y--;
			break;
			
		case Down:
			head.y++;
			break;
			
		case Left:
			head.x--;
			break;
			
		case Right:
			head.x++;
			break;
		}
		
		
		if(head.x < 0 || head.x >= SnakeBoard.column || head.y < 0 || head.y >= SnakeBoard.row) {
			return TileType.Bodyofthesnake; //Pretend we collided with our body.
		}
		
		
		TileType old = board.getTile(head.x, head.y);
		if(old != TileType.Points && snake.size() > min) {
			Point tail = snake.removeLast();
			board.setTile(tail, null);
			old = board.getTile(head.x, head.y);
		}
		
		
		if(old != TileType.Bodyofthesnake) {
			board.setTile(snake.peekFirst(), TileType.Bodyofthesnake);
			snake.push(head);
			board.setTile(head, TileType.Headofthesnake);
			if(dist.size() > 1) {
				dist.poll();
			}
		}
				
		return old;
	}
	
	/**
	 * Resets the game's variables to their default states and starts a new game.
	 */
	private void resettheGame() {
	
		this.score = 0;
		this.gamefruit = 0;
	
		this.NewGame = false;
		this.GameOver = false;
		
	
		Point head = new Point(SnakeBoard.column / 2, SnakeBoard.row / 2);

	
		snake.clear();
		snake.add(head);
		
	
		board.BoardClear();
		board.setTile(head, TileType.Headofthesnake);
		

		dist.clear();
		dist.add(Direction.Up);
		
		
		Timer.reset();

		resSpawnFruit();
	}
	

	public boolean NewGame() {
		return NewGame;
	}
	

	public boolean GameOver() {
		return GameOver;
	}
	

	public boolean Paused() {
		return Paused;
	}
	

	private void resSpawnFruit() {
		
		this.nextScore = 1;

		int index = Random.nextInt(SnakeBoard.column * SnakeBoard.row - snake.size());
		
		int freeFound = -1;
		for(int x = 0; x < SnakeBoard.column; x++) {
			for(int y = 0; y < SnakeBoard.row; y++) {
				TileType type = board.getTile(x, y);
				if(type == null || type == TileType.Points) {
					if(++freeFound == index) {
						board.setTile(x, y, TileType.Points);
						break;
					}
				}
			}
		}
	}
	

	public int gettheScore() {
		return score;
	}
	

	public int getFruits() {
		return gamefruit;
	}

	public int getNextScore() {
		return nextScore;
	}
	

	public Direction getDirection() {
		return dist.peek();
	}
	

	public static void main(String[] args) {
		SnakeMatch snake = new SnakeMatch();
		snake.startthegame();
	}

}

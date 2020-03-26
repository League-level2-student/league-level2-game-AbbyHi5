import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font enterFont;
	Font gameOver;
	Timer frameDraw;
	Timer alienSpawn;
	Ship ship;
	ObjectManager objectManager;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	boolean up;
	boolean left;
	boolean right;
	
	public GamePanel() {
		
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont  = new Font("Arial", Font.PLAIN, 18);
		gameOver = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000/60,this);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		ship = new Ship(100,400,50,50);
		objectManager = new ObjectManager(ship);
		if (needImage) {
		    loadImage ("title.png");
		}
		up = false;
		right = false;
		left = false;
		
	}
	
	@Override
	public void paintComponent(Graphics g){

		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	void updateMenuState() { 
	}
	
	void updateGameState() { 
		objectManager.update();
		if (ship.isActive == false) {
			currentState = END;
		}
	}
	 
	void updateEndState()  {
		
	}
	
	void drawMenuState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, SpaceFighter.WIDTH, SpaceFighter.HEIGHT, null);
		} else {
			
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SpaceFighter.WIDTH, SpaceFighter.HEIGHT);
		}
	}
	
	void drawGameState(Graphics g) {
		
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, SpaceFighter.WIDTH, SpaceFighter.HEIGHT);
			
			objectManager.draw(g);
	}
	
	
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, SpaceFighter.WIDTH, SpaceFighter.HEIGHT);
		g.setFont(gameOver);
		g.setColor(Color.BLACK);
		g.drawString("Game Over!", 120, 100);
		g.setFont(enterFont);
		g.drawString("Press ENTER to restart", 140, 500);
	}

	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        ship = new Ship(100,400,50,50);
		        objectManager = new ObjectManager(ship);
		    } 
		    else if(currentState == MENU){
		        currentState++;
		        startGame();
		    }
		    else {
		    	currentState++;
		    	alienSpawn.stop();
		    }
		}   
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    if(ship.y>0) {
			    	ship.up();
			    }
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				 if(ship.x<800) {
					 ship.right();
				 }
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(ship.x>0) {
					ship.left();
				 }
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    if(ship.y>0) {
		    	ship.down();
		    }
		}
		
		
	}


	public void keyReleased(KeyEvent e) {
		
	}


	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	void startGame() {
		
		alienSpawn = new Timer(1500, objectManager);
		alienSpawn.start();
		
	}

}






























import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel  implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
    int currentState = MENU;
    Timer frameDraw;
    boolean up;
    boolean left;
    boolean right;
    Man man = new Man(100, 300, 50, 50);
    
    public GamePanel() {
    	
    	 frameDraw = new Timer(1000/60,this);
    	 frameDraw.start();
    	 
    	 up = false;
    	 left = false;
    	 right = false;
    	
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
		
	 }
	 
	 void updateEndState()  {  }
	 
	 void drawMenuState(Graphics g) { 
		
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, JumperMan.WIDTH, JumperMan.HEIGHT);
	 }
	 
	 void drawGameState(Graphics g) {
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, JumperMan.WIDTH, JumperMan.HEIGHT);
		 man.draw(g);
	 }
	 
	 void drawEndState(Graphics g)  {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, JumperMan.WIDTH, JumperMan.HEIGHT);
	 }

	
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}


	public void keyPressed(KeyEvent e) {
				
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {

		    if (currentState == END) {
		        currentState = MENU;
		 
		        
		    } else {
		        currentState++;
		     
		    }
		    repaint();
		}   
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			
			
		}
		
	}


	public void keyReleased(KeyEvent e) {
		
		 
	}


	public void keyTyped(KeyEvent e) {
		
		
	}

	
}

import java.awt.Color;
import java.awt.Graphics;

public class Man extends GameObject{

	public Man(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	
	void draw(Graphics g){
		
		 g.setColor(Color.BLUE);
	     g.fillRect(x, y, width, height);
		
	}
	
	void jump(){
		
		
		
	}
	
	void left(){
		
		x-=speed;
		
	}
	
	void right(){
		
		x+=speed;
		
	}
	
}

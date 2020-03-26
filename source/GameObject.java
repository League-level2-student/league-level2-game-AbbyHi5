import java.awt.Rectangle;

public class GameObject {

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed;
	 boolean isActive;
	 boolean touching;
	 Rectangle collisionBox;
	 
	 public GameObject(int x, int y, int width, int height) {
		 
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 speed = 0;
		 isActive = true;
		 touching = true;
		 collisionBox = new Rectangle();
		 
	 }
	 
	 void update() {
		 
		  collisionBox.setBounds(x, y, width, height);
		 
		 
	 }
	 
	 
	
}

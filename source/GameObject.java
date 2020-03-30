import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	double speed;
	boolean isActive;
	boolean s;
	Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 0;
		isActive = true;
		s = false;
		collisionBox = new Rectangle();

	}

	void update() {

		collisionBox.setBounds(x, y, width, height);

	}

}

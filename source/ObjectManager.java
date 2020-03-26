import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	ArrayList<Asteroid> asteroids;
	Random random;
	Ship r;
	int score;

	public ObjectManager(Ship r) {

		random = new Random();
		asteroids = new ArrayList<Asteroid>();
		this.r = r;
		score = 0;

	}

	public int getScore() {
		return this.score;
	}

	void addPlatform() {
		asteroids.add(new Asteroid(500, random.nextInt(SpaceFighter.HEIGHT), 50, 50));

	}

	void update() {
		for (int i = 0; i < asteroids.size(); i++) {

			asteroids.get(i).update();

			if (asteroids.get(i).y >= SpaceFighter.HEIGHT) {

				asteroids.get(i).isActive = false;

			}

		}

		r.update();
		checkCollision();
		prugeObjects();

	}

	void draw(Graphics g) {

		r.draw(g);
		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).draw(g);
		}

	}

	void prugeObjects() {

		for (int i = asteroids.size() - 1; i >= 0; i--) {

			if (asteroids.get(i).isActive == false) {
				asteroids.remove(i);
			}

		}

	}

	public void actionPerformed(ActionEvent arg0) {

		addPlatform();
		// System.out.println("Alien");
	}

	void checkCollision() {

		for (int i = 0; i < asteroids.size(); i++) {

			if (r.collisionBox.intersects(asteroids.get(i).collisionBox)) {

				r.isActive = false;

			}
		}

	}

}

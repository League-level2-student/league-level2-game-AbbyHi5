import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	ArrayList<Asteroid> asteroids;
	ArrayList<Alien> aliens;
	Random random;
	Ship r;
	int score;

	public ObjectManager(Ship r) {

		random = new Random();
		asteroids = new ArrayList<Asteroid>();
		aliens = new ArrayList<Alien>();
		this.r = r;
		score = 0;

	}

	public int getScore() {
		return this.score;
	}

	void addPlatform() {
		asteroids.add(new Asteroid(500, random.nextInt(SpaceFighter.HEIGHT), 50, 50));
	}
	void addAlien(){
		
		aliens.add(new Alien(500, random.nextInt(SpaceFighter.HEIGHT), 50, 50));
	}

	void update() {
		for (int i = 0; i < asteroids.size(); i++) {

			asteroids.get(i).update();

			if (asteroids.get(i).y >= SpaceFighter.HEIGHT) {

				asteroids.get(i).isActive = false;

			}
			for (int k = 0; k < aliens.size(); k++) {

				aliens.get(k).update();

				if (aliens.get(k).y >= SpaceFighter.HEIGHT) {

					aliens.get(k).isActive = false;

				}

		}

		r.update();
		checkCollision();
		prugeObjects();
		}
	}

	void draw(Graphics g) {

		r.draw(g);
		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}


	}

	void prugeObjects() {

		for (int i = asteroids.size() - 1; i >= 0; i--) {

			if (asteroids.get(i).isActive == false) {
				asteroids.remove(i);
			}

		}

		for (int i = aliens.size() - 1; i >= 0; i--) {

			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {

		addPlatform();
		addAlien();
		// System.out.println("Alien");
	}

	void checkCollision() {

		for (int i = 0; i < asteroids.size(); i++) {

			if (r.collisionBox.intersects(asteroids.get(i).collisionBox)) {

				r.isActive = false;

			}
			
			if (r.collisionBox.intersects(aliens.get(i).collisionBox)) {

				r.isActive = false;

			}
		}

	}

}

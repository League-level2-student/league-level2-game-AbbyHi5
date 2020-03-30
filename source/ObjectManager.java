import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObjectManager implements ActionListener {

	ArrayList<Asteroid> asteroids;
	ArrayList<Alien> aliens;
	Random random;
	Ship r;
	int score;
	ArrayList<Shield> shields;
	Random rand;
	BufferedImage image;
	int flop;

	public ObjectManager(Ship r) {

		random = new Random();
		asteroids = new ArrayList<Asteroid>();
		aliens = new ArrayList<Alien>();
		shields = new ArrayList<Shield>();
		this.r = r;
		score = 0;
		rand = new Random();
		loadImage();
		flop = 0;

	}

	public int getScore() {
		return this.score;
	}

	void addPlatform() {
		asteroids.add(new Asteroid(500, random.nextInt(SpaceFighter.HEIGHT - 50), 50, 50));
	}

	void addAlien() {

		aliens.add(new Alien(500, random.nextInt(SpaceFighter.HEIGHT - 50), 50, 50));
	}

	void addShield() {

		shields.add(new Shield(500, random.nextInt(SpaceFighter.HEIGHT - 50), 25, 25));
	}

	void update() {

		for (int i = 0; i < asteroids.size(); i++) {

			asteroids.get(i).update();

			if (asteroids.get(i).x <= 0) {

				asteroids.get(i).isActive = false;

			}

			for (int k = 0; k < aliens.size(); k++) {

				aliens.get(k).update();

				if (aliens.get(k).x <= 0) {

					aliens.get(k).isActive = false;

				}

				for (int h = 0; h < shields.size(); h++) {

					shields.get(h).update();

					if (shields.get(h).x <= 0) {

						shields.get(h).isActive = false;

					}
				}
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
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < shields.size(); i++) {
			shields.get(i).draw(g);
		}
		if (r.s) {
			g.drawImage(image, r.x + 40, r.y + 5, 35, 40, null);
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
		for (int i = shields.size() - 1; i >= 0; i--) {

			if (shields.get(i).isActive == false) {
				shields.remove(i);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		addPlatform();
		addAlien();
		if (rand.nextInt(5) == 1) {
			addShield();
		}
	}

	void checkCollision() {

		for (int i = 0; i < asteroids.size(); i++) {

			if (r.collisionBox.intersects(asteroids.get(i).collisionBox)) {

				if (r.s) {
					r.s = false;
					asteroids.remove(i);
				} else {
					r.isActive = false;
				}
			}
		}

		for (int i = 0; i < aliens.size(); i++) {

			if (r.collisionBox.intersects(aliens.get(i).collisionBox)) {

				if (r.s) {
					r.s = false;
					aliens.remove(i);
				} else {
					r.isActive = false;
				}

			}
		}

		for (int i = 0; i < shields.size(); i++) {

			if (r.collisionBox.intersects(shields.get(i).collisionBox)) {

				r.s = true;
				shields.remove(i);
			}
		}

	}

	void loadImage() {

		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("Ship_shield.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

import javax.swing.JFrame;

public class SpaceFighter {

	GamePanel game = new GamePanel();
	JFrame frame = new JFrame("League Invaders");
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 500;
	static SpaceFighter space = new SpaceFighter();
	
	public static void main(String[] args) {
		
		space.setup();
		
	}
	
	void setup() {
		
		frame.addKeyListener(game);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		
	}
	
}

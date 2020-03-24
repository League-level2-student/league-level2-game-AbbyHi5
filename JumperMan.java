import javax.swing.JFrame;

public class JumperMan {

	GamePanel game = new GamePanel();
	JFrame frame = new JFrame("Jumper Man");
	
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	static JumperMan jumper = new JumperMan();
	
	public static void main(String[] args) {
		
		jumper.setup();
		
	}
	
	void setup() {
		
		frame.addKeyListener(game);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		
	}
	
	
}

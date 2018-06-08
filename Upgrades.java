import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Upgrades extends JFrame {

	private static final long serialVersionUID = 1L;

	public Upgrades() {

		// set flow layout for the frame
		this.getContentPane().setLayout(new FlowLayout());

		JButton button1 = new JButton();
		button1.setText("Java Code Geeks");

		JButton button2 = new JButton("Java Examples & Code Snippets");

		// add buttons to frame
		add(button1);
		add(button2);

	}

	public static void createAndShowGUI() {

  //Create and set up the window.

  JFrame frame = new Upgrades();

  //Display the window.

  frame.pack();

  frame.setVisible(true);

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

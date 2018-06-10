import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class Upgrades extends JFrame {
	 public static  boolean noob = true;
	private static final long serialVersionUID = 1L;
	public Upgrades() {
		// set flow layout for the frame
		this.getContentPane().setLayout(new FlowLayout());
		JButton button1 = new JButton();
		button1.setText("Finished");
		JButton button2 = new JButton("Java Examples & Code Snippets");
		//////////////////////////////////
		//JFrame f = new JFrame("Button Example");  
		final JTextField tf=new JTextField();  
		
		tf.setBounds(50,50, 150,20);  
		JButton b=new JButton("Click Here");  
		b.setBounds(50,100,95,30);
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				//GameFrame.waveEnd = false;
				
					GameFrame.Spawn();
					noob=false;
					
						
				
				
			}  
		});
		/////////////////////////////////
		// add buttons to frame
		add(button1);
		add(button2);
		add(b);
		add(tf);
		
	}
	/*public void actionPerformed(ActionEvent e){  
        tf.setText("Welcome to Javatpoint.");  
    } */
	public static  void createAndShowGUI() {
		//boolean noob = true;
  //Create and set up the window.
  JFrame frame = new Upgrades();
  frame.setBounds(500,100,500,500);
  //Display the window.
  frame.pack();
  
  frame.setVisible(noob);
  
  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

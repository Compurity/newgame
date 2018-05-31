import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.*;

import com.sun.scenario.effect.impl.prism.ps.PPSPhongLighting_DISTANTPeer;
@SuppressWarnings("serial")


public class GameFrame extends JFrame
{
	private static final int CANVAS_WIDTH=1585;
	private static final int CANVAS_HEIGHT= 822;
	private static final int UPDATE_PERIOD=25;
	
	private DrawCanvas canvas;
	private int x=100, y=100, x2=300, y2=300;
	private int size =100;
	private int xSpeed=10, ySpeed=20, xSpeed2=5, ySpeed2=5;
	
	private static Player player;
	private static Enemy enemy; 
	private boolean LEFT,RIGHT,UP,DOWN; 
	public GameFrame()
	{
		canvas= new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		this.setContentPane(canvas);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setTitle("Bouncing Ball");
		this.setVisible(true);
		this.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
						UP = false;
		            break;
		            case KeyEvent.VK_DOWN:
					DOWN = false; 
		            break;
		            case KeyEvent.VK_RIGHT:
						RIGHT = false; 
		            break;
		            case KeyEvent.VK_LEFT:
						LEFT = false; 
		            break;
				}
			}
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
						UP = true;
		            break;
		            case KeyEvent.VK_DOWN:
					DOWN = true; 
		            break;
		            case KeyEvent.VK_RIGHT:
						RIGHT = true; 
		            break;
		            case KeyEvent.VK_LEFT:
						LEFT = true; 
		            break;
				}
			}
		});
		ActionListener updateTask= new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				update();
				repaint();
			}
		};
		new Timer(UPDATE_PERIOD, updateTask).start();
	}
	public void update(){
		x+=xSpeed;
		y+= ySpeed;
		/*int corner1x=x;
		int corner1y=y;
		int corner2x=x+size;
		int corner2y=y;
		int corner3x=x;
		int corner3y=y+size;
		int corner4x=x+size;
		int corner4y=y+size;*/
		
		if(LEFT && UP) {
			player.X-=5;player.Y-=5; 
		} else if(RIGHT && UP) {
			player.X+=5;player.Y-=5;
		}else if(LEFT && DOWN) {
			player.X-=5;player.Y+=5;
		}else if(RIGHT && DOWN) {
			player.X+=5;player.Y+=5;
		}else if(RIGHT) {
			player.X+=5;
		}else if(LEFT) {
			player.X-=5;
		}else if(UP) {
			player.Y-=5;
		}else if(DOWN) {
			player.Y+=5;
		}
		
		
		
		if(enemy.X1<player.X){
			enemy.X1+=3; 
		}
		else if(enemy.X1>player.X){
			enemy.X1-=3; 
			
		}if(enemy.Y1<player.Y){
			enemy.Y1+=3;
		}else if(enemy.Y1>player.Y){
			enemy.Y1-=3;
		}
		
		
		//player.Y-player.H >= point.Y && player.Y <= point.Y
		
		if(player.X > CANVAS_WIDTH){
			player.X = CANVAS_WIDTH;
		}
		if(player.Y>=694){
			player.Y = 690;
		}
		if(player.X<0){
			player.X = 0;
		}
		if(player.Y<0){
			player.Y = 0;
		}
		
	
		
		}
		private class DrawCanvas extends JPanel
		{
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(Color.WHITE);
			g.drawRect(player.X, player.Y, player.W, player.H);
			g.drawRect(enemy.X1, enemy.Y1, enemy.W1, enemy.H1);
			g.drawLine(0,700, 1585, 700);
			//g.setColor(Color.WHITE);
			//g.fillRect(x,y,size,size);
			//g.setColor(Color.RED);
			//g.fillRect(x2, y2, size, size);
		}
	}
		
		
	public static void main(String[]args){
		player = new Player(); 
		enemy = new Enemy();
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new GameFrame();
			}
		});
	}
	
	
}

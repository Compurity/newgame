import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.JButton;
public class GameFrame extends JFrame{
	private static final int CANVAS_WIDTH=1585;
	private static final int CANVAS_HEIGHT= 822;
	private int UPDATE_PERIOD=25;
	private DrawCanvas canvas;
	private int mana = 300;
	private int health = 500;
	private int gold = 0;
	private int currentWave = 1;
	//private int enemiesAlive = 9;
	private int x=100, y=100, x2=300, y2=300;
	private int size =100;
	private int xSpeed=10, ySpeed=20, xSpeed2=5, ySpeed2=5;
	private static Player player;
	private static Upgrades upgrades;
	private static Enemy[] e1 = new Enemy[9];
	private boolean LEFT,RIGHT,UP,DOWN; 
	public int sum;
	private int manaRegen;
	private boolean waveEnd = false;
	public GameFrame()
	{
		canvas= new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		this.setContentPane(canvas);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setTitle("Invoker Game");
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
				if(sum >= -165) {
					System.out.println(sum);
					update();
					repaint();
				}			
			}
		};
		new Timer(UPDATE_PERIOD, updateTask).start();
	}
	public void update(){
		x+=xSpeed;
		y+= ySpeed;
		
		manaRegen = manaRegen + 1;
		if(manaRegen == 25)
		{
			mana = mana + 1;
			manaRegen = 0;
		}
		/*int corner1x=x;
		int corner1y=y;
		int corner2x=x+size;
		int corner2y=y;
		int corner3x=x;
		int corner3y=y+size;
		int corner4x=x+size;
		int corner4y=y+size;*/
		if(LEFT && UP) {
			player.X-=4;player.Y-=4; 
		} else if(RIGHT && UP) {
			player.X+=4;player.Y-=4;
		}else if(LEFT && DOWN) {
			player.X-=4;player.Y+=4;
		}else if(RIGHT && DOWN) {
			player.X+=4;player.Y+=4;
		}else if(RIGHT) {
			player.X+=4;
		}else if(LEFT) {
			player.X-=4;
		}else if(UP) {
			player.Y-=4;
		}else if(DOWN) {
			player.Y+=4;
		}
		for(int i = 0; i < e1.length; i++)
		{
			if(e1[i].X1<player.X){
				e1[i].X1+=2; 
			}else if(e1[i].X1>player.X){
				e1[i].X1-=2; 
			}if(e1[i].Y1<player.Y){
				e1[i].Y1+=2;
			}else if(e1[i].Y1>player.Y){
				e1[i].Y1-=2;
			}
		}
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
		//1st
		if(player.X >= 100 && player.X <= 200 && player.Y >= 594 && player.Y <= 600 )
		{
			player.Y = 590;
		}
		if(player.X >= 500 && player.X <= 600 && player.Y >= 594 && player.Y <= 600 )
		{
			player.Y = 590;
		}
		if(player.X >= 985 && player.X <= 1085 && player.Y >= 594 && player.Y <= 600 )
		{
			player.Y = 590;
		}
		if(player.X >= 1385 && player.X <= 1485 && player.Y >= 594 && player.Y <= 600 )
		{
			player.Y = 590;
		}
		//2nd
		if(player.X >= 300 && player.X <= 400 && player.Y >= 494 && player.Y <= 500 )
		{
			player.Y = 490;
		}
		if(player.X >= 700 && player.X <= 800 && player.Y >= 494 && player.Y <= 500 )
		{
			player.Y = 490;
		}
		if(player.X >= 1185 && player.X <= 1285 && player.Y >= 494 && player.Y <= 500 )
		{
			player.Y = 490;
		}
		//3rd
		if(player.X >= 100 && player.X <= 200 && player.Y >= 394 && player.Y <= 400 )
		{
			player.Y = 390;
		}
		if(player.X >= 500 && player.X <= 600 && player.Y >= 394 && player.Y <= 400 )
		{
			player.Y = 390;
		}
		if(player.X >= 985 && player.X <= 1085 && player.Y >= 394 && player.Y <= 400 )
		{
			player.Y = 390;
		}
		if(player.X >= 1385 && player.X <= 1485 && player.Y >= 394 && player.Y <= 400 )
		{
			player.Y = 390;
		}
		//4th
		if(player.X >= 300 && player.X <= 400 && player.Y >= 294 && player.Y <= 300 )
		{
			player.Y = 290;
		}
		if(player.X >= 700 && player.X <= 800 && player.Y >= 294 && player.Y <= 300 )
		{
			player.Y = 290;
		}
		if(player.X >= 1185 && player.X <= 1285 && player.Y >= 294 && player.Y <= 300 )
		{
			player.Y = 290;
		}
		for(int i = 0; i < e1.length; i++)
		{
			for(int g = 0;g < e1.length; g++ )
			{
				if(e1[g].Y1 <= player.Y + 10 && e1[g].Y1 >= player.Y - 10)
				{
					if(e1[g].X1 <= player.X + 10 && e1[g].X1 >= player.X - 10){
						health = health - 10;
						e1[g].health = e1[g].health - 30;
						if(player.X > e1[g].X1)
							e1[g].X1 = e1[g].X1 - 50;
						else if(player.X < e1[g].X1)
							e1[g].X1 = e1[g].X1 + 50;
						else if(e1[g].Y1 < player.Y)
							e1[g].Y1 = e1[g].Y1 - 50;
						else
							e1[g].Y1 = e1[g].Y1 + 50;
					}
				}
			}
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
			for(int i = 0; i < e1.length; i++)
			{
				g.drawRect(e1[i].X1, e1[i].Y1, e1[i].W1, e1[i].H1);
				g.drawString("Health: " + e1[i].health,e1[i].X1 - 16,e1[i].Y1);
			}
			g.drawLine(0,700, 1585, 700);
			g.drawString("",60,730);
	        g.drawString("Health : " + health,60,750);
	        g.drawString("Mana : " + mana,60,765);
	        g.drawString("Wave : " + currentWave,60, 780);
	        //g.drawString("Enemies Alive : " + enemiesAlive,1200 ,750 );
	       	g.drawLine(100,600,200,600);
			g.drawLine(500,600,600,600);
			//First Level Plats
			g.drawLine(985,600,1085,600);
			g.drawLine(1385,600,1485,600);
			g.drawLine(300,500,400,500);
			g.drawLine(700,500,800,500); //Second Level Plats
			g.drawLine(1185,500,1285,500);
			
			g.drawLine(100,400,200,400);
			g.drawLine(500,400,600,400);
			//Third Level Plats
			g.drawLine(985,400,1085,400);
			g.drawLine(1385,400,1485,400);
			
			g.drawLine(300,300,400,300);
			g.drawLine(700,300,800,300); //Fourth Level Plats
			g.drawLine(1185,300,1285,300);
			//g.setColor(Color.WHITE);
			//g.fillRect(x,y,size,size);
			//g.setColor(Color.RED);
			//g.fillRect(x2, y2, size, size);
			/*JButton button1 = new JButton();
			button1.setText("Java Code Geeks");
			add(button1);*/
		
			for(int i = 0; i < e1.length; i++)
			{
				if(e1[i].health <= 0)
				{
					e1[i].X1 = -20;
					e1[i].Y1 = -20;
					if(e1[i].X1 != -20 || e1[i].Y1 != -20)
					{
						e1[i].X1 = -20;
						e1[i].Y1 = -20;
					}
				}
				sum = 0;
				for(int q = 0; q < e1.length; q++)
					sum = sum + e1[q].X1;
				if(sum <= -170)
				{
					//g.drawRect(500, 100, 500, 500);
				}
				if(sum <= -165)
				{
					if(waveEnd == false) {
						gold = gold + 250;
						currentWave = currentWave + 1;
						Upgrades.createAndShowGUI();
						waveEnd = true;
					}
				}
			}
		}
	}
	public static void main(String[]args){
		player = new Player();
		upgrades = new Upgrades();
		
		for(int i = 0; i < e1.length; i++)
		{
			e1[i] = new Enemy();
		}
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new GameFrame();
			}
		});
	}
}

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.JButton;
public class GameFrame extends JFrame{
	private static final int CANVAS_WIDTH=1585;
	private static final int CANVAS_HEIGHT= 822;
	private int UPDATE_PERIOD=10;
	private DrawCanvas canvas;
	private int mana = 300;
	private int health = 500;
	private int gold = 0;
	private int currentWave = 1;
	//private int enemiesAlive = 9;
	private int x=100, y=100, x2=300, y2=300;
	private int size =100;
	private int xSpeed=10, ySpeed=20, xSpeed2=5, ySpeed2=5;
	public static Player player;
	private static Music music;
	private static Upgrades upgrades;
	public static Enemy[] e1 = new Enemy[9];
	private boolean LEFT,RIGHT,UP,DOWN, ON_PLATFORM;
	private boolean CLICKED = false;
	public int sum;
	private int manaRegen;
	public boolean waveEnd = false;
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	private static int X;
	private static int Y;
	private int yep;
	public void startJumpAction() {
		 Thread t1 = new Thread(new Runnable() {
			    public void run()
			    {
			    	int ctn = 0; 
			    	while(ctn < 3) {
			    		player.Y-=40; 
			    		ctn++;
			    		try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
					    	UP = false;
						}
			    	}
			    	UP = false;
			    }});  
			    t1.start();
	}
	
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
				/*case KeyEvent.VK_W:
						UP = false;
		            break;*/
		            case KeyEvent.VK_S:
		            	DOWN = false; 
		            break;
		            case KeyEvent.VK_D:
						RIGHT = false; 
		            break;
		            case KeyEvent.VK_A:
						LEFT = false; 
		            break;
				}
			}
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_W:
					if(!UP)
						UP = true;
		            break;
		            case KeyEvent.VK_S:
					DOWN = true; 
		            break;
		            case KeyEvent.VK_D:
						RIGHT = true; 
		            break;
		            case KeyEvent.VK_A:
						LEFT = true; 
		            break;
				}
			}
		});
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
				System.out.println(player.X);
				projectiles.add(new Projectile(player.X, player.Y));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				e.getX();
				e.getY();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				e.getX();
				e.getY();
			}

		@Override
			public void mousePressed(MouseEvent e) {
				
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
	            e.getX(); 
	            e.getY();
	            e.getClickCount();
	            projectiles.add(new Projectile(player.X, player.Y));
			}
		
		});
		ActionListener updateTask= new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				//if(sum <= -165) {
					//System.out.println(sum);
					update();
					repaint();
				//}			
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
			player.X-=6;
			if(ON_PLATFORM)
				startJumpAction();
		} else if(RIGHT && UP) {
			player.X+=6;
			
			if(ON_PLATFORM)
				startJumpAction();
		}else if(LEFT && DOWN) {
			player.X-=6;player.Y+=6;
		}else if(RIGHT && DOWN) {
			player.X+=6;player.Y+=6;
		}else if(RIGHT) {
			player.X+=6;
		}else if(LEFT) {
			player.X-=6;
		}else if(UP) {
			if(ON_PLATFORM)
				startJumpAction();
		}else if(DOWN) {
			player.Y+=6;
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			
			if(X > player.X)
				projectiles.get(i).X = projectiles.get(i).X +10;
			else if(X < player.X)
				projectiles.get(i).X = projectiles.get(i).X -10;///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			for(int g = 0; g < e1.length;g++) {
				if((projectiles.get(i).X> CANVAS_WIDTH || projectiles.get(i).X< 0 ) || (projectiles.get(i).Y <= e1[g].Y1 + 10 && projectiles.get(i).Y >= e1[g].Y1 - 10))	{
					System.out.println(projectiles.get(i).X);
					//projectiles.remove(i);
					//projectiles.get(i).Y = -30;
					//e1[g].health = e1[g].health - 30;
					if(projectiles.get(i).X <= e1[g].X1 + 10 && projectiles.get(i).X >= e1[g].X1 - 10) {
						//projectiles.remove(i);
						projectiles.get(i).Y = -30;
						e1[g].health = e1[g].health -30 ;
					}
				}
			}
			
			if(projectiles.get(i).X> CANVAS_WIDTH || projectiles.get(i).X< 0) {
				projectiles.remove(i);
			}
			else if(projectiles.get(i).Y> CANVAS_HEIGHT || projectiles.get(i).Y< 0) {
				projectiles.remove(i);
			}
			
			
		}
			
			
				/*if(projectiles.get(i).Y <= e1[g].Y1 + 10 && projectiles.get(i).Y >= e1[g].Y1 - 10) {
					if(projectiles.get(i).X <= e1[g].X1 + 10 || projectiles.get(i).X >= e1[g].X1 - 10) {
						projectiles.remove(i);
						e1[g].health = e1[g].health - 30;
					}
				}
			
		}*/
		
		
		//for(int i =0; i< projectiles.size(); i++) {
			//projectiles.get(i).GetNext();
		//}
		for(int p = 0; p < e1.length; p++)
		{
			if(e1[p].X1<player.X){
				e1[p].X1+=4; 
			}else if(e1[p].X1>player.X){
				e1[p].X1-=4; 
			}if(e1[p].Y1<player.Y){
				e1[p].Y1+=4;
			}else if(e1[p].Y1>player.Y){
				e1[p].Y1-=4;
			}
			
			
		}
		if(player.X > CANVAS_WIDTH){
			player.X = CANVAS_WIDTH;
		}
		if(player.X<0){
			player.X = 0;
		}
		
		//Gravity
		player.Y+=5;
		
		for(int q = 0; q < e1.length;q++)
		{
			//Enemy Gravity
			e1[q].Y1+=20;
			
			if(e1[q].X1<0){
			e1[q].X1 = 0;
			}
			if(e1[q].Y1>=690){
				e1[q].Y1 = 690;
				ON_PLATFORM = true;
			}else
			if(e1[q].Y1<0){
				e1[q].Y1 = 0;
				ON_PLATFORM = true;
			}
		
		}
		
		if(player.Y>=690){
			player.Y = 690;
			ON_PLATFORM = true;
		}else
		if(player.Y<0){
			player.Y = 0;
			ON_PLATFORM = true;
		}else
			
		//1st
		if(player.X >= 100 && player.X <= 200 && player.Y >= 590 && player.Y <= 600 )
		{
			player.Y = 590;
			ON_PLATFORM = true;
		} else
		if(player.X >= 500 && player.X <= 600 && player.Y >= 590 && player.Y <= 600 )
		{
			player.Y = 590;
			ON_PLATFORM = true;
		}else
		if(player.X >= 985 && player.X <= 1085 && player.Y >= 590 && player.Y <= 600 )
		{
			player.Y = 590;
			ON_PLATFORM = true;
		}else
		if(player.X >= 1385 && player.X <= 1485 && player.Y >= 590 && player.Y <= 600 )
		{
			player.Y = 590;
			ON_PLATFORM = true;
		}else
		//2nd
		if(player.X >= 300 && player.X <= 400 && player.Y >= 490 && player.Y <= 500 )
		{
			player.Y = 490;
			ON_PLATFORM = true;
		}else
		if(player.X >= 700 && player.X <= 800 && player.Y >= 490 && player.Y <= 500 )
		{
			player.Y = 490;
			ON_PLATFORM = true;
		}else
		if(player.X >= 1185 && player.X <= 1285 && player.Y >= 490 && player.Y <= 500 )
		{
			player.Y = 490;
			ON_PLATFORM = true;
		}else
		//3rd
		if(player.X >= 100 && player.X <= 200 && player.Y >= 390 && player.Y <= 400 )
		{
			player.Y = 390;
			ON_PLATFORM = true;
		}else
		if(player.X >= 500 && player.X <= 600 && player.Y >= 390 && player.Y <= 400 )
		{
			player.Y = 390;
			ON_PLATFORM = true;
		}else
		if(player.X >= 985 && player.X <= 1085 && player.Y >= 390 && player.Y <= 400 )
		{
			player.Y = 390;
			ON_PLATFORM = true;
		}else
		if(player.X >= 1385 && player.X <= 1485 && player.Y >= 390 && player.Y <= 400 )
		{
			player.Y = 390;
			ON_PLATFORM = true;
		}else
		//4th
		if(player.X >= 300 && player.X <= 400 && player.Y >= 290 && player.Y <= 300 )
		{
			player.Y = 290;
			ON_PLATFORM = true;
		}else
		if(player.X >= 700 && player.X <= 800 && player.Y >= 290 && player.Y <= 300 )
		{
			player.Y = 290;
			ON_PLATFORM = true;
		}else
		if(player.X >= 1185 && player.X <= 1285 && player.Y >= 290 && player.Y <= 300 )
		{
			player.Y = 290;
			ON_PLATFORM = true;
		} else 
			ON_PLATFORM = false;
		for(int o = 0; o < e1.length; o++)
		{
			for(int h = 0;h < e1.length; h++ )
			{
				if(e1[h].Y1 <= player.Y + 10 && e1[h].Y1 >= player.Y - 10)
				{
					if(e1[h].X1 <= player.X + 10 && e1[h].X1 >= player.X - 10){
						health = health - 10;
						//e1[h].health = e1[h].health - 30;
						if(player.X > e1[h].X1)
							e1[h].X1 = e1[h].X1 - 50;
						else if(player.X < e1[h].X1)
							e1[h].X1 = e1[h].X1 + 50;
						else if(e1[h].Y1 < player.Y)
							e1[h].Y1 = e1[h].Y1 - 50;
						else
							player.Y = player.Y - 200;
					}
				}
			}
		}
		for(int o = 0; o < e1.length; o++)
		{
			for(int h = 0;h < e1.length; h++ )
			{
				if(e1[h].Y1 <= e1[o].Y1 + 10 && e1[h].Y1 >= e1[o].Y1 - 10)
				{
					if(e1[h].X1 <= e1[o].X1 + 10 && e1[h].X1 >= e1[o].X1 - 10){
						//health = health - 10;
						//e1[h].health = e1[h].health - 30;
						if(e1[o].X1 > e1[h].X1)
							e1[h].X1 = e1[h].X1 - 4;
						else if(e1[o].X1 < e1[h].X1)
							e1[h].X1 = e1[h].X1 + 4;
						else if(e1[h].Y1 < e1[o].Y1)
							e1[h].Y1 = e1[h].Y1 - 4;
						else
							e1[o].Y1 = e1[o].Y1 - 4;
					}
				}
			}
		}
		/*for(int i = 0;i <= e1.length-1;i++)
		{
			for(int j = 0; j < e1.length-1; j++) {
				if(e1[i].X1+10<=e1[j].X1+10 && e1[i].X1+10 >= e1[j].X1 - 10) {
					e1[i].X1 = e1[i].X1;
					e1[j].X1 = e1[j].X1;
				}
			}
		}*/
	}
		private class DrawCanvas extends JPanel
		{
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(Color.WHITE);
			g.drawRect(player.X, player.Y, player.W, player.H);
			
			manaRegen = manaRegen + 1;
			if(manaRegen == 25)
			{
				mana = mana + 1;
				manaRegen = 0;
			}
				for(int i = 0; i < e1.length; i++)
				{
						g.drawRect(e1[i].X1, e1[i].Y1, e1[i].W1, e1[i].H1);
				}
			for(int i = 0; i < e1.length; i++) {
				for(int r = 0;r < projectiles.size();r++) {
					g.drawRect(projectiles.get(r).X,projectiles.get(r).Y,projectiles.get(r).H,projectiles.get(r).W);
				}
				
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
			//for(int i =0; i < projectiles.size(); i++)
				//g.drawRect();
			
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
				if(sum <= -165)
				{
					//waveEnd = false;
					if(waveEnd == false) {
						gold = gold + 250;
						currentWave = currentWave + 1;
						Upgrades.createAndShowGUI();
						//Upgrades.noob = false;
						waveEnd = true;
					}
				}
			}
		}
	}
		public static void Spawn()
		{
			for(int i = 0; i < e1.length; i++)
			{
				e1[i] = new Enemy();
				
			}
		}
	public static void main(String[]args){
		player = new Player();
		upgrades = new Upgrades();
		music = new Music();
		Music.sound();
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

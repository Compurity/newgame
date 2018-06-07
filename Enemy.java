import java.util.ArrayList;
public class Enemy
{
	private int health;
	private int damage;
	private double attSpeed;
	private int speed;
	private int mana;
	
	public int X1;
	public int Y1;
	public int H1;
	public int W1;
	
	public Enemy()
	{
	 	//health = 200 + (20 * Waves.getCurrentWave());
	 	//damage = 25 + (2 * Waves.getCurrentWave());
	 	attSpeed = 1;
	 	speed = 20;
	 	//mana = 100 + (5 * Waves.getCurrentWave());
	 	X1 = 10;
	 	Y1 = 10;
	 	H1 = 10;
	 	W1 = 10;
	}
	
	public Enemy(int a, int b, double c, int d, int e)
	{
		
	}
	
}

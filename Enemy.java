import java.util.ArrayList;
public class Enemy
{
	private int health;
	private int damage;
	private double attSpeed;
	private int speed;
	private int mana;
	
	public int X;
	public int Y;
	public int H;
	public int W;
	
	public Enemy()
	{
	 	health = 200 + (20 * Waves.getCurrentWave());
	 	damage = 25 + (2 * Waves.getCurrentWave());
	 	attSpeed = 1;
	 	speed = 20;
	 	mana = 100 + (5 * Waves.getCurrentWave());
	}
	
	public Enemy(int a, int b, double c, int d, int e)
	{
		health = a;
		damage = b;
		attSpeed = c;
		speed = d;
		mana = e;
	}
	public int getHealth()
	{
		return health;
	}
}

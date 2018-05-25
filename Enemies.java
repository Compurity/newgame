import java.util.ArrayList;
public class Enemies
{
	private int health;
	private int damage;
	private double attSpeed;
	private int speed;
	private int mana;
	
	public Enemies(int a, int b, double c, int d, int e)
	{
		a = health;
		b = damage;
		c = attSpeed;
		d = speed;
		e = mana;
	}
	public Enemies()
	{
	 	health = 200
	 	damage = 20
	 	attSpeed = 1
	 	speed = 20
	 	mana = 100
	}
	public void creep()
	{
		//creates objects which are enemies of current wave, once creep dies, object is removed.
	}
}

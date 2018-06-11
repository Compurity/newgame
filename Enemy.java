import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Enemy{
	
	Random rand = new Random();
	public int health;
	private int damage;
	private double attSpeed;
	private int mana;
	public int X1;
	public int Y1;
	public int H1 = 10;
	public int W1 = 10;

	public Enemy()
	{
		health = 200;
		damage = 10;
		attSpeed = 10;
		mana = 100;
		X1 = rand.nextInt(2) * 1599;
		Y1 = 690;
	}
	public Enemy(int a, int b, double c, int d, int e, int f)
	{
		health = a;
		damage = b;
		attSpeed = c;
		mana = d;
		X1 = e;
		Y1 = f;
	}
	public int getHealth()
	{
		return health;
	}
}

import java.awt.Graphics;
import java.awt.Point;

public class Projectile {
	public static final double ACCELERATION = 1;
	public int H;
	public int W;
	public int X;
	public int Y;
	public Projectile(int x, int y) {
		X = x;
		Y = y;
		H = 4;
		W = 4;
	}
}

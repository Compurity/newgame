import java.awt.Graphics;
import java.awt.Point;

public class Projectile {
	public static final double ACCELERATION = 1;
	public int H;
	public int W;
	Point start;
	Point end;

	double velocity = 10d, angle,xVelocity,yVelocity,totalTime,timeIncrement,xIncrement;
	Point last;
	public Projectile(int x, int y, int endX, int endY) {
		H = 4;
		W = 4;
		start = new Point(x, y);
		end = new Point(endX, endY);
		angle = Math.toRadians(getAngle(start, end));
		 xVelocity = velocity * Math.cos(angle);
		 yVelocity = velocity * Math.sin(angle);
		 totalTime =  3 * yVelocity / ACCELERATION;
		 timeIncrement = totalTime / 30;
		 xIncrement = xVelocity * timeIncrement;
		last = start;
	}
	
	public float getAngle(Point start, Point target) {
		float angle = (float) Math.toDegrees(Math.atan2(target.y - start.y, target.x - start.x));

		if (angle < 0) {
			angle += 360;
		}

		return angle;
	}

	double x = 0.0;
	double y = 0.0;
	double t = 0.0;

	public void GetNext() {
		t += timeIncrement;
		x += xIncrement;
		y = yVelocity * t + 0.5 * ACCELERATION * t * t;
		last= new Point((int) round2(x), (int) round2(y));
		//System.out.println(""+timeIncrement +", "+ xIncrement + ", "+y);
	}
	  public static double round2(double n) {
	        return (int) (n * 100.0 + 0.5) / 100.0;
	    }
}

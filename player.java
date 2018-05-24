import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Player{
	private static final Component RectDraw = null;
	private int Health;
	private int PDamage;
	private int pLevel;
	private int Mana;
	private int Gold;
	private double pAttkS;
	
	public Player(){
		Health = 650;
		PDamage = 46;
		pLevel = 1;
		Mana = 400;
		Gold = 600;
		pAttkS = 1.3;
	}
	public Player(int a, int b, int c, int d, int e, int f){
		Health = a;
		PDamage = b;
		pLevel = c;
		Mana = d;
		Gold = e;
		pAttkS = f;
		
	}
	public void movement(java.awt.event.KeyEvent evt) {
		int key = evt.getKeyCode();
		
		
		switch(key) {
		case KeyEvent.VK_UP:
            jPanel1.setLocation(jPanel1.getLocation().x, jPanel1.getLocation().y - 5);
            break;
            
            case KeyEvent.VK_DOWN:
            jPanel1.setLocation(jPanel1.getLocation().x, jPanel1.getLocation().y + 5);
            break;
            
            case KeyEvent.VK_RIGHT:
            jPanel1.setLocation(jPanel1.getLocation().x + 5, jPanel1.getLocation().y);
            break;
            
            case KeyEvent.VK_LEFT:
            jPanel1.setLocation(jPanel1.getLocation().x - 5, jPanel1.getLocation().y);
            break;
		}
		
	}
}

import java.util.ArrayList;
public class Waves
{
	private int gold;
	private boolean waveStop;
	private boolean waveStart;
	private int waves = 50;
	private int sum = 0;
	private int currentWave = 0;
	Enemy[] enemies = new Enemy[130];
	
	public void Spawn()									//Spawns in creeps in each wave
	{
		int wave = currentWave;
		for(int i = 0, i < 30 + (wave * 2), i++)		
		{
			enemies[i] = new Enemy();
		}	
	}	
	public boolean waveEnd()							//constantly checks if the sum of all enemies is 0. if 0 return true otherwise return false.
	{
		int sum = 0;									
		for(int i = 0, i < enemies.length, i++)
		{
			sum += enemies[i].getHealth();
		}
		if(sum == 0)
		{
			return true;
		}
		return false;
	}
	public boolean upgrades()							//brings up upgrade window with upgrades to health, mana and abilities if waveEnd is true.
	{
		if(waveEnd().equals true)					
		{
			
		}								
	}
	public int getCurrentWave()							//used for stats of enemies in Enemy class.
	{
		int sum = 0;
		for(int i = 0, i < enemies.length, i++)			
		{
			sum += enemies[i].getHealth();
		}
		if(sum == 0)
		{
			currentWave += 1;
		}
		return currentWave
	}
}

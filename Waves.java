import java.util.ArrayList;
public class Waves
{
	
	private int gold;
	private boolean waveStop;
	private boolean waveStart;
	private int waves = 50;
	private int sum = 0;
	
	for(int i = 0, i < allEnemies.length, i++)
	{
		Enemies(i).Spawn();
	}
	
	public boolean waveEnd()
	{
		for(int j = 0, j < waves, j++)
		{
			sum = sum + allEnemies(i).getHealth();
		}
		if(sum == 0)
			return true;
		return false;
	}
	public boolean upgrades()
	{
		if(waveEnd == true)
		{
			
		}
	}
}

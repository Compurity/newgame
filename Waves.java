import java.util.ArrayList;
public class Waves
{
	private int gold;
	private boolean waveStop;
	private boolean waveStart;
	private int waves = 50;
	private int sum = 0;
	private int currentWave = 0;
	
	public void Spawn()
	{
		//Spawns in creeps in each wave
	}
	
	public boolean waveEnd()
	{
		//constantly checks if the sum of all enemies is 0. once true, brungs up upgrade page.
	}
	public boolean upgrades()
	{
		//brings up upgrade window with upgrades to health, mana and abilities.
	}
	public int getCurrentWave()
	{
		return currentWave //used for stats of enemies in Enemies class.
	}
}


public class PlayedHero {
	
	private Heros playedHero;
	private int kills;
	private int deaths;
	
	public PlayedHero(Heros hero)
	{
		this.playedHero = hero;
		kills = 0;
		deaths = 0;
	}
	public PlayedHero(Heros hero,int kills, int deaths)
	{
		this.playedHero = hero;
		this.kills = kills;
		this.deaths = deaths;
	}
	
	public Heros getHero()
	{
		return playedHero;
	}
	public int getKills()
	{
		return kills;
	}
	public int getDeaths()
	{
		return deaths;
	}
	public void incKills()
	{
		kills++;
	}
	public void incDeaths()
	{
		deaths++;
	}

}

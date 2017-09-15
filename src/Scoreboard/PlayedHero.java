package Scoreboard;

public class PlayedHero {
	
	private Hero playedHero;
	private int kills;
	private int deaths;
	
	public PlayedHero(Hero hero)
	{
		this.playedHero = hero;
		kills = 0;
		deaths = 0;
	}
	public PlayedHero(Hero hero,int kills, int deaths)
	{
		this.playedHero = hero;
		this.kills = kills;
		this.deaths = deaths;
	}
	
	public Hero getHero()
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

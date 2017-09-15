package Scoreboard;

public class PlayedHero {
	
	private HeroName playedHero;
	private int kills;
	private int deaths;
	
	public PlayedHero(HeroName hero)
	{
		this.playedHero = hero;
		kills = 0;
		deaths = 0;
	}
	public PlayedHero(HeroName hero,int kills, int deaths)
	{
		this.playedHero = hero;
		this.kills = kills;
		this.deaths = deaths;
	}
	
	public HeroName getHero()
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

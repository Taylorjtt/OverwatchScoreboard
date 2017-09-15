package Scoreboard;
import java.util.ArrayList;


public class Player {
	private String name;
	private ArrayList<PlayedHero> playedHeros;
	
	Player(String name)
	{
		this.name = name;
		playedHeros = new ArrayList<PlayedHero>();
	}
	
	public String getName()
	{
		return name;
	}
	public ArrayList<PlayedHero> getPlayedHeros()
	{
		return playedHeros;
	}
	public void gotKill(Hero hero)
	{
		boolean heroFound = false;
		for(PlayedHero h : playedHeros)
		{
			if(h.getHero().equals(hero))
			{
				h.incKills();
				heroFound = true;
				break;
			}
		}
		//if hero isn't in hero list, add it
		if(!heroFound)
		{
			playedHeros.add(new PlayedHero(hero,1,0));
		}
	}
	public void died(Hero hero)
	{
		boolean heroFound = false;
		for(PlayedHero h : playedHeros)
		{
			if(h.getHero().equals(hero))
			{
				h.incDeaths();
				heroFound = true;
				break;
			}
		}
		//if hero isn't in hero list, add it
		if(!heroFound)
		{
			playedHeros.add(new PlayedHero(hero,0,1));
		}
	}
}

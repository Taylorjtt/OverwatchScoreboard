package TemplateMatching;

import java.awt.Dimension;

import org.opencv.core.Point;

import Scoreboard.*;

public class Match 
{
	private Point position;
	private Dimension size;
	private HeroName hero;
	private TeamColor team;
	
	public Match(Point position,Dimension size, HeroName hero, TeamColor team)
	{
		this.position = position;
		this.hero = hero;
		this.team = team;
		this.setSize(size);
		
	}
	@Override
	public String toString()
	{
		String returnString = team+" team "+ hero.name();
		returnString = returnString.concat("\nPosition:"+position.toString()+"\nSize"+size.toString());
		return returnString;
	}
	public static TeamColor getTeamFromFileName(String fileName)
	{
		
		if(fileName.contains("red"))
		{
			return TeamColor.RED;
		}
		if(fileName.contains("blue"))
		{
			return TeamColor.BLUE;
		}
		System.out.println("returning Null from team");
		return null;
	}
	public static HeroName getHeroFromFilename(String fileName)
	{
		
		if(fileName.contains("Ana"))
		{
			return HeroName.ANA;
		}
		if(fileName.contains("Bastion"))
		{
			return HeroName.BASTION;
		}
		if(fileName.contains("Doomfist"))
		{
			return HeroName.DOOMFIST;
		}
		if(fileName.contains("Dva"))
		{
			return HeroName.DVA;
		}
		if(fileName.contains("Genji"))
		{
			return HeroName.GENJI;
		}
		if(fileName.contains("Hanzo"))
		{
			return HeroName.HANZO;
		}
		if(fileName.contains("Hog"))
		{
			return HeroName.ROADHOG;
		}
		if(fileName.contains("Junkrat"))
		{
			return HeroName.JUNRAT;
		}
		if(fileName.contains("Lucio"))
		{
			return HeroName.LUCIO;
		}
		if(fileName.contains("Mcree"))
		{
			return HeroName.MCREE;
		}
		if(fileName.contains("Mei"))
		{
			return HeroName.MEI;
		}
		if(fileName.contains("Mercy"))
		{
			return HeroName.MERCY;
		}
		if(fileName.contains("Orisa"))
		{
			return HeroName.ORISA;
		}
		if(fileName.contains("Pharah"))
		{
			return HeroName.PHARAH;
		}
		if(fileName.contains("Reaper"))
		{
			return HeroName.REAPER;
		}
		if(fileName.contains("Rein"))
		{
			return HeroName.REINHARDTH;
		}
		if(fileName.contains("Soldier"))
		{
			return HeroName.SOLDIER76;
		}
		if(fileName.contains("Sombra"))
		{
			return HeroName.SOMBRA;
		}
		if(fileName.contains("Sym"))
		{
			return HeroName.SYMMETRA;
		}
		if(fileName.contains("Torb"))
		{
			return HeroName.TORBJORN;
		}
		if(fileName.contains("Tracer"))
		{
			return HeroName.TRACER;
		}
		if(fileName.contains("Widow"))
		{
			return HeroName.WIDOWMKER;
		}
		if(fileName.contains("Winston"))
		{
			return HeroName.WINSTON;
		}
		if(fileName.contains("Zarya"))
		{
			return HeroName.ZARYA;
		}
		if(fileName.contains("Zen"))
		{
			return HeroName.ZENYATTA;
		}
		System.out.println("returning Null from character");
		return null;
	}
	private static String stripRedBlueFromFilename(String fileName)
	{
		String retString = fileName;
		retString =  fileName.replace("red", "");
		retString =  fileName.replace("blue", "");
		return retString;
	}
	public HeroName getHero() {
		return hero;
	}

	public void setHero(HeroName hero) {
		this.hero = hero;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public TeamColor getTeam() {
		return team;
	}

	public void setTeam(TeamColor team) {
		this.team = team;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}
}

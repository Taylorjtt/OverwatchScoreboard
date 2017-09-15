package TemplateMatching;

import java.awt.Dimension;

import org.opencv.core.Point;

import Scoreboard.*;

public class Match 
{
	private Point position;
	private Dimension size;
	private Hero hero;
	private Team team;
	
	public Match(Point position,Dimension size, Hero hero, Team team)
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
	public static Team getTeamFromFileName(String fileName)
	{
		
		if(fileName.contains("red"))
		{
			return Team.RED;
		}
		if(fileName.contains("blue"))
		{
			return Team.BLUE;
		}
		System.out.println("returning Null from team");
		return null;
	}
	public static Hero getHeroFromFilename(String fileName)
	{
		
		if(fileName.contains("Ana"))
		{
			return Hero.ANA;
		}
		if(fileName.contains("Bastion"))
		{
			return Hero.BASTION;
		}
		if(fileName.contains("Doomfist"))
		{
			return Hero.DOOMFIST;
		}
		if(fileName.contains("Dva"))
		{
			return Hero.DVA;
		}
		if(fileName.contains("Genji"))
		{
			return Hero.GENJI;
		}
		if(fileName.contains("Hanzo"))
		{
			return Hero.HANZO;
		}
		if(fileName.contains("Hog"))
		{
			return Hero.ROADHOG;
		}
		if(fileName.contains("Junkrat"))
		{
			return Hero.JUNRAT;
		}
		if(fileName.contains("Lucio"))
		{
			return Hero.LUCIO;
		}
		if(fileName.contains("Mcree"))
		{
			return Hero.MCREE;
		}
		if(fileName.contains("Mei"))
		{
			return Hero.MEI;
		}
		if(fileName.contains("Mercy"))
		{
			return Hero.MERCY;
		}
		if(fileName.contains("Orisa"))
		{
			return Hero.ORISA;
		}
		if(fileName.contains("Pharah"))
		{
			return Hero.PHARAH;
		}
		if(fileName.contains("Reaper"))
		{
			return Hero.REAPER;
		}
		if(fileName.contains("Rein"))
		{
			return Hero.REINHARDTH;
		}
		if(fileName.contains("Soldier"))
		{
			return Hero.SOLDIER76;
		}
		if(fileName.contains("Sombra"))
		{
			return Hero.SOMBRA;
		}
		if(fileName.contains("Sym"))
		{
			return Hero.SYMMETRA;
		}
		if(fileName.contains("Torb"))
		{
			return Hero.TORBJORN;
		}
		if(fileName.contains("Tracer"))
		{
			return Hero.TRACER;
		}
		if(fileName.contains("Widow"))
		{
			return Hero.WIDOWMKER;
		}
		if(fileName.contains("Winston"))
		{
			return Hero.WINSTON;
		}
		if(fileName.contains("Zarya"))
		{
			return Hero.ZARYA;
		}
		if(fileName.contains("Zen"))
		{
			return Hero.ZENYATTA;
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
	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}
}

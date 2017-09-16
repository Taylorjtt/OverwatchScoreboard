package Scoreboard;
import TemplateMatching.*;

public class InteractionPair {

	private Match match1;
	private Match match2;

	
	public InteractionPair(Match match1, Match match2)
	{
		this.match1 = match1;
		this.match2 = match2;
	}
	
	public static boolean IsAnInteractionPair(Match m1, Match m2)
	{
		double maxPosition = m1.getPosition().y + 10;
		double minPosition = m1.getPosition().y - 10;
		System.out.println("Start");
		System.out.println("M1: "+m1.getPosition().y);
		System.out.println("M2: "+m2.getPosition().y);
		System.out.println("End");
		if(m2.getPosition().y == m1.getPosition().y )
		{
			return true;
		}
		else
			return false;
		
	}
	
	public String whoDidWhat()
	{
		if(match1.getTeam().equals(match2.getTeam()))
		{
			if(match1.getPosition().x < match2.getPosition().x)
			{
				return match1.getTeam().name()+" team "+match1.getHero().name()+" Ressed "+
						match2.getHero().name();
			}
			if(match1.getPosition().x > match2.getPosition().x)
			{
				return match2.getTeam().name()+" team "+match2.getHero().name()+" Ressed "+
						match1.getHero().name();
			}
		}
		else
		{
			if(match1.getPosition().x < match2.getPosition().x)
			{
				return match1.getTeam().name()+" team "+match1.getHero().name()+" killed "+
						match2.getHero().name();
			}
			if(match1.getPosition().x > match2.getPosition().x)
			{
				return match2.getTeam().name()+" team "+match2.getHero().name()+" killed "+
						match1.getHero().name();
			}
		}
		return null;
	}
	
	
}

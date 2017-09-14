import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
	Player player = new Player("JohnJohn");

	@Test
	public void testPlayer()
	{
		assertEquals("JohnJohn", player.getName());
		
	}
	@Test
	public void testGotKill() {
		player.gotKill(Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getKills(), 1);
		assertEquals(player.getPlayedHeros().get(0).getHero(), Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getDeaths(),0);
		player.gotKill(Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getKills(), 2);
		assertEquals(player.getPlayedHeros().get(0).getHero(), Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getDeaths(),0);
		player.gotKill(Heros.ANA);
		assertEquals(player.getPlayedHeros().get(0).getKills(), 2);
		assertEquals(player.getPlayedHeros().get(0).getHero(), Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getDeaths(),0);
		assertEquals(player.getPlayedHeros().get(1).getKills(), 1);
		assertEquals(player.getPlayedHeros().get(1).getHero(), Heros.ANA);
		assertEquals(player.getPlayedHeros().get(1).getDeaths(),0);
	}

	@Test
	public void testDied() {
		player.died(Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getKills(), 0);
		assertEquals(player.getPlayedHeros().get(0).getHero(), Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getDeaths(),1);
		player.died(Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getKills(), 0);
		assertEquals(player.getPlayedHeros().get(0).getHero(), Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getDeaths(),2);
		player.died(Heros.ANA);
		assertEquals(player.getPlayedHeros().get(0).getKills(), 0);
		assertEquals(player.getPlayedHeros().get(0).getHero(), Heros.TORBJORN);
		assertEquals(player.getPlayedHeros().get(0).getDeaths(),2);
		assertEquals(player.getPlayedHeros().get(1).getKills(), 0);
		assertEquals(player.getPlayedHeros().get(1).getHero(), Heros.ANA);
		assertEquals(player.getPlayedHeros().get(1).getDeaths(),1);
	}

}

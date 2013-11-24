package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class PlayerTest{
	Player player;

	@Test
	public void constructorTest(){
		player = new player("Einar", false);

		assertEquals("player should be set to true and initialization", true, game.getPlayer());
	}

	
	//	setName() and getName() tested together
	@Test
	public void nameTest(){
		player = new player("Sveeeeinn", false);
		assertEquals("This should return an empty string, since the name has not been set yet", "", player.getName());
		player.setName("Einar")
		assertEquals("This should return the name Einar", "Einar", player.getName());

	}

	@Test
	public void winsTest(){
		player = new player("Einar", false);

		assertEquals("This should return 0, since the player hasn't won any games", 0, player.getWins());
		player.setWins(4);
		assertEquals("This hould return 4", 4, player.getWins());
	}

	@Test
	public void playerValueTest(){
		player = new player("Einar", false);
		assertEquals("This should return false", false, player.getPlayerValue());

		player.setPlayerValue(true);
		assertEquals("This should return true", true, player.getPlayerValue());

	}
}

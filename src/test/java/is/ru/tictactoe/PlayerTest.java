package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest{
	Player player = new Player("Nonni", true);

	@Test
	public void constructorTest(){
		assertEquals("Name at this point should be Nonni", "Nonni", player.getName());
		assertEquals("Wins should be initialized to 0", 0, game.getWins());
		assertEquals("PlayerValue should be true at this point", true, player.getPlayerValue());
	}

	//Test unit for setName() and getName()
	@Test
	public void nameTest(){
		player.setName("Siddi");
		assertEquals("setName should have set the name to Siddi", "Siddi", player.getName());
		player.setName("Einar")
		assertEquals("setName should have set the name to Einar", "Einar", player.getName());

	}

	@Test
	public void winsTest(){
		player.setWins(4);
		assertEquals("Wins have been set to 4", 4, player.getWins());
		player.setWins(5);
		assertEquals("Wins have been set to 5", 5, player.getWins());
		player.setWins(3);
		assertEquals("Wins have been set to 3", 3, player.getWins());
		player.setWins(12);
		assertEquals("Wins have been set to 12", 12, player.getWins());
	}

	@Test
	public void playerValueTest(){
		player.setPlayerValue(false);
		assertEquals("PlayerValue has been set to true", false, player.getPlayerValue());

		player.setPlayerValue(true);
		assertEquals("PlayerValue has been set to true", true, player.getPlayerValue());

	}
}

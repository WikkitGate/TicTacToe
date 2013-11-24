package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest{
	Player player = new Player();

	@Test
	public void constructorTest(){
		assertEquals("victories should be initialized to 0", 0, player.getVictories());
	}

	//Test unit for setName() and getName()
	@Test
	public void nameTest(){
		player.setName("Siddi");
		assertEquals("setName should have set the name to Siddi", "Siddi", player.getName());
		player.setName("Einar");
		assertEquals("setName should have set the name to Einar", "Einar", player.getName());

	}

	@Test
	public void victoryTest(){
		player.victory();
		assertEquals("Wins have been set to 1", 1, player.getVictories());
		player.victory();
		assertEquals("Wins have been set to 2", 2, player.getVictories());
		player.victory();
		player.victory();
		assertEquals("Wins have been set to 4", 4, player.getVictories());
		player.victory();
		player.victory();
		player.victory();
		assertEquals("Wins have been set to 7", 7, player.getVictories());
	}
}

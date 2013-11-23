package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest{

	@Test
	public void constructorTest(){
		player = new player();

		assertEquals("player should be set to true and initialization", true, game.getPlayer());
	}

	
	//	setName() and getName() tested together
	@Test
	public void setNameTest(){
		assertEquals("This should return an empty string, since the name has not been set yet", "", player.getName());
		player.setName("Einar")
		assertEquals("This should return the name Einar", "Einar", player.getName());

	}

	//Change the Name
	/*
	@Test
	public void setNameTest(){


	}
	*/

	//returns the number of wins won by the current player
	@Test
	public void getWinsTest(){
		return 0;
	}

	//Change the wins
	@Test
	public void setWinsTest(){

	}

	//get the number of losses
	@Test
	public void getLossesTest(){
		return 0;
	}

	//change the Losses
	@Test
	public void setLossesTest(){

	}

	//get the Elo
	@Test
	public void getEloTest(){
		return 0;
	}

	//change the Elo
	@Test
	public void setEloTest(){

	}

	//Calculates the Elo
	@Test
	public void calculateEloTest(){

	}
	

	/*
	@Test
	public void getPlayerTest(){

	}

	@Test
	public void	setPlayerTest(){

	}

	@Test
	public void testElo(){
	}
	*/
}

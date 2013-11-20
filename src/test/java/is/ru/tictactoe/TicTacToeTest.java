package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{

	@Test
	public void constructorTest(){
		TicTacToe game = new TicTacToe();

		//player
		assertEquals("player should be set to true and initialization", true, game.player);

		//movesLeft
		assertEquals("movesLeft should be set to 9", 9, game.movesLeft);

		//table
		assertEquals("table should have 3 rows", 3, game.table.length);
	}
}
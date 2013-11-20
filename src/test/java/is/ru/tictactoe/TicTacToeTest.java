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

		//table rows
		assertEquals("table should have 3 rows", 3, game.table.length);

		//table columns
		for(int row = 0; row < 3; row++){
			assertEquals("table should have 3 columns", 3, game.table[row].length);
		}
	}
}
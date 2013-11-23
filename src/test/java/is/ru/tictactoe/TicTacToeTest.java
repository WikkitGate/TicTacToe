package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{
	TicTacToe game;

	@Test
	public void constructorTest(){
		game = new TicTacToe();

		//player
		assertEquals("player should be set to true and initialization", true, game.getPlayer());

		//movesLeft
		assertEquals("movesLeft should be set to 9", 9, game.getMovesLeft());

		//number of table rows should be 3
		//int[][] gameTable = game.getTable();
		assertEquals("table should have 3 rows", 3, game.getTable().length);

		//table number of columns should be 3
		for(int row = 0; row < 3; row++){
			assertEquals("table should have 3 columns", 3, game.getTable()[row].length);
		}
	}

	@Test
	public void setPlayerTest(){
		game = new TicTacToe();
		assertEquals("Player should be true at initialization", true, game.getPlayer());
		
		game.setPlayer(false);
		assertEquals("We have set player to false", false, game.getPlayer());

		game.setPlayer(true);
		assertEquals("We have set player to true", true, game.getPlayer());
	}

	@Test
	public void setSquareTest(){
		game = new TicTacToe();
		game.setSquare(1, 1, -1);
		assertEquals("This square should be marked as X", -1, game.getTable()[1][1]);

		game.setSquare(2, 0, 0);
		assertEquals("This square should be marked as X", -1, game.getTable()[1][1]);

		game.setSquare(0, 1, 2);
		assertEquals("This square should return the number 2", 2, game.getTable()[0][1]);

	}

	@Test
	
	public void getMarkerTest(){
		game = new TicTacToe();

		assertEquals("Player is initialized to true, so setMarker should return -1", -1, game.getMarker());
		game.setPlayer(false);
		assertEquals("Player is false, so setMarker should return 0", 0, game.getMarker());
	}

	@Test
	public void swapPlayerTest(){
		game = new TicTacToe();
		game.swapPlayer();
		assertEquals("Player is false", false, game.getPlayer());
		game.swapPlayer();
		assertEquals("Player is true", true, game.getPlayer());
	}

	@Test
	public void playerSymbolTest(){
		game = new TicTacToe();
		assertEquals("Player X", 'X', game.playerSymbol());
		game.swapPlayer();
		assertEquals("Player O", 'O', game.playerSymbol());
	}

	@Test
	public void tableSymbolTest(){
		game = new TicTacToe();
		assertEquals("Square 1", "1", game.tableSymbol(game.getTable()[0][0]));

		assertEquals("Square 3", "3", game.tableSymbol(game.getTable()[0][2]));

		assertEquals("Square 1", "9", game.tableSymbol(game.getTable()[2][2]));

		game.setSquare(0, 0, -1);
		assertEquals("Square should is marked X", "X", game.tableSymbol(game.getTable()[0][0]));
		
		game.setSquare(1, 1, 0);
		assertEquals("Square should is marked O", "O", game.tableSymbol(game.getTable()[1][1]));

		game.setSquare(0, 0, 2);
		assertEquals("The number 2 should be returned, although it's an error.", "2", game.tableSymbol(game.getTable()[0][0]));
	}

	@Test
	public void genTableTest(){
		game = new TicTacToe();
		//genTable is run automatically in the constructor
		int[][] gameTable = game.getTable();
		int counter = 1;

		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				assertEquals("This square should have value " + counter, counter, gameTable[row][column]);
				counter++;
			}
		}
	}

	@Test
	public void makeMoveTest(){
		game = new TicTacToe();

		//Input must be from 1 to 9, including 9
		assertEquals("There is no square 0", false, game.makeMove(0));		
		assertEquals("There is no square 10", false, game.makeMove(10));
		assertEquals("Square 1 is free", true, game.makeMove(1));
		assertEquals("Square 1 is now occupied", false, game.makeMove(1));
		assertEquals("Square 2 is free", true, game.makeMove(2));
		assertEquals("Square 2 is now occupied", false, game.makeMove(2));
		assertEquals("Square 3 is free", true, game.makeMove(3));
		assertEquals("Square 3 is now occupied", false, game.makeMove(3));
		assertEquals("Square 4 is free", true, game.makeMove(4));
		assertEquals("Square 4 is now occupied", false, game.makeMove(4));
		assertEquals("Square 5 is free", true, game.makeMove(5));
		assertEquals("Square 5 is now occupied", false, game.makeMove(5));
		assertEquals("Square 6 is free", true, game.makeMove(6));
		assertEquals("Square 6 is now occupied", false, game.makeMove(6));
		assertEquals("Square 7 is free", true, game.makeMove(7));
		assertEquals("Square 7 is now occupied", false, game.makeMove(7));
		assertEquals("Square 8 is free", true, game.makeMove(8));
		assertEquals("Square 8 is now occupied", false, game.makeMove(8));
		assertEquals("Square 9 is free", true, game.makeMove(9));
		assertEquals("Square 9 is now occupied", false, game.makeMove(9));
	}

	@Test
	public void findWinnerTest(){
		game = new TicTacToe();
		assertEquals("Empty table", false, game.findWinner());

		game.makeMove(1);
		game.makeMove(3);
		game.makeMove(4);
		game.makeMove(6);
		game.makeMove(8);

		assertEquals("No 3 in a row", false, game.findWinner());

		game.genTable();
		for(int row = 0; row < 3; row+=3){
			game.makeMove(row + 1);
			game.makeMove(row + 2);
			game.makeMove(row + 3);
			assertEquals(true, game.findWinner());
			game.genTable();
		}
		for(int column = 0; column < 3; column+=3){
			game.makeMove(column + 1);
			game.makeMove(column + 4);
			game.makeMove(column + 7);
			assertEquals(true, game.findWinner());
			game.genTable();
		}
	}
}
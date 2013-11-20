package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe{
	public boolean player;
	public int[][] table;
	public int movesLeft;

	//Constructor
	public TicTacToe(){
		this.player = true;
		this.movesLeft = 9;
		this.table = new int[3][3];
		this.genTable();
	}

	//Sets up the table for new game
	/*public void genTable(){
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3)
		}
	}*/
}
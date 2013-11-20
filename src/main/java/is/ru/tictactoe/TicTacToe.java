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
	public void genTable(){
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++)
				this.table[row][column] = -3;
		}
	}

	//Returns the int value player should insert based on the value of player
	public int setMarker(){
		if(player)	{ return 1; }
		else		{ return 0; }
	}

	//Returns true if move was made, otherwise false
	public boolean makeMove(int chosenSquare){
		int counter = 1;
		int marker = this.setMarker();

		if(chosenSquare < 1 || chosenSquare > 9){ return false; }

		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				if(counter == chosenSquare){
					if(this.table[row][column] == -3){
						this.table[row][column] = marker;
						return true;
					}
					else{
						return false;
					}
				}
				counter++;
			}
		}
		return false;
	}
}
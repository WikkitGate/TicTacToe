package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe{
	private boolean player;
	private int[][] table;
	private int movesLeft;

	//Constructor
	public TicTacToe(){
		this.player = true;
		this.movesLeft = 9;
		this.table = new int[3][3];
		this.genTable();
	}

	//Returns this.player for your viewing pleasure
	public boolean getPlayer(){
		return this.player;
	}

	//Gives this.player a new value
	protected void setPlayer(boolean newValue){
		this.player = newValue;
	}

	public int getMovesLeft(){
		return this.movesLeft;
	}

	//Sets the value of this.movesLeft to value
	protected void setMovesLeft(int value){
		this.movesLeft = value;
	}

	//Returns this.table for viewing
	public int[][] getTable(){
		return this.table;
	}

	//Set the value of this.table[row][column] to value
	public void setSquare(int row, int column, int value){
		this.table[row][column] = value;
	}

	//Returns the int value player should insert based on the value of player
	protected int getMarker(){
		if(this.getPlayer())	{ return -1; }
		else					{ return 0; }
	}

	//Swaps the value of this.player
	protected void swapPlayer(){
		if(this.getPlayer())	{ this.setPlayer(false); }
		else					{ this.setPlayer(true); }
	}

	//returns the players character based on this.player
	protected char playerSymbol(){
		if(this.getPlayer())	{ return 'X'; }
		else					{ return 'O'; }
	}

	//returns the players character based on input
	protected String tableSymbol(int input){
		if(input == -1)			{ return "X"; }
		else if(input == 0)		{ return "O"; }
		else					{ return Integer.toString(input); }
	}

	//Sets up the table for new game
	protected void genTable(){
		int counter = 1;
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				this.setSquare(row, column, counter);
				counter++;
			}
		}
	}

	//Returns true if move was made, otherwise false
	protected boolean makeMove(int chosenSquare){
		int counter = 1;
		int marker = this.getMarker();

		if(chosenSquare < 1 || chosenSquare > 9){ return false; }

		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				if(counter == chosenSquare){
					if(this.getTable()[row][column] == counter){
						this.setSquare(row, column, marker);
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

	//Return true if winner is found otherwise false
	protected boolean findWinner(){
		//check rows for a winner
		for(int index = 0; index < 3; index++){
			if(this.getTable()[index][0] == this.getTable()[index][1] && this.getTable()[index][0] == this.getTable()[index][2]){
				return true;
			}
			if(this.getTable()[0][index] == this.getTable()[1][index] && this.getTable()[0][index] == this.getTable()[2][index]){
				return true;
			}
		}
		if(this.getTable()[0][0] == this.getTable()[1][1] && this.getTable()[0][0] == this.getTable()[2][2]){
			return true;
		}
		if(this.getTable()[0][2] == this.getTable()[1][1] && this.getTable()[0][2] == this.getTable()[2][0]){
			return true;
		}
		return false;
	}

	//Receives the chosen square from user
	protected int readInput(){
		while(true){
			try{
				Scanner input = new Scanner(System.in);
				System.out.println("Player " + this.playerSymbol() + ", choose a square or enter 1337 to quit.");
				return input.nextInt();
			}
			catch(Exception e){
				System.out.println("Error, try again");
			}
		}
	}

	//Prints this.table to screen so player can read
	protected void printTable(){
		for(int row = 0; row < 3; row++){
			if(row == 1 || row == 2){
				System.out.println("-----");
			}
			for(int column = 0; column < 3; column++){
				if(column == 1 || column == 2){
					System.out.print("|");
				}
				System.out.print(tableSymbol(this.getTable()[row][column]));
			}
			System.out.println();
		}
	}

	//handles the basic gameplay of tictactoe
	protected void playGame(){
		while(movesLeft > 0){
			this.printTable();

			int chosenSquare = this.readInput();
			if(chosenSquare == 1337){
				System.out.println("Player " + this.playerSymbol() + " ended the game!");
				break;
			}
			if(this.makeMove(chosenSquare)){
				if(this.findWinner()){
					System.out.println("Player " + this.playerSymbol() + " wins!");
					this.printTable();
					break;
				}
				movesLeft--;
				this.swapPlayer();
				System.out.println();
			}
			else{
				System.out.println("Invalid move, try again!");
			}
		}

		if(movesLeft < 1){
			System.out.println("We have a tie!");
		}
	}

	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
		game.playGame();
	}
}

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

	public boolean getPlayer(){
		return this.player;
	}

	protected void setPlayer(boolean newValue){
		this.player = newValue;
	}

	public int getMovesLeft(){
		return this.movesLeft;
	}

	protected void resetMovesLeft(){
		this.movesLeft = 9;
	}

	public int[][] getTable(){
		return this.table;
	}

	//Sets up the table for new game
	protected void genTable(){
		int counter = 1;
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				this.table[row][column] = counter;
				counter++;
			}
		}
	}

	//Returns the int value player should insert based on the value of player
	protected int getMarker(){
		if(player)	{ return -1; }
		else		{ return 0; }
	}

	//Returns true if move was made, otherwise false
	protected boolean makeMove(int chosenSquare){
		int counter = 1;
		int marker = this.getMarker();

		if(chosenSquare < 1 || chosenSquare > 9){ return false; }

		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				if(counter == chosenSquare){
					if(this.table[row][column] == counter){
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

	//Return true if winner is found otherwise false
	protected boolean findWinner(){
		//check rows for a winner
		for(int index = 0; index < 3; index++){
			if(this.table[index][0] == this.table[index][1] && this.table[index][0] == this.table[index][2]){
				return true;
			}
			if(this.table[0][index] == this.table[1][index] && this.table[0][index] == this.table[2][index]){
				return true;
			}
		}
		if(this.table[0][0] == this.table[1][1] && this.table[0][0] == this.table[2][2]){
			return true;
		}
		if(this.table[0][2] == this.table[1][1] && this.table[0][2] == this.table[2][0]){
			return true;
		}
		return false;
	}

	//Swaps the value of this.player
	protected void swapPlayer(){
		if(this.player)	{ player = false; }
		else			{ player = true; }
	}

	//returns the players character based on this.player
	protected char playerSymbol(){
		if(this.player)	{ return 'X'; }
		else			{ return 'O'; }
	}

	//returns the players character based on input
	protected String tableSymbol(int input){
		if(input == -1)		{ return "X"; }
		else if(input == 0)	{ return "O"; }
		else				{ return Integer.toString(input); }
	}

	//Receives the chosen square from user
	protected int readInput(){
		while(true){
			try{
				Scanner input = new Scanner(System.in);
				System.out.println("Player " + this.playerSymbol() + ", make your move.");
				return input.nextInt();
			}
			catch(Exception e){
				System.out.println("Error, try again");
			}
		}
	}

	protected void printTable(){
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				System.out.print(tableSymbol(this.getTable()[row][column]));
			}
			System.out.println();
		}
	}

	protected void playGame(){
		while(movesLeft > 0){
			this.printTable();

			int chosenSquare = this.readInput();

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
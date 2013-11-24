package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe{
	private Player[] players;
	private int currentPlayer;
	private int[][] table;
	private int movesLeft;

	//Constructor
	public TicTacToe(){
		this.players = new Player[2];
		this.currentPlayer = 1;
		this.movesLeft = 9;
		this.table = new int[3][3];
		this.genTable();
	}

	//Returns this.player for your viewing pleasure
	public Player[] getPlayers(){
		return this.players;
	}

	//Gives this.players new values
	public void setPlayers(){
		Player playerOne = new Player();
		Player playerTwo = new Player();

		System.out.println("Player X enter your name: ");
		playerOne.readName();
		System.out.print("Player O enter your name: ");
		playerTwo.readName();
		this.getPlayers()[0] = playerTwo;
		this.getPlayers()[1] = playerOne;
	}

	protected int getCurrentPlayer(){
		return this.currentPlayer;
	}

	protected void setCurrentPlayer(int newPlayer){
		if(newPlayer == 0 || newPlayer == 1){ this.currentPlayer = newPlayer; }
	}

	public int getMovesLeft(){
		return this.movesLeft;
	}

	public void setMovesLeft(int value){
		this.movesLeft = value;
	}

	//Sets the value of this.movesLeft to value
	protected void resetMovesLeft(){
		this.setMovesLeft(9);
	}

	protected void resetTable(){
		this.resetMovesLeft();
		this.genTable();
	}

	//Returns this.table for viewing
	public int[][] getTable(){
		return this.table;
	}

	//Set the value of this.table[row][column] to value
	public void setSquare(int row, int column, int value){
		this.getTable()[row][column] = value;
	}

	//Returns the int value player should insert based on the value of player
	protected int getMarker(){
		if(this.getCurrentPlayer() == 1)	{ return -1; }
		else								{ return 0; }
	}

	//Swaps the value of this.player
	protected void swapPlayer(){
		if(this.getCurrentPlayer() == 1)	{ this.setCurrentPlayer(0); }
		else								{ this.setCurrentPlayer(1); }
	}

	//returns the players character based on this.player
	protected char playerSymbol(){
		if(this.getCurrentPlayer() == 1)	{ return 'X'; }
		else								{ return 'O'; }
	}

	//returns the table character based on input
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
		if(this.getTable()[0][0] == this.getTable()[1][1] && this.getTable()[0][0] == this.getTable()[2][2]){ return true; }
		if(this.getTable()[0][2] == this.getTable()[1][1] && this.getTable()[0][2] == this.getTable()[2][0]){ return true; }
		return false;
	}

	//Receives the chosen square from user
	protected int readInput(){
		while(true){
			try{
				Scanner input = new Scanner(System.in);
				System.out.println();
				System.out.println(this.getPlayers()[this.getCurrentPlayer()].getName() + ", choose a square or enter 1337 to quit.");
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

	protected void printStatus(){
		System.out.println();
		for(int i = 1; i >= 0; i--){
			System.out.println(this.getPlayers()[i].getName() + " has " + this.getPlayers()[i].getVictories() + " victories");
		}
		System.out.println();
	}

	//handles the basic gameplay of tictactoe
	protected void playGame(){
		//this.setPlayers();

		while(movesLeft > 0){
			this.printTable();

			int chosenSquare = this.readInput();
			if(chosenSquare == 1337){
				System.out.println(this.getPlayers()[this.getCurrentPlayer()].getName() + " ended the game!");
				break;
			}
			if(this.makeMove(chosenSquare)){
				if(this.findWinner()){
					System.out.println(this.getPlayers()[this.getCurrentPlayer()].getName() + " wins!");
					this.getPlayers()[this.getCurrentPlayer()].victory();
					this.printTable();
					break;
				}
				this.setMovesLeft(this.getMovesLeft() - 1);
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

		this.resetTable();

		this.printStatus();
	}

	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
		game.setPlayers();
		boolean wantToPlay = true;

		while(wantToPlay){
			game.playGame();

			System.out.println("Want to play again?(y for yes)");

			try{
				Scanner in = new Scanner(System.in);
				String answer = new String();
				answer = in.next();
				if(answer != "yes"){
					wantToPlay = false;
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}

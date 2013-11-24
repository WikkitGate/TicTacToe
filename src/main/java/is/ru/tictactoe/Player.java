package is.ru.tictactoe;

import java.util.Scanner;

public class Player{
	private String name;
	private int victories;

	//Constructor takes in name and sets Wins, losses and elo to 0
	public Player(){
		this.setVictories(0);
	}

	//returns the name of the current Player
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	//Read the Name from terminal
	public void readName(){
		try{
			String name = new String();
			Scanner input = new Scanner(System.in);
			if(input.hasNext()){
				name = input.nextLine();
			}
			this.setName(name);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//returns the number of wins won by the current player
	public int getVictories(){
		return this.victories;
	}

	public void setVictories(int value){
		this.victories = value;
	}

	//Change the wins
	public void victory(){
		this.victories += 1;
	}
}

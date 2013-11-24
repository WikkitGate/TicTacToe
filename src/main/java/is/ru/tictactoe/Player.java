package is.ru.tictactoe;

public class Player{
	private String name;
	private int wins;
	private boolean playerValue;

	//Constructor takes in name and sets Wins, losses and elo to 0
	public Player(String name, boolean value){
		this.setName(name);
		this.setWins(0);
		this.setLosses(0);
		this.setPlayerValue(value);
		this.setElo(0);
	}

	//returns the name of the current Player
	public String getName(){
		return this.name;
	}

	//Change the Name
	public void setName(String name){
		this.name = name;
	}

	//returns the number of wins won by the current player
	public int getWins(){
		return this.wins;
	}

	//Change the wins
	public void setWins(int newWins){
		this.wins = newWins;
	}

	public boolean getPlayerValue(){
		return this.playerValue;
	}

	public void setPlayerValue(boolean newValue){
		this.playerValue = newValue;
	}
}

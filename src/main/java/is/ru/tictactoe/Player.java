package is.ru.tictactoe;

public class Player{
	private String name;
	private int wins;
	private int losses;
	private boolean playerValue;
	private float elo;

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
		return "";
	}

	//Change the Name
	public void setName(){

	}

	//returns the number of wins won by the current player
	public int getWins(){
		return 0;
	}

	//Change the wins
	public void setWins(){

	}

	//get the number of losses
	public int getLosses(){
		return 0;
	}

	//change the Losses
	public void setLosses(){

	}

	//get the Elo
	public float getElo(){
		return 0;
	}

	//change the Elo
	public void setElo(){

	}

	//Calculates the Elo
	public void calculateElo(){

	}
}

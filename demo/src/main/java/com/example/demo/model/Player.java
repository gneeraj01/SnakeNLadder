package com.example.demo.model;

public class Player {

	
	 private int position;
	 private String playerName;
	 
	public Player(int position, String playerName) {
		super();
		this.position = position;
		this.playerName = playerName;
	}
	
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + position;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Player [position=" + position + ", playerName=" + playerName + "]";
	}
	
	
}

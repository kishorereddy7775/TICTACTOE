package com.entities;

public class Player {
	
	private User user;
	private char symbol;
	public Player(User user, char symbol){
		this.user=user;
		this.symbol=symbol;
	}
	public User getUser() {
		return user;
	}
	public char getSymbol() {
		return symbol;
	}

}

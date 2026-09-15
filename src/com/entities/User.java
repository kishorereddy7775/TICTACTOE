package com.entities;

public class User {
	private String name;
	private long wins;
	private long totalGamesPlayed;
	public User(String name) {
		this.name=name;
		wins=0;
		totalGamesPlayed=0;
	}
	public void incrementWins() {
		wins++;
	}
	public void incrementTotalGamesPlayed() {
		totalGamesPlayed++;
	}
	public long getsWins() {
		return wins;
	}
	public long getTotalGamesPlayed() {
		return totalGamesPlayed;
	}
	public String getName() {
		return name;
	}
}

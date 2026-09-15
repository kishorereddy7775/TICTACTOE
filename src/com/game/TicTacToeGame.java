package com.game;

import java.util.ArrayDeque;
import java.util.Queue;

import com.board.Board;
import com.board.Cell;
import com.board.State;
import com.entities.Player;

public class TicTacToeGame {
	
	private Board board;
	private Queue<Player> turn;
	private Player winner;
	
	private TicTacToeGame(Builder builder) {
		board=builder.board;
		turn=builder.turn;
	}
	
	public static class Builder{
		private Board board;
		private Queue<Player> turn;
		public Builder(int size) {
			board=new Board(size);
			turn = new ArrayDeque<>();
		}
		public Builder addPlayer(Player p1) {
			turn.add(p1);
			p1.getUser().incrementTotalGamesPlayed();
			return this;
		}
		public TicTacToeGame build() {
			return new TicTacToeGame(this);
		}
	}
	
	public void move(Cell cell) {
		if(!validateCell(cell)) {
			System.out.println("Already Filled Cell");
			return;
		}
		if(!isGameActive()) {
			System.out.println("Game already Completed");
			return;
		}
		Player curPlayer=turn.poll();
		move(curPlayer,cell);
		turn.add(curPlayer);
	}
	
	private void move(Player p, Cell cell) {
		board.addMove(cell, p);
		board.updateState(p, cell);
		updateWinner(p);
	}
	private boolean validateCell(Cell cell) {
		return board.isEmpty(cell);
	}
	private boolean isGameActive() {
		return board.getState()==State.ACTIVE;
	}
	private void updateWinner(Player p) {
		if(board.getState()==State.WIN) {
			winner=p;
			winner.getUser().incrementWins();
		}
	}
	public Player getwinner() {
		return winner;
	}
	public void printBoard() {
		board.printBoard();
	}
	public boolean isDrawn() {
		return board.getState()==State.DRAW;
	}
}

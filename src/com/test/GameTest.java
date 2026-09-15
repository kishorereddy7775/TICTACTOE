package com.test;

import com.board.Cell;
import com.entities.Player;
import com.entities.User;
import com.game.TicTacToeGame;
import com.leaderBoard.LeaderBoard;

public class GameTest {

	public static void main(String[] args) {
		User u1=new User("Ramesh");
		User u2=new User("Suresh");
		User u3=new User("Mukesh");
		LeaderBoard lb=new LeaderBoard();
		lb.addUser(u1);
		lb.addUser(u2);
		lb.addUser(u3);
		Player p1=new Player(u1,'X');
		Player p2=new Player(u2,'O');
		Player p3=new Player(u3,'S');
		TicTacToeGame game=new TicTacToeGame.Builder(3).addPlayer(p1).addPlayer(p2).build();
		game.move(new Cell(0,0));
		game.move(new Cell(0,1));
		game.move(new Cell(1,1));
		game.move(new Cell(0,2));
		game.move(new Cell(2,2));
		game.move(new Cell(1,2));
		
		lb.getLearderBoard();
		
		TicTacToeGame game2=new TicTacToeGame.Builder(3).addPlayer(p2).addPlayer(p3).build();
		game2.move(new Cell(0,0));
		game2.move(new Cell(0,1));
		game2.move(new Cell(1,1));
		game2.move(new Cell(0,2));
		game2.move(new Cell(2,2));
		game2.move(new Cell(1,2));
		
		lb.getLearderBoard();
		
		TicTacToeGame game3=new TicTacToeGame.Builder(3).addPlayer(p3).addPlayer(p1).build();
		game3.move(new Cell(0,0));
		game3.move(new Cell(0,1));
		game3.move(new Cell(1,1));
		game3.move(new Cell(0,2));
		game3.move(new Cell(2,2));
		
		lb.getLearderBoard();
		
		TicTacToeGame game4=new TicTacToeGame.Builder(3).addPlayer(p3).addPlayer(p2).build();
		game4.move(new Cell(0,0));
		game4.move(new Cell(0,1));
		game4.move(new Cell(1,1));
		game4.move(new Cell(0,2));
		game4.move(new Cell(2,2));
		game4.move(new Cell(1,2));
		
		lb.getLearderBoard();
		
		TicTacToeGame game5=new TicTacToeGame.Builder(3).addPlayer(p3).addPlayer(p2).build();
		game5.move(new Cell(0,0));
		game5.move(new Cell(0,1));
		game5.move(new Cell(0,2));
		game5.move(new Cell(1,0));
		game5.move(new Cell(1,2));
		game5.move(new Cell(1,1));
		game5.move(new Cell(2,1));
		game5.move(new Cell(2,2));
		game5.move(new Cell(2,0));
		game5.printBoard();
		
		lb.getLearderBoard();
	}

}
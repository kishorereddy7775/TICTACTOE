package com.leaderBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.entities.User;

public class LeaderBoard {
	private List<User> users;
	
	public LeaderBoard(){
		users=new ArrayList<User>();
	}
	
	public void addUser(User u1) {
		users.add(u1);
	}
	
	public void getLearderBoard() {
		sortBasedOnWins();
		System.out.println("| Rank |  Name  | Wins | Total Games |");
		for(int i=0;i<users.size();i++) {
			User u=users.get(i);
			System.out.println("|   "+ (i+1) +"  | "+u.getName()+" |  "+u.getsWins()+"   |   "+u.getTotalGamesPlayed()+"   |");
		}
	}
	public void sortBasedOnWins() {
		Collections.sort(users,new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				if(u1.getsWins()==u2.getsWins())
					return Double.compare((u2.getsWins()*100.0)/u2.getTotalGamesPlayed(), (u1.getsWins()*100.0)/u1.getTotalGamesPlayed());
				return Long.compare(u2.getsWins(), u1.getsWins());
			}
		});
	}
}

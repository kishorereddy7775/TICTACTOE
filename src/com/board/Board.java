package com.board;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.entities.Player;

public class Board {
	private int size;
	private char[][] grid;
	private State state;
	private long filled;
	
	private Map<Player, Map<LineItem, Map<Integer, Integer>>> count;
	public Board(int size) {
		this.size=size;
		grid=new char[size][size];
		filled=0;
		for(int i=0;i<size;i++) {
			Arrays.fill(grid[i], '.');
		}
		state=State.ACTIVE;
		count=new HashMap<>();
	}
	public char[][] getGrid(){
		return grid;
	}
	public void addMove(Cell cell, Player p) {
		grid[cell.getRow()][cell.getCol()]=p.getSymbol();
		count.putIfAbsent(p, new HashMap<>());
		updateCount(p,LineItem.ROW,cell.getRow());
		updateCount(p,LineItem.COLUMN,cell.getCol());
		if(cell.getRow()==cell.getCol()) {
			updateCount(p, LineItem.DIAGONAL, 0);
		}
		if(cell.getRow()+cell.getCol()==size-1) {
			updateCount(p, LineItem.ANTIDIAGONAL, 0);
		}
		filled++;
	}
	public void updateState(Player p, Cell cell) {
		if(filled==size*size) {
			state=State.DRAW;
			return;
		}
		if(isWin(p,cell)) {
			state=State.WIN;
		}
	}
	private boolean isRowMatched(Player p,Cell cell) {
		return count.get(p).get(LineItem.ROW).get(cell.getRow())==size;
	}
	private boolean isColumnMatched(Player p, Cell cell) {
		return count.get(p).get(LineItem.COLUMN).get(cell.getCol())==size;
	}
	private boolean isDiagonalMatched(Player p, Cell cell) {
		return cell.getRow()==cell.getCol() && count.get(p).get(LineItem.DIAGONAL).get(0)==size;
	}
	private boolean isAntiDiagonalMatch(Player p, Cell cell) {
		return cell.getRow()+cell.getCol()==size-1 && count.get(p).get(LineItem.ANTIDIAGONAL).get(0)==size;
	}
	private boolean isWin(Player p, Cell cell) {
		return isRowMatched(p, cell) || isColumnMatched(p, cell) || isDiagonalMatched(p, cell) || isAntiDiagonalMatch(p, cell);
	}
	private void updateCount(Player p, LineItem item, int line) {
		count.get(p).putIfAbsent(item, new HashMap<>());
		count.get(p).get(item).put(line, count.get(p).get(item).getOrDefault(line, 0)+1);
	}
	public State getState() {
		return state;
	}
	
	public void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");
		}
	}
}

package com.board;

public class Cell {
	private int row;
	private int column;
	public Cell(int i, int j) {
		row=i;
		column=j;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return column;
	}
}

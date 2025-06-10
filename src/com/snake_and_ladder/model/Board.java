package com.snake_and_ladder.model;

public class Board {
	private Cell[][] cells;
	
	public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
		initializeBoard(boardSize);
		addSnakes(numberOfSnakes);
		addLadders(numberOfLadders);
	}
	
	public Cell[][] getCells() {
		return cells;
	}
	
	private void initializeBoard(int boardSize) {
		this.cells = new Cell[boardSize][boardSize];
		for(int i = 0 ; i < boardSize ; i++) {
			for(int j = 0 ; j < boardSize ; j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	private void addSnakes(int numberOfSnakes) {
		while(numberOfSnakes > 0) {
			int snakeHead = (int) Math.floor(Math.random() * (cells.length * cells.length) + 1);
			int snakeTail = (int) Math.floor(Math.random() * (cells.length * cells.length) + 1);
			Cell cell = getCell(snakeHead);
			if(cell.getJump() != null || snakeHead <= snakeTail) {
				continue;
			}
			Jump snakeObj = new Jump();
			snakeObj.setStart(snakeHead);
			snakeObj.setEnd(snakeTail);
			cell.setJump(snakeObj);
			numberOfSnakes--;
		}
	}
	
	private void addLadders(int numberOfLadders) {
		while(numberOfLadders > 0) {
			int ladderStart = (int) Math.floor(Math.random() * (cells.length * cells.length) + 1);
			int ladderEnd = (int) Math.floor(Math.random() * (cells.length * cells.length) + 1);
			Cell cell = getCell(ladderStart);
			if(cell.getJump() != null || ladderStart >= ladderEnd) {
				continue;
			}
			Jump ladderObj = new Jump();
			ladderObj.setStart(ladderStart);
			ladderObj.setEnd(ladderEnd);
			cell.setJump(ladderObj);
			numberOfLadders--;
		}
	}
	
	public Cell getCell(int position) {
		int row = position / cells.length;
		int col = position % cells.length;
		return cells[row][col];
	}
}

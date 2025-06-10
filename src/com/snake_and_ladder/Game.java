package com.snake_and_ladder;

import java.util.Deque;
import java.util.LinkedList;

import com.snake_and_ladder.model.Board;
import com.snake_and_ladder.model.Cell;
import com.snake_and_ladder.model.Jump;
import com.snake_and_ladder.model.Player;
import com.snake_and_ladder.service.Dice;

public class Game {
	private Board board;
	private Dice dice;
	private Deque<Player> playersList;
	private Player winner;
	
	public Game() {
		initializeGame();
	}
	
	private void initializeGame() {
		this.board = new Board(10, 5, 5);
		this.dice = new Dice(1);
		this.playersList = new LinkedList<>();
		this.winner = null;
		addPlayers();
	}
	
	private void addPlayers() {
		Player player1 = new Player();
		player1.setId("Virat Kohli");
		player1.setCurrentPosition(0);
		Player player2 = new Player();
		player2.setId("Sachin Tendulkar");
		player2.setCurrentPosition(0);
		this.playersList.add(player1);
		this.playersList.add(player2);
	}
	
	public void startGame() {
		while(winner == null) {
			// Check whose turn now
			Player player = getPlayerTurn();
			System.out.println("Player turn is : " + player.getId() + ", Current position is : " + player.getCurrentPosition());
			// Roll the dice
			int diceNumbers = this.dice.rollDice();
			// Get the new position
			int playerNewPosition = player.getCurrentPosition() + diceNumbers;
			playerNewPosition = jumpCheck(playerNewPosition);
			player.setCurrentPosition(playerNewPosition);
			System.out.println("After rolling the dice (number shown = " + diceNumbers +"), New position is : " + playerNewPosition + "\n");
			// Check for winning condition
			if(playerNewPosition >= this.board.getCells().length * this.board.getCells().length - 1) {
				this.winner = player;
			}
		}
		System.out.println("Winner of the game : " + winner.getId());
	}
	
	private Player getPlayerTurn() {
		Player playerTurn = this.playersList.removeFirst();
		this.playersList.addLast(playerTurn);
		return playerTurn;
	}
	
	private int jumpCheck(int playerNewPosition) {
		if(playerNewPosition > board.getCells().length * board.getCells().length - 1) {
			return playerNewPosition;
		}
		Cell cell = this.board.getCell(playerNewPosition);
		if(cell.getJump() != null && cell.getJump().getStart() == playerNewPosition) {
			String jumpBy = (cell.getJump().getEnd() > cell.getJump().getStart()) ? "Ladder" : "Snake";
			System.out.println("Jump done by : " + jumpBy);
			return cell.getJump().getEnd();
		}
		return playerNewPosition;
	}
}

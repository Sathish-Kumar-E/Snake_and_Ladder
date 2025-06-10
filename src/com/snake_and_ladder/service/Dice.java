package com.snake_and_ladder.service;

public class Dice {
	private int diceCount;
	private int min = 1;
	private int max = 6;
	
	public Dice(int diceCount) {
		this.diceCount = diceCount;
	}
	
	public int rollDice() {
		int totalSum = 0;
		int diceUsed = 0;
		while(diceUsed < diceCount) {
			totalSum += Math.floor(Math.random() * (max - min + 1) + min);
			diceUsed++;
		}
		return totalSum;
	}
}

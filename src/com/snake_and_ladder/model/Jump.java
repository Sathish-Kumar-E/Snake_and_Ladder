package com.snake_and_ladder.model;

public class Jump {
	private int start;
	private int end;
	
	public Jump() {
		super();
	}
	
	public Jump(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
}

package com.example.demo.model;

public abstract class Move {
    protected int nextPos;

    public Move(int nextPos) {
        this.nextPos = nextPos;
    }
   
	public int getNextPos() {
		return nextPos;
	}


	public void setNextPos(int nextPos) {
		this.nextPos = nextPos;
	}
    
    public abstract boolean isValidPos(int cellPos) throws Exception;
}

